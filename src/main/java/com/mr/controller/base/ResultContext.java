package com.mr.controller.base;


import com.mr.common.enums.ENMsgCode;

import java.io.Serializable;

/**
 * 通用返回格式
 *
 * @param <T>
 */
public class ResultContext<T> implements Serializable {
    private static final long serialVersionUID = 5856432252782588227L;

    /**
     * 状态码，对应枚举ENMsgCode
     * 0：请求操作成功
     * 1：业务错误
     * 2：系统异常
     * 3：未登录
     * 4：session超时
     * 5：没有权限
     */
    private String code;

    /**
     * 提示信息
     */
    private String info;

    /**
     * 需要返回的数据
     */
    private T data;

    public static ResultContext<Void> businessFail(String info) {
        ResultContext<Void> resultContext = new ResultContext<>();
        resultContext.setCode(ENMsgCode.BUSINESS_ERROR.getValue());
        resultContext.setInfo(info);
        return resultContext;
    }

    public static ResultContext<Void> systemException(String info) {
        ResultContext<Void> resultContext = new ResultContext<>();
        resultContext.setCode(ENMsgCode.SYSTEM_EXCEPTION.getValue());
        resultContext.setInfo(info);
        return resultContext;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
