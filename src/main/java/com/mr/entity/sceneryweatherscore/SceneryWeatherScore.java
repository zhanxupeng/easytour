package com.mr.entity.sceneryweatherscore;

import com.mr.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SceneryWeatherScore extends BaseEntity{
    private String sceneryId;

    private Short sunny;

    private Short cloudy;

    private Short rain;
}