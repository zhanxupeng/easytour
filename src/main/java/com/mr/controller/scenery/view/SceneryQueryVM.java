package com.mr.controller.scenery.view;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author zhanxp
 * @version 1.0  2019/2/10
 * @Description todo
 */
@Getter
@Setter
@ToString
public class SceneryQueryVM implements Serializable {
    private String id;
    private String image;
    private String sceneryName;
    private int averageScore;
}
