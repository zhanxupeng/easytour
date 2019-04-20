package com.mr.dto;

import com.mr.entity.scenery.Scenery;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zhanxp
 * @version 1.0  2019/2/11
 * @Description todo
 */
@Getter
@Setter
@ToString
public class SceneryDTO extends Scenery {
    private Integer categoryScore = 0;
    private Integer preferenceScore = 0;
    private Integer weatherScore = 0;
}
