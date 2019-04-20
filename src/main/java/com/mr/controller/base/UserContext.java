package com.mr.controller.base;

import cn.hutool.core.lang.Assert;
import com.mr.entity.customer.Customer;

public class UserContext {
    private static ThreadLocal<Customer> threadLocal = new ThreadLocal<>();

    private UserContext() {
        throw new IllegalStateException("Utility class");
    }

    public static void setCustomer(Customer customer) {
        threadLocal.set(customer);
    }

    public static Customer getCustomer() {
        Customer customer = threadLocal.get();
        Assert.notNull(customer, "无法获取登录用户信息！");
        return customer;
    }

    public static boolean hasUserInfo() {
        Customer customer = threadLocal.get();
        return customer != null;
    }

    public static String getCustomerId() {
        return getCustomer().getId();
    }

    public static void remove() {
        threadLocal.remove();
    }
}
