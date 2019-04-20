package com.mr.controller.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author zhanxp
 * @version 1.0  2019/2/8
 * @Description todo
 */
@Getter
@Setter
@ToString
public class BaseVerify implements Serializable {
    private String sessionId;
}
