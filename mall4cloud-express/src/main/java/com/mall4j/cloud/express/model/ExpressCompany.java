package com.mall4j.cloud.express.model;

import java.util.Date;

public class ExpressCompany {
    /**
     *
     */
    private String id;

    /**
     * 快递公司名
     */
    private String expressName;

    /**
     * 快递公司编码
     */
    private String expressCode;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 是否删除
     */
    private Boolean isDeleted;

    /**
     * 快递公司logo
     */
    private String logo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName == null ? null : expressName.trim();
    }

    public String getExpressCode() {
        return expressCode;
    }

    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode == null ? null : expressCode.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }
}
