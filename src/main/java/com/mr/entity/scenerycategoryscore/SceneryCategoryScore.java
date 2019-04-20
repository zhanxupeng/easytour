package com.mr.entity.scenerycategoryscore;

import com.mr.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SceneryCategoryScore extends BaseEntity {

    private String sceneryId;

    private Short nature;

    private Short history;

    private Short formerResidence;

    private Short park;

    private Short architecture;

    private Short specialBlock;

    private Short movieCity;

    private Short religion;

    private Short socialCustom;
}