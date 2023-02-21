package com.mall4j.cloud.firmware.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ProductRegisterLog {
    /**
     *
     */
    private static final long serialVersionUID = 7216406514568703865L;

    private Integer id;

    private Integer userId;

    private String skuSn;

    private String email;

    private String productSku;

    private String productLabel;

    private String imagePath;

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy.MM.dd")
    private Date createTime = new Date();

    private Boolean succeedRegistered = Boolean.FALSE;

    private String deviceType = "UFO";


    private Boolean succeedOSRegistered = Boolean.FALSE;

    private String mac;

    //os返回的发货日期，注册流程改版增加
    private Date osDeliveryDate;

    //os返回的发货渠道，注册流程改版增加1:toc,2:tob
    private String osSalesChannel;

    //用户填写的购买渠道
    private String buyChannel;

    //用户上传的购物凭证
    private String b2bInvoice;

    //是否取消1:未取消,0:已取消
    private Integer isCancel;

    //最后一次连接的设备ota版本
    private String lastConnectDeviceVersion;

    //最后一次更新ota版本的时间
    private Date deviceVersionUpadteDate;

    //是否开启ota F3869 F3852 F3845 F053A F9656 F9632 F9649
    private Integer isOtaOpen;

    //品牌名称
    private String brandName = "foreo";

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkuSn() {
        return skuSn;
    }

    public void setSkuSn(String skuSn) {
        this.skuSn = skuSn == null ? null : skuSn.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku == null ? null : productSku.trim();
    }

    public String getProductLabel() {
        return productLabel;
    }

    public void setProductLabel(String productLabel) {
        this.productLabel = productLabel == null ? null : productLabel.trim();
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

    public Boolean getSucceedRegistered() {
        return succeedRegistered;
    }

    public void setSucceedRegistered(Boolean succeedRegistered) {
        this.succeedRegistered = succeedRegistered;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType == null ? null : deviceType.trim();
    }

    public Boolean getSucceedOSRegistered() {
        return succeedOSRegistered;
    }

    public void setSucceedOSRegistered(Boolean succeedOSRegistered) {
        this.succeedOSRegistered = succeedOSRegistered;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

    public Date getOsDeliveryDate() {
        return osDeliveryDate;
    }

    public void setOsDeliveryDate(Date osDeliveryDate) {
        this.osDeliveryDate = osDeliveryDate;
    }

    public String getOsSalesChannel() {
        return osSalesChannel;
    }

    public void setOsSalesChannel(String osSalesChannel) {
        this.osSalesChannel = osSalesChannel == null ? null : osSalesChannel.trim();
    }

    public String getBuyChannel() {
        return buyChannel;
    }

    public void setBuyChannel(String buyChannel) {
        this.buyChannel = buyChannel == null ? null : buyChannel.trim();
    }

    public String getB2bInvoice() {
        return b2bInvoice;
    }

    public void setB2bInvoice(String b2bInvoice) {
        this.b2bInvoice = b2bInvoice == null ? null : b2bInvoice.trim();
    }

    public Integer getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(Integer isCancel) {
        this.isCancel = isCancel;
    }

    public String getLastConnectDeviceVersion() {
        return lastConnectDeviceVersion;
    }

    public void setLastConnectDeviceVersion(String lastConnectDeviceVersion) {
        this.lastConnectDeviceVersion = lastConnectDeviceVersion == null ? null : lastConnectDeviceVersion.trim();
    }

    public Date getDeviceVersionUpadteDate() {
        return deviceVersionUpadteDate;
    }

    public void setDeviceVersionUpadteDate(Date deviceVersionUpadteDate) {
        this.deviceVersionUpadteDate = deviceVersionUpadteDate;
    }

    public Integer getIsOtaOpen() {
        return isOtaOpen;
    }

    public void setIsOtaOpen(Integer isOtaOpen) {
        this.isOtaOpen = isOtaOpen;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }
}
