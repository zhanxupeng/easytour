package com.mr.dto;

import com.mr.entity.scenery.Scenery;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhanxp
 * @version 1.0 2019/2/25
 */
@Getter
@Setter
public class SceneryRouteDTO extends Scenery {
    private Integer categoryScore = 0;
    private Integer preferenceScore = 0;

    private Double averageScore;
}
