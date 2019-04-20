package com.mr.service.customer;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.mr.common.exception.BusinessException;
import com.mr.controller.base.UserContext;
import com.mr.controller.customer.param.LoginPM;
import com.mr.controller.customer.param.RegisterPM;
import com.mr.controller.customer.view.LoginVM;
import com.mr.controller.customer.view.UserInfoVM;
import com.mr.dao.customer.CustomerMapper;
import com.mr.entity.customer.Customer;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author zhanxp
 * @version 1.0  2019/2/7
 * @Description todo
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private RedissonClient redissonClient;

    @Override
    public void register(RegisterPM registerPM) {
        Customer customer = customerMapper.getByUserName(registerPM.getUserName());
        if (ObjectUtil.isNotNull(customer)) {
            throw new BusinessException("账号已经存在，请重新输入");
        }

        customer = new Customer();
        customer.init();
        customer.setUserName(registerPM.getUserName());
        customer.setPassword(DigestUtil.sha256Hex(registerPM.getPassword() + registerPM.getUserName()));
        customer.setNickName(registerPM.getNickName());
        customer.setSex(registerPM.getSex());
        customer.setHeadPicture(null);
        customer.setGoldCoin(0);

        int insert = customerMapper.insert(customer);
        if (insert == 0) {
            throw new BusinessException("注册异常，请重新注册");
        }
    }

    @Override
    public LoginVM login(LoginPM loginPM) {
        Customer customer = customerMapper.getByUserName(loginPM.getUserName());
        if (ObjectUtil.isNull(customer)) {
            throw new BusinessException("用户名或密码错误");
        }
        if (!customer.getPassword().equals(DigestUtil.sha256Hex(loginPM.getPassword() + loginPM.getUserName()))) {
            throw new BusinessException("用户名或密码错误");
        }
        LoginVM loginVM = new LoginVM();
        loginVM.setSessionId(IdUtil.simpleUUID());
        RBucket<Customer> rBucket = redissonClient.getBucket(loginVM.getSessionId());
        rBucket.set(customer, 30, TimeUnit.MINUTES);
        loginVM.setInfo("登录成功");
        return loginVM;
    }

    @Override
    public UserInfoVM userInfo() {
        Customer customer = UserContext.getCustomer();
        UserInfoVM userInfoVM = new UserInfoVM();
        userInfoVM.setUserName(customer.getUserName());
        userInfoVM.setHeadPicture(customer.getHeadPicture());
        userInfoVM.setNickName(customer.getNickName());
        userInfoVM.setSex(customer.getSex());
        userInfoVM.setGoldCoin(customer.getGoldCoin());
        return userInfoVM;
    }
}
