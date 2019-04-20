package com.mr.dao.customer;

import com.mr.dao.base.BaseMapper;
import com.mr.entity.customer.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
    Customer getByUserName(@Param("userName") String userName);
}