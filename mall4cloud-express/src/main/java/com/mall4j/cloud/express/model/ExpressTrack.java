package com.mall4j.cloud.express.model;

import java.util.Date;

public class ExpressTrack {
    /**
     *
     */
    private String id;

    /**
     * 快递公司编码
     */
    private String expressCode;

    /**
     * 快递公司单号
     */
    private String expressNo;

    /**
     *  0：快递收件(揽件)1.在途中 2.正在派件 3.已签收 4.派送失败 5.疑难件 6.退件签收
     */
    private String deliveryStatus;

    /**
     * 跟踪物流信息
     */
    private String expressTrack;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getExpressCode() {
        return expressCode;
    }

    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode == null ? null : expressCode.trim();
    }

    public String getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo == null ? null : expressNo.trim();
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus == null ? null : deliveryStatus.trim();
    }

    public String getExpressTrack() {
        return expressTrack;
    }

    public void setExpressTrack(String expressTrack) {
        this.expressTrack = expressTrack == null ? null : expressTrack.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
