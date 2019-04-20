package com.mr.controller.scenery.view;

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
public class SceneryRouteVM implements Serializable {
    /**
     * id列表
     */
    private List<String> idList;
    /**
     * 图片
     */
    private String image;
    /**
     * 景点数量
     */
    private Integer number;
    /**
     * 评分
     */
    private Integer score;
    /**
     * 所需时间描述
     */
    private String timeDescription;
    /**
     * 总价
     */
    private String price;
    /**
     * 路线
     */
    private String routePlan;
}
