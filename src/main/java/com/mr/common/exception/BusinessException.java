package com.mr.common.exception;


import com.mr.common.enums.ENMsgCode;

/**
 * @author zhanxp
 * @version 1.0 2018/11/8
 */
public class BusinessException extends BaseRuntimeException {
    public BusinessException(String message) {
        super(ENMsgCode.BUSINESS_ERROR.getValue(), message);
    }

    public BusinessException(Throwable throwable) {
        super(ENMsgCode.BUSINESS_ERROR.getValue(), throwable);
    }

    public BusinessException(String message, Throwable throwable) {
        super(ENMsgCode.BUSINESS_ERROR.getValue(), message, throwable);
    }
}
