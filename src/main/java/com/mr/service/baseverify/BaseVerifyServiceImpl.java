package com.mr.service.baseverify;

import cn.hutool.core.util.ObjectUtil;
import com.mr.controller.base.BaseVerify;
import com.mr.controller.base.UserContext;
import com.mr.entity.customer.Customer;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhanxp
 * @version 1.0  2019/2/8
 * @Description todo
 */
@Service
public class BaseVerifyServiceImpl implements BaseVerifyService {
    @Autowired
    private RedissonClient redissonClient;

    @Override
    public void verify(BaseVerify baseVerify) {
        RBucket<Customer> bucket = redissonClient.getBucket(baseVerify.getSessionId());
        Customer customer = bucket.get();
        if (ObjectUtil.isNotNull(customer)) {
            UserContext.setCustomer(customer);
        }
    }
}
