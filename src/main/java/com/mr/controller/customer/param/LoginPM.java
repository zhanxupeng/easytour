package com.mr.controller.customer.param;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author zhanxp
 * @version 1.0  2019/2/7
 * @Description todo
 */
@Getter
@Setter
@ToString
public class LoginPM implements Serializable{
    private String userName;
    private String password;
}
