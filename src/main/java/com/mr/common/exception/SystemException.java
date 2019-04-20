package com.mr.common.exception;


import com.mr.common.enums.ENMsgCode;

/**
 * @author zhanxp
 * @version 1.0 2018/11/8
 */
public class SystemException extends BaseRuntimeException {
    public SystemException(String message) {
        super(ENMsgCode.SYSTEM_EXCEPTION.getValue(), message);
    }

    public SystemException(Throwable throwable) {
        super(ENMsgCode.SYSTEM_EXCEPTION.getValue(), throwable);
    }

    public SystemException(String message, Throwable throwable) {
        super(ENMsgCode.SYSTEM_EXCEPTION.getValue(), message, throwable);
    }
}
