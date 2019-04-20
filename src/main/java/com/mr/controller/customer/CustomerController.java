package com.mr.controller.customer;

import com.mr.controller.base.BaseController;
import com.mr.controller.base.BaseVerify;
import com.mr.controller.base.ResultContext;
import com.mr.controller.customer.param.LoginPM;
import com.mr.controller.customer.param.RegisterPM;
import com.mr.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhanxp
 * @version 1.0  2019/2/7
 * @Description todo
 */
@RestController
@RequestMapping("/customer")
public class CustomerController extends BaseController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/register.pub")
    public ResultContext register(RegisterPM registerPM) {
        customerService.register(registerPM);
        return success("注册成功");
    }

    @PostMapping("/login.pub")
    public ResultContext login(LoginPM loginPM) {
        return success(customerService.login(loginPM));
    }

    @PostMapping("/userInfo.do")
    public ResultContext userInfo(BaseVerify baseVerify) {
        verify(baseVerify);
        return success(customerService.userInfo());
    }
}
