package com.mall4j.cloud.firmware.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.nacos.common.utils.StringUtils;
import com.alibaba.nacos.common.utils.UuidUtils;
import com.mall4j.cloud.api.auth.bo.UserInfoInTokenBO;
import com.mall4j.cloud.api.auth.feign.TokenFeignClient;
import com.mall4j.cloud.api.integral.constant.IntegralPointLogConstants;
import com.mall4j.cloud.api.integral.feign.UpdatePointFeignClient;
import com.mall4j.cloud.common.response.ServerResponseEntity;
import com.mall4j.cloud.firmware.async.AsyncFirmwareService;
import com.mall4j.cloud.firmware.constant.ImageConstants;
import com.mall4j.cloud.firmware.constant.MsgConstants;
import com.mall4j.cloud.firmware.dto.FirmwareRegisterRequestDto;
import com.mall4j.cloud.firmware.mapper.ProductDeviceInfoMapper;
import com.mall4j.cloud.firmware.mapper.ProductDeviceMapper;
import com.mall4j.cloud.firmware.mapper.ProductRegisterLogMapper;
import com.mall4j.cloud.firmware.model.ProductDevice;
import com.mall4j.cloud.firmware.model.ProductDeviceInfo;
import com.mall4j.cloud.firmware.model.ProductRegisterLog;
import com.mall4j.cloud.firmware.service.FirmwareService;
import com.mall4j.cloud.firmware.vo.H5UserProductDeviceVO;
import com.mall4j.cloud.firmware.vo.ResultResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FirmwareServiceImpl implements FirmwareService {
	@Autowired
	TokenFeignClient			tokenFeignClient;
	@Autowired
	ProductDeviceInfoMapper		productDeviceInfoMapper;
	@Autowired
	ProductRegisterLogMapper	productRegisterLogMapper;
	@Autowired
	ProductDeviceMapper			productDeviceMapper;
	@Autowired
	UpdatePointFeignClient		updatePointFeignClient;
	@Autowired
	AsyncFirmwareService		asyncFirmwareService;

	@Override
	public ResultResponseVO userFirmwareRegister(FirmwareRegisterRequestDto firmwareRegisterRequestDto) {
		ResultResponseVO retResponse = new ResultResponseVO();
		ServerResponseEntity<UserInfoInTokenBO> userInfoInTokenBOResponse = tokenFeignClient.checkToken(firmwareRegisterRequestDto.getToken());
		if (userInfoInTokenBOResponse.isSuccess()) {
			UserInfoInTokenBO userInfoBO = userInfoInTokenBOResponse.getData();
			if (userInfoBO == null) {
				retResponse.setResult(false);
				retResponse.setCode("84");
				retResponse.setReturnMsg(MsgConstants.missingToken());
				return retResponse;
			}
			if (firmwareRegisterRequestDto.getSn() == null || firmwareRegisterRequestDto.getSn().trim().length() == 0) {
				retResponse.setResult(false);
				retResponse.setCode("70");
				retResponse.setReturnMsg(MsgConstants.errorSN());
				return retResponse;
			}
			//sn先进到deviceInfo找productLabel
			List<ProductDeviceInfo> deviceInfoList = productDeviceInfoMapper.selectDeviceBySn(firmwareRegisterRequestDto.getSn());
			ProductDeviceInfo productDeviceInfo = CollectionUtil.isNotEmpty(deviceInfoList) ? deviceInfoList.get(0) : null;
			//找不到deviceInfo报错
			if (productDeviceInfo == null) {
				retResponse.setResult(false);
				retResponse.setCode("37");
				retResponse.setReturnMsg(MsgConstants.deviceVerifyError());
				return retResponse;
			}
			//查验设备sn是不是被注册过
			ProductRegisterLog productRegisterLog = productRegisterLogMapper.verifyUniqueLog(firmwareRegisterRequestDto.getEmail(), firmwareRegisterRequestDto.getSn());
			if (productRegisterLog == null) {
				ProductDevice productDevice = productDeviceMapper.getProductDeviceByProductLabel(productDeviceInfo.getProductLable());
				ProductRegisterLog newRegisterLog = new ProductRegisterLog();
				newRegisterLog.setUserId(userInfoBO.getUserId().toString());
				newRegisterLog.setId(UuidUtils.generateUuid());
				newRegisterLog.setEmail(firmwareRegisterRequestDto.getEmail());
				newRegisterLog.setSkuSn(firmwareRegisterRequestDto.getSn());
				newRegisterLog.setSucceedRegistered(true);
				newRegisterLog.setSucceedOSRegistered(true);
				newRegisterLog.setProductSku(productDeviceInfo.getSku());
				newRegisterLog.setProductLabel(productDeviceInfo.getProductLable());
				newRegisterLog.setMac(firmwareRegisterRequestDto.getMac());
				newRegisterLog.setIsCancel(1);
				if (productDevice != null) {
					newRegisterLog.setImagePath(productDevice.getImage());
					newRegisterLog.setDeviceType(productDevice.getDeviceType());
				} else {
					newRegisterLog.setImagePath(ImageConstants.defaultForeoImageUrl);
				}
				productRegisterLogMapper.insertSelective(newRegisterLog);
				//todo:产品注册成功，给用户增加积分
				updatePointFeignClient.updateUserPoint(userInfoBO.getUserId().toString(), "500", IntegralPointLogConstants.RefType.a_product_registration);
				//todo:另起线程去调用os的产品注册接口并更新product_sku与succeed_os_registered
				asyncFirmwareService.asyncOsRegister(productRegisterLog,userInfoBO.getUserId(),firmwareRegisterRequestDto.getEmail(),firmwareRegisterRequestDto.getSn());
			}else {
				//如果是已注册的产品又传了mac,需要判断有没有并进行更新
				if (StringUtils.isBlank(productRegisterLog.getMac())&&!StringUtils.isBlank(firmwareRegisterRequestDto.getMac())){
					productRegisterLog.setMac(firmwareRegisterRequestDto.getMac());
					productRegisterLogMapper.updateSelective(productRegisterLog);
				}
				retResponse.setCode("63");
				retResponse.setReturnMsg(MsgConstants.ufoRegisterExisted());
				packageRetData(retResponse,productRegisterLog);
			}


		}
		return retResponse;
	}

	private void packageRetData(ResultResponseVO retResponse, ProductRegisterLog productRegisterLog) {
		List<ProductDevice> allDeviceList = productDeviceMapper.selectAllProductDevice();
		List<ProductRegisterLog> productRegisterLogList = new ArrayList<>();
		productRegisterLogList.add(productRegisterLog);
		List<H5UserProductDeviceVO> h5UserProductDeviceVOList = dataTranslateVO(productRegisterLogList,allDeviceList);
	}

	private List<H5UserProductDeviceVO> dataTranslateVO(List<ProductRegisterLog> productRegisterLogList, List<ProductDevice> allDeviceList) {
		List<H5UserProductDeviceVO> retList = new ArrayList<>();
		for (ProductRegisterLog productRegisterLog : productRegisterLogList) {
			for (ProductDevice productDevice : allDeviceList) {
				if (productRegisterLog.getProductLabel().equals(productDevice.getSkuCode())){
					H5UserProductDeviceVO h5UserProductDeviceVO = new H5UserProductDeviceVO();
					h5UserProductDeviceVO.setCoolingAble(productDevice.getCoolingAble());
					h5UserProductDeviceVO.setCreateTime(productRegisterLog.getCreateTime());
					h5UserProductDeviceVO.setEmailOrPhone(productRegisterLog.getEmail());
					h5UserProductDeviceVO.setSkuSn(productRegisterLog.getSkuSn());
					h5UserProductDeviceVO.setImageDevice(productDevice.getImageDevice());
					h5UserProductDeviceVO.setImageDeviceH5(productDevice.getImageDeviceH5());
					h5UserProductDeviceVO.setImageDeviceName(productDevice.getImageDeviceName());
					h5UserProductDeviceVO.setImagePath(productRegisterLog.getImagePath());
					h5UserProductDeviceVO.setName(productDevice.getName());
					h5UserProductDeviceVO.setcName(productDevice.getcName());
					h5UserProductDeviceVO.setcColor(productDevice.getCnColor());
					h5UserProductDeviceVO.setEnName(productDevice.geteName());
					h5UserProductDeviceVO.setEnColor(productDevice.getEnColor());
					h5UserProductDeviceVO.setRgb(productDevice.getRgb());
					h5UserProductDeviceVO.setCoverPicUrl(h5UserProductDeviceVO.getCoverPicUrl());
					retList.add(h5UserProductDeviceVO);
				}
			}
		}
		return retList;
	}
}
