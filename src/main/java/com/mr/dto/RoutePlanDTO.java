package com.mr.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author zhanxp
 * @version 1.0 2019/2/25
 */
@Getter
@Setter
public class RoutePlanDTO {
    private String city;
    private List<String> categoryList;
    private List<String> preferenceList;
}
