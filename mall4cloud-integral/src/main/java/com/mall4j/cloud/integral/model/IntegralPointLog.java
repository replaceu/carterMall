package com.mall4j.cloud.integral.model;

import java.util.Date;

public class IntegralPointLog {
    private String id;

    private String userId;

    private String logTitle;

    private String logDesc;

    private String beforeVal;

    private String changeVal;

    private String currentVal;

    private String refType;

    private String refVal;

    private Date createDate;

    private String orderId;

    private String skuId;

    private String lotteryId;

    private String usedVal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getLogTitle() {
        return logTitle;
    }

    public void setLogTitle(String logTitle) {
        this.logTitle = logTitle == null ? null : logTitle.trim();
    }

    public String getLogDesc() {
        return logDesc;
    }

    public void setLogDesc(String logDesc) {
        this.logDesc = logDesc == null ? null : logDesc.trim();
    }

    public String getBeforeVal() {
        return beforeVal;
    }

    public void setBeforeVal(String beforeVal) {
        this.beforeVal = beforeVal == null ? null : beforeVal.trim();
    }

    public String getChangeVal() {
        return changeVal;
    }

    public void setChangeVal(String changeVal) {
        this.changeVal = changeVal == null ? null : changeVal.trim();
    }

    public String getCurrentVal() {
        return currentVal;
    }

    public void setCurrentVal(String currentVal) {
        this.currentVal = currentVal == null ? null : currentVal.trim();
    }

    public String getRefType() {
        return refType;
    }

    public void setRefType(String refType) {
        this.refType = refType == null ? null : refType.trim();
    }

    public String getRefVal() {
        return refVal;
    }

    public void setRefVal(String refVal) {
        this.refVal = refVal == null ? null : refVal.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId == null ? null : skuId.trim();
    }

    public String getLotteryId() {
        return lotteryId;
    }

    public void setLotteryId(String lotteryId) {
        this.lotteryId = lotteryId == null ? null : lotteryId.trim();
    }

    public String getUsedVal() {
        return usedVal;
    }

    public void setUsedVal(String usedVal) {
        this.usedVal = usedVal == null ? null : usedVal.trim();
    }
}
