package com.mr.entity.scenerypreferencescore;

import com.mr.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SceneryPreferenceScore extends BaseEntity {

    private String sceneryId;

    private Short entertainment;

    private Short quiet;

    private Short natural;

    private Short history;

    private Short lively;

    private Short stimulate;

    private Short concealment;
}