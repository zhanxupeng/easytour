package com.mr.controller.scenery.param;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhanxp
 * @version 1.0  2019/3/9
 * @Description todo
 */
@Getter
@Setter
public class SceneryRoutePM implements Serializable {
    private String city;
    private List<String> categoryList;
    private List<String> preferenceList;
    private String weather;
}
