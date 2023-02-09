package com.mall4j.cloud.express.model;

import java.util.Date;

public class ExpressOrder {

    private String id;

    private String orderId;

    private String orderType;

    private String expressId;

    private String expressName;

    private String expressTradeNo;

    String expressDesc;

    String expressImg;

    private String contractNo;

    private String reason;

    private String description;

    private String uploadImg;

    String warehouseRejectReason;

    String beRejectReason;

    private Date createDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    public String getExpressId() {
        return expressId;
    }

    public void setExpressId(String expressId) {
        this.expressId = expressId == null ? null : expressId.trim();
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName == null ? null : expressName.trim();
    }

    public String getExpressTradeNo() {
        return expressTradeNo;
    }

    public void setExpressTradeNo(String expressTradeNo) {
        this.expressTradeNo = expressTradeNo == null ? null : expressTradeNo.trim();
    }

    public String getExpressDesc() {
        return expressDesc;
    }

    public void setExpressDesc(String expressDesc) {
        this.expressDesc = expressDesc == null ? null : expressDesc.trim();
    }

    public String getExpressImg() {
        return expressImg;
    }

    public void setExpressImg(String expressImg) {
        this.expressImg = expressImg == null ? null : expressImg.trim();
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getUploadImg() {
        return uploadImg;
    }

    public void setUploadImg(String uploadImg) {
        this.uploadImg = uploadImg == null ? null : uploadImg.trim();
    }

    public String getWarehouseRejectReason() {
        return warehouseRejectReason;
    }

    public void setWarehouseRejectReason(String warehouseRejectReason) {
        this.warehouseRejectReason = warehouseRejectReason == null ? null : warehouseRejectReason.trim();
    }

    public String getBeRejectReason() {
        return beRejectReason;
    }

    public void setBeRejectReason(String beRejectReason) {
        this.beRejectReason = beRejectReason == null ? null : beRejectReason.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
