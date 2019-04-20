package com.mr.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author zhanxp
 * @version 1.0  2019/2/8
 * @Description todo
 */
@Getter
@Setter
@ToString
public class SceneryQueryDTO {
    private String cityCode;
    private List<String> categoryList;
    private List<String> preferenceList;
    private String weather;
}
