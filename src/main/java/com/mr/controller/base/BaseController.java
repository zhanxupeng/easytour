package com.mr.controller.base;


import com.mr.common.enums.ENMsgCode;
import com.mr.service.baseverify.BaseVerifyService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhanxp
 * @version 1.0 2018/11/8
 */
public class BaseController {
    @Autowired
    private BaseVerifyService baseVerifyService;
    private final static String SUCCESS = "操作成功";

    protected <T> ResultContext<T> success(T t) {
        ResultContext<T> resultContext = new ResultContext<>();
        resultContext.setCode(ENMsgCode.SUCCESS.getValue());
        resultContext.setData(t);
        resultContext.setInfo(SUCCESS);
        return resultContext;
    }

    protected ResultContext<Void> success() {
        ResultContext<Void> resultContext = new ResultContext<>();
        resultContext.setCode(ENMsgCode.SUCCESS.getValue());
        resultContext.setInfo(SUCCESS);
        return resultContext;
    }

    protected void verify(BaseVerify baseVerify) {
        baseVerifyService.verify(baseVerify);
    }
}
