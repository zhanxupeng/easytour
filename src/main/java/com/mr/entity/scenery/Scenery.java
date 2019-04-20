package com.mr.entity.scenery;

import com.mr.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class Scenery extends BaseEntity {

    private String cityCode;

    private String name;

    private String pictures;

    private String special;

    private String brief;

    private String guide;

    private BigDecimal adultTicket;

    private BigDecimal studentTicket;

    private String position;

    private Integer adviseDuration;
}