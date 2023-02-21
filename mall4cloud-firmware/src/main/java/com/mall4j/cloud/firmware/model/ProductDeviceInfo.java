package com.mall4j.cloud.firmware.model;

import java.util.Date;

public class ProductDeviceInfo {
    private Integer id;

    private String englishName;

    private String chineseName;

    private String sku;

    private String sn;

    private String rgb;

    private String productLable;

    private String mac;

    private String enColor;

    private String cnColor;

    /**
     * 数据库是否有维护到，即表foreo_product_device是否有匹配记录，1、维护，0未维护
     **/
    private Integer isMatcher;

    //os返回的发货日期，注册流程改版增加
    private Date osDeliveryDate;

    //os返回的发货渠道，注册流程改版增加1:toc,2:tob
    private String osSalesChannel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName == null ? null : englishName.trim();
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName == null ? null : chineseName.trim();
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku == null ? null : sku.trim();
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getRgb() {
        return rgb;
    }

    public void setRgb(String rgb) {
        this.rgb = rgb == null ? null : rgb.trim();
    }

    public String getProductLable() {
        return productLable;
    }

    public void setProductLable(String productLable) {
        this.productLable = productLable == null ? null : productLable.trim();
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

    public String getEnColor() {
        return enColor;
    }

    public void setEnColor(String enColor) {
        this.enColor = enColor == null ? null : enColor.trim();
    }

    public String getCnColor() {
        return cnColor;
    }

    public void setCnColor(String cnColor) {
        this.cnColor = cnColor == null ? null : cnColor.trim();
    }

    public Integer getIsMatcher() {
        return isMatcher;
    }

    public void setIsMatcher(Integer isMatcher) {
        this.isMatcher = isMatcher;
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
}
