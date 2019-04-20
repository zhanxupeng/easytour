package com.mr.controller.customer.view;

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
public class LoginVM implements Serializable {
    private String info;
    private String sessionId;
}
