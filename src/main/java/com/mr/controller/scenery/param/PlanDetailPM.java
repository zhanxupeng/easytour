package com.mr.controller.scenery.param;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhanxp
 * @version 1.0  2019/3/10
 * @Description todo
 */
@Getter
@Setter
public class PlanDetailPM implements Serializable {
    private List<String> idList;
    private List<String> categoryList;
    private List<String> preferenceList;
    private String weather;
}
