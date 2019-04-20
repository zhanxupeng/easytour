package com.mr.controller.base;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhanxp
 * @version 1.0  2019/2/17
 * @Description todo
 */
@ControllerAdvice
public class ExceptionController {

    /**
     * 全局异常捕捉处理
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultContext errorHandler(Exception ex) {
        ex.printStackTrace();
        return ResultContext.systemException(ex.getMessage());
    }
}
