package com.mall4j.cloud.firmware.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;
import java.util.regex.Pattern;

public class H5UserProductDeviceVO implements Serializable {
    private static Pattern pattern = Pattern.compile("^(?<first>(\\w+[ ])*)(?<mid>[\\u4e00-\\u9fa5a-zA-Z0-9]+)(?<last>（.+）)$");

    private static final long serialVersionUID = 1L;

    private String name;

    private String skuSn;

    private String emailOrPhone;

    private String imagePath;

    private Date createTime;

    @JsonFormat(locale = "zn", timezone = "GMT+8", pattern = "yyyy.MM.dd")
    private Date registerTime;

    private Integer coolingAble = 1;// 是否支持冷却 1是，0否

    private String rgb;

    private String imageBackground;

    private String imageDevice;

    private String imageDeviceName;

    private String imageDeviceH5;

    private String firmwareVersion;

    @JsonIgnore
    private Integer warrantyStatusId;

    private String warrantyStatus;

    private String firstName;

    private String midName;

    private String lastName;

    private String	cName;
    private String	cColor;
    private String	enName;
    private String	enColor;
    private String	mac;
    private String	coverPicUrl;

    //luna3唤醒计划
    private String	activityOrderId;
    private String	activityOrderStatus;
    private String	productId;
    private String	isLuna3;

    String isSupportWarranty;

    public static Pattern getPattern() {
        return pattern;
    }

    public static void setPattern(Pattern pattern) {
        H5UserProductDeviceVO.pattern = pattern;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSkuSn() {
        return skuSn;
    }

    public void setSkuSn(String skuSn) {
        this.skuSn = skuSn == null ? null : skuSn.trim();
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getRgb() {
        return rgb;
    }

    public void setRgb(String rgb) {
        this.rgb = rgb == null ? null : rgb.trim();
    }

    public Integer getWarrantyStatusId() {
        return warrantyStatusId;
    }

    public void setWarrantyStatusId(Integer warrantyStatusId) {
        this.warrantyStatusId = warrantyStatusId;
    }

    public String getWarrantyStatus() {
        return warrantyStatus;
    }

    public void setWarrantyStatus(String warrantyStatus) {
        this.warrantyStatus = warrantyStatus == null ? null : warrantyStatus.trim();
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName == null ? null : midName.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getEmailOrPhone() {
        return emailOrPhone;
    }

    public void setEmailOrPhone(String emailOrPhone) {
        this.emailOrPhone = emailOrPhone == null ? null : emailOrPhone.trim();
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath == null ? null : imagePath.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCoolingAble() {
        return coolingAble;
    }

    public void setCoolingAble(Integer coolingAble) {
        this.coolingAble = coolingAble;
    }

    public String getImageBackground() {
        return imageBackground;
    }

    public void setImageBackground(String imageBackground) {
        this.imageBackground = imageBackground == null ? null : imageBackground.trim();
    }

    public String getImageDevice() {
        return imageDevice;
    }

    public void setImageDevice(String imageDevice) {
        this.imageDevice = imageDevice == null ? null : imageDevice.trim();
    }

    public String getImageDeviceName() {
        return imageDeviceName;
    }

    public void setImageDeviceName(String imageDeviceName) {
        this.imageDeviceName = imageDeviceName == null ? null : imageDeviceName.trim();
    }

    public String getImageDeviceH5() {
        return imageDeviceH5;
    }

    public void setImageDeviceH5(String imageDeviceH5) {
        this.imageDeviceH5 = imageDeviceH5 == null ? null : imageDeviceH5.trim();
    }

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion == null ? null : firmwareVersion.trim();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? null : firstName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcColor() {
        return cColor;
    }

    public void setcColor(String cColor) {
        this.cColor = cColor == null ? null : cColor.trim();
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName == null ? null : enName.trim();
    }

    public String getEnColor() {
        return enColor;
    }

    public void setEnColor(String enColor) {
        this.enColor = enColor == null ? null : enColor.trim();
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

    public String getCoverPicUrl() {
        return coverPicUrl;
    }

    public void setCoverPicUrl(String coverPicUrl) {
        this.coverPicUrl = coverPicUrl == null ? null : coverPicUrl.trim();
    }

    public String getActivityOrderId() {
        return activityOrderId;
    }

    public void setActivityOrderId(String activityOrderId) {
        this.activityOrderId = activityOrderId == null ? null : activityOrderId.trim();
    }

    public String getActivityOrderStatus() {
        return activityOrderStatus;
    }

    public void setActivityOrderStatus(String activityOrderStatus) {
        this.activityOrderStatus = activityOrderStatus == null ? null : activityOrderStatus.trim();
    }

    public String getIsLuna3() {
        return isLuna3;
    }

    public void setIsLuna3(String isLuna3) {
        this.isLuna3 = isLuna3 == null ? null : isLuna3.trim();
    }

    public String getIsSupportWarranty() {
        return isSupportWarranty;
    }

    public void setIsSupportWarranty(String isSupportWarranty) {
        this.isSupportWarranty = isSupportWarranty == null ? null : isSupportWarranty.trim();
    }
}
