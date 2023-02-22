package com.mall4j.cloud.firmware.service.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mall4j.cloud.api.auth.feign.AccountFeignClient;
import com.mall4j.cloud.api.user.feign.UserAddrFeignClient;
import com.mall4j.cloud.api.user.feign.UserFeignClient;
import com.mall4j.cloud.api.user.vo.UserApiVO;
import com.mall4j.cloud.common.exception.Mall4cloudException;
import com.mall4j.cloud.common.response.ServerResponseEntity;
import com.mall4j.cloud.firmware.mapper.ProductApiFailureLogMapper;
import com.mall4j.cloud.firmware.model.ProductApiFailureLog;
import com.mall4j.cloud.firmware.service.ProductApiService;
import jodd.http.HttpBrowser;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProductApiServiceImpl implements ProductApiService {
	@Autowired
	UserFeignClient				userFeignClient;
	@Autowired
	ProductApiFailureLogMapper	productApiFailureLogMapper;

	private final static String	salt				= "NyFoeDabpHGR33n";
	private final static String	firmwareRegisterUrl	= "http://jerson-astrid-test-branch.astrid.lelo.com/api/registered-product";
	private final static String	source				= "mobile_app_china";

	@Override
	public String callFirmwareRegister(Long userId, String email, String sn) {
		HttpBrowser browser = new HttpBrowser();
		HmacUtils mac = new HmacUtils(HmacAlgorithms.HMAC_SHA_256, salt);
		String param = "_format=json&code_type=sn&code=" + sn + "&user_provider_name=foreo_app_china&user_provider_id=" + email;
		String authorization = mac.hmacHex(param);
		HttpRequest req = HttpRequest.post(firmwareRegisterUrl).body(param);
		req.header("Source", source);
		req.header("Authorization", authorization);
		req.header("Content-type", "application/x-www-form-urlencoded");
		String jsonTxt = null;
		try {
			HttpResponse res = browser.sendRequest(req);
			//记录一下API请求报错日志
			jsonTxt = fetchFailureLog(userId, param, res, 1);
			if (res.statusCode() != 200) {
				jsonTxt += "HONG" + res.statusCode();
			}
		} catch (Exception e) {

		}
		return jsonTxt;
	}

	private String fetchFailureLog(Long userId, String requestBody, HttpResponse response, int apiMethod) {
		ServerResponseEntity<UserApiVO> userData = userFeignClient.getUserData(userId);
		UserApiVO user = userData.getData();
		String jsonTxt = "";
		try {
			if (response.statusCode() == 500) {
				ProductApiFailureLog productApiFailureLog = new ProductApiFailureLog();
				productApiFailureLog.setUserId(user.getUserId().toString());
				productApiFailureLog.setUserPhone(user.getMobile());
				productApiFailureLog.setApiMethod(apiMethod);
				productApiFailureLog.setRequestBody(requestBody);
				productApiFailureLog.setResponseStatus(response.statusCode() + " " + response.statusPhrase());
				productApiFailureLog.setTime(new Date());
				productApiFailureLog.setErrorMsg(quitHtml(jsonTxt));
				productApiFailureLogMapper.insertSelective(productApiFailureLog);

			} else {
				jsonTxt = new String(response.bodyBytes(), "UTF-8");
				JsonParser jsonParse = new JsonParser();
				JsonObject returnJson = (JsonObject) jsonParse.parse(jsonTxt);
				if (null == returnJson.get("data")) {

					ProductApiFailureLog apiFailureLog = new ProductApiFailureLog();
					apiFailureLog.setUserId(user.getUserId().toString());
					apiFailureLog.setUserPhone(user.getMobile());
					apiFailureLog.setApiMethod(apiMethod);
					apiFailureLog.setRequestBody(requestBody);
					apiFailureLog.setResponseStatus(response.statusCode() + " " + response.statusPhrase());
					apiFailureLog.setTime(new Date());
					JsonArray errArray = returnJson.getAsJsonArray("errors");
					if (null != errArray) {
						String errorCode = errArray.get(0).getAsJsonObject().get("status").getAsString();
						String errorTitle = errArray.get(0).getAsJsonObject().get("title").getAsString();
						String errorMsg = errArray.get(0).getAsJsonObject().get("description").getAsString();
						apiFailureLog.setErrorTile(errorTitle);
						apiFailureLog.setErrorStatus(errorCode);
						apiFailureLog.setErrorMsg(errorMsg);
					} else {
						apiFailureLog.setErrorMsg(quitHtml(jsonTxt));
					}
					productApiFailureLogMapper.insertSelective(apiFailureLog);
				}
			}
		} catch (Exception e) {
			throw new Mall4cloudException("请求第三方API出错");
		}
		return jsonTxt;
	}

	private String quitHtml(String str) {
		String txt = str.replaceAll("</?[^>]+>", ""); //剔出<html>的标签
		return txt;
	}
}
