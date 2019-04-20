package com.mr.controller.commonsense.param;

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
public class SenseQueryPM implements Serializable {
    private Integer currentPage;
    private Integer pageSize;
}
