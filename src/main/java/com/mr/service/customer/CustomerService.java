package com.mr.service.customer;

import com.mr.controller.customer.param.LoginPM;
import com.mr.controller.customer.param.RegisterPM;
import com.mr.controller.customer.view.LoginVM;
import com.mr.controller.customer.view.UserInfoVM;

/**
 * @author zhanxp
 * @version 1.0  2019/2/7
 * @Description todo
 */
public interface CustomerService {
    void register(RegisterPM registerPM);

    LoginVM login(LoginPM loginPM);

    UserInfoVM userInfo();
}
