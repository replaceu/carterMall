package com.mall4j.cloud.firmware.model;

import java.io.Serializable;

public class ProductDevice implements Serializable {
    private static final long serialVersionUID = -4515970306936252861L;

    private String id;

    private String skuCode;

    private String name;

    private String cName;

    private String eName;

    private String cnColor;

    private String enColor;

    private String image;

    private Integer coolingAble = 1;// 是否支持冷却 1是，0否

    private String	imageBackground;

    private String	imageDevice;

    private String	imageDeviceName;

    private String imageDeviceH5;

    private String rgb;

    private Integer isSupportWarranty = 1;// 是否支持质保,1表示质保

    private String categoryId;

    private String	categoryName;

    private String	groupId;

    private String	groupName;

    private String	collectionId;

    private String	collectionName;

    private String	deviceType;

    private Boolean	isBluetooth;

    private String activeAnimation;

    //质保因为图片模糊加的字段，呵呵
    String warrantyClaimImg;

    //注册流程改版新增的一个图片
    String	coverPicUrl;

    String	searchPicUrl;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode == null ? null : skuCode.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRgb() {
        return rgb;
    }

    public void setRgb(String rgb) {
        this.rgb = rgb == null ? null : rgb.trim();
    }

    public Integer getIsSupportWarranty() {
        return isSupportWarranty;
    }

    public void setIsSupportWarranty(Integer isSupportWarranty) {
        this.isSupportWarranty = isSupportWarranty;
    }

    public String getWarrantyClaimImg() {
        return warrantyClaimImg;
    }

    public void setWarrantyClaimImg(String warrantyClaimImg) {
        this.warrantyClaimImg = warrantyClaimImg == null ? null : warrantyClaimImg.trim();
    }

    public String getSearchPicUrl() {
        return searchPicUrl;
    }

    public void setSearchPicUrl(String searchPicUrl) {
        this.searchPicUrl = searchPicUrl == null ? null : searchPicUrl.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName == null ? null : eName.trim();
    }

    public String getCnColor() {
        return cnColor;
    }

    public void setCnColor(String cnColor) {
        this.cnColor = cnColor == null ? null : cnColor.trim();
    }

    public String getEnColor() {
        return enColor;
    }

    public void setEnColor(String enColor) {
        this.enColor = enColor == null ? null : enColor.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
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

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId == null ? null : collectionId.trim();
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName == null ? null : collectionName.trim();
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType == null ? null : deviceType.trim();
    }

    public Boolean getBluetooth() {
        return isBluetooth;
    }

    public void setBluetooth(Boolean bluetooth) {
        isBluetooth = bluetooth;
    }

    public String getActiveAnimation() {
        return activeAnimation;
    }

    public void setActiveAnimation(String activeAnimation) {
        this.activeAnimation = activeAnimation == null ? null : activeAnimation.trim();
    }

    public String getCoverPicUrl() {
        return coverPicUrl;
    }

    public void setCoverPicUrl(String coverPicUrl) {
        this.coverPicUrl = coverPicUrl == null ? null : coverPicUrl.trim();
    }
}
