package com.mall4j.cloud.express.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "ExpressTrackDTO", description = "快递物流跟踪类")
public class ExpressTrackDTO {
    @ApiModelProperty(hidden = true)
    private String id;

    @ApiModelProperty(value = "快递公司code", example = "zto")
    private String expressCode;

    @ApiModelProperty(value = "快递单号", example = "75141112895701")
    private String expressNo;

    @ApiModelProperty(hidden = true)
    private Date createDate;

    @ApiModelProperty(hidden = true)
    private String expressTrack;

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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getExpressTrack() {
        return expressTrack;
    }

    public void setExpressTrack(String expressTrack) {
        this.expressTrack = expressTrack == null ? null : expressTrack.trim();
    }
}
