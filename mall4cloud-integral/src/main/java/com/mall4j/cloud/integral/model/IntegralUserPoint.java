package com.mall4j.cloud.integral.model;

import java.util.Date;

public class IntegralUserPoint {
    private String id;

    private String userId;

    private String integralPoint;

    private Date createDate;

    private Integer version;

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

    public String getIntegralPoint() {
        return integralPoint;
    }

    public void setIntegralPoint(String integralPoint) {
        this.integralPoint = integralPoint == null ? null : integralPoint.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
