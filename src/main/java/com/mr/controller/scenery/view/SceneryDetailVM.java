package com.mr.controller.scenery.view;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author zhanxp
 * @version 1.0  2019/2/15
 * @Description todo
 */
@Getter
@Setter
@ToString
public class SceneryDetailVM implements Serializable {
    private List<String> pictureList;
    private String name;
    private int categoryScore = 0;
    private int preferenceScore = 0;
    private int weatherScore = 0;
    private String special;
    private String brief;
    private String guide;
    private BigDecimal adultTicket;
    private BigDecimal studentTicket;
}
