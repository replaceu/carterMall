package com.mall4j.cloud.express.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class ExpressInfoDTO {

	/**
	 * 快递单号
	 */
	@ApiModelProperty("快递单号")
	String								number;
	/**
	 * 快递公司code
	 */
	@ApiModelProperty("快递公司code")
	String								type;
	/**
	 * 物流跟踪信息
	 */
	@ApiModelProperty("物流跟踪信息")
	List<ExpressRspDTO.ExpressTrack>	list;
	/**
	 *  0：快递收件(揽件)1.在途中 2.正在派件 3.已签收 4.派送失败 5.疑难件 6.退件签收  
	 */
	@ApiModelProperty(" 0：快递收件(揽件)1.在途中 2.正在派件 3.已签收 4.派送失败 5.疑难件 6.退件签收  ")
	String								deliverystatus;
	/**
	 * 1.是否签收
	 */
	@ApiModelProperty("1.是否签收")
	String								issign;
	/**
	 * 快递公司
	 */
	@ApiModelProperty("快递公司")
	String								expName;
	/**
	 * 快递公司网址
	 */
	@ApiModelProperty("快递公司网址")
	String								expSite;
	/**
	 * 快递公司联系电话
	 */
	@ApiModelProperty("快递公司联系电话")
	String								expPhone;
	/**
	 * 快递公司log
	 */
	@ApiModelProperty("快递公司log")
	String								logo;
	/**
	 * 快递员姓名
	 */
	@ApiModelProperty("快递员姓名")
	String								courier;
	/**
	 * 快递员联系手机
	 */
	@ApiModelProperty("快递员联系手机")
	String								courierPhone;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<ExpressRspDTO.ExpressTrack> getList() {
		return list;
	}

	public void setList(List<ExpressRspDTO.ExpressTrack> list) {
		this.list = list;
	}

	public String getDeliverystatus() {
		return deliverystatus;
	}

	public void setDeliverystatus(String deliverystatus) {
		this.deliverystatus = deliverystatus;
	}

	public String getIssign() {
		return issign;
	}

	public void setIssign(String issign) {
		this.issign = issign;
	}

	public String getExpName() {
		return expName;
	}

	public void setExpName(String expName) {
		this.expName = expName;
	}

	public String getExpSite() {
		return expSite;
	}

	public void setExpSite(String expSite) {
		this.expSite = expSite;
	}

	public String getExpPhone() {
		return expPhone;
	}

	public void setExpPhone(String expPhone) {
		this.expPhone = expPhone;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getCourier() {
		return courier;
	}

	public void setCourier(String courier) {
		this.courier = courier;
	}

	public String getCourierPhone() {
		return courierPhone;
	}

	public void setCourierPhone(String courierPhone) {
		this.courierPhone = courierPhone;
	}
}
