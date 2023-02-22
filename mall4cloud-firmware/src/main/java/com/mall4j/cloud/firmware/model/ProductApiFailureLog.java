package com.mall4j.cloud.firmware.model;

import java.util.Date;

public class ProductApiFailureLog {

    private static final long serialVersionUID = 1L;

    private String id;

    private String userId;

    private String userPhone;

    private String responseStatus;

    private int apiMethod; //1 注册  2验证 3sn获取产品

    private String requestBody;

    private String errorStatus;

    private String errorTile;

    private String errorMsg;

    private Date time;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus == null ? null : responseStatus.trim();
    }

    public int getApiMethod() {
        return apiMethod;
    }

    public void setApiMethod(int apiMethod) {
        this.apiMethod = apiMethod;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody == null ? null : requestBody.trim();
    }

    public String getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(String errorStatus) {
        this.errorStatus = errorStatus == null ? null : errorStatus.trim();
    }

    public String getErrorTile() {
        return errorTile;
    }

    public void setErrorTile(String errorTile) {
        this.errorTile = errorTile == null ? null : errorTile.trim();
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg == null ? null : errorMsg.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
