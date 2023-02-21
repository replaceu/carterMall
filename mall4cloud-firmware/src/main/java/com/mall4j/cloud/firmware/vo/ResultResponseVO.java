package com.mall4j.cloud.firmware.vo;

import com.google.common.collect.Maps;
import com.mall4j.cloud.firmware.constant.MsgConstants;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Map;

public class ResultResponseVO implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -2917235995989041307L;

    private boolean result = true;//true代表请求调用成功，false代表请求异常

    private String code = "00"; // 00代表成功返回，99代表代码异常，输入参数有误

    private String returnMsg; // 提示信息

    private Map<String, Object> returnData = Maps.newHashMap();

    public ResultResponseVO(boolean result, String code, String returnMsg) {
        this.result = result;
        this.code = code;
        this.returnMsg = returnMsg;
    }

    public ResultResponseVO() {
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public Map<String, Object> getReturnData() {
        return returnData;
    }

    public void setReturnData(Map<String, Object> returnData) {
        this.returnData = returnData;
    }

    public static ResultResponseVO failureServer() {
        ResultResponseVO response = new ResultResponseVO();
        response.setReturnMsg(MsgConstants.throwException());
        response.setCode("99");
        response.setResult(false);
        return response;
    }

    public static ResultResponseVO ok(Object data, String mapKey) {
        ResultResponseVO response = new ResultResponseVO();
        response.setReturnMsg(MsgConstants.requestSuccess());

        if (data == null || StringUtils.isBlank(mapKey)) { return response; }
        response.getReturnData().put(mapKey, data);
        return response;
    }

    public static ResultResponseVO ok() {
        return ok("", "");
    }

    /**
     * @return com.foreo.ufo.vo.ResultResponse
     * @Author Carter
     * @Description 参数错误
     * @Date 2018/9/10 17:26
     * @Param []
     **/
    public static ResultResponseVO parameterError() {
        ResultResponseVO response = new ResultResponseVO();
        response.setReturnMsg(MsgConstants.errorRequestParam());
        response.setCode("98");
        response.setResult(false);
        return response;
    }

    /**
     * @Author Carter
     * @Description
     * @Date 2018/9/13 20:31
     * @Param [message]
     * @return com.foreo.ufo.vo.ResultResponse
     **/
    public static ResultResponseVO parameterError(String message) {
        ResultResponseVO response = new ResultResponseVO();
        response.setReturnMsg(message);
        response.setCode("98");
        response.setResult(false);
        return response;
    }

    public static ResultResponseVO returnError(String retMsg) {
        if (retMsg.indexOf("\\|") == -1) { return parameterError(retMsg); }

        ResultResponseVO response = new ResultResponseVO();
        response.setReturnMsg(retMsg.split("\\|")[1]);
        response.setCode(retMsg.split("\\|")[0]);
        response.setResult(false);
        return response;
    }
}
