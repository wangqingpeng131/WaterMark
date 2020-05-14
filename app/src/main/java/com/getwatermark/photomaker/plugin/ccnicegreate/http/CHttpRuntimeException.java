package com.getwatermark.photomaker.plugin.ccnicegreate.http;

/**
 * Created by yangshuai on 2017/8/19.
 * {link http://afra55.github.io}
 * {"errCode":"4000","errMsg":"0"}
 */

public class CHttpRuntimeException extends RuntimeException {
    private String errCode;
    private String errMsg;


    public CHttpRuntimeException() {

    }

    public CHttpRuntimeException(String errorCode, String errorMsg) {
        super(errorMsg);
        this.errCode = errorCode;
        this.errMsg = errorMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
