package com.mr.controller.scenery.param;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhanxp
 * @version 1.0  2019/2/8
 * @Description todo
 */
@Getter
@Setter
@ToString
public class SceneryQueryPM implements Serializable {
    private String city;
    private List<String> categoryList;
    private List<String> preferenceList;
    private String weather;
}
