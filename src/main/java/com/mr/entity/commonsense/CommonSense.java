package com.mr.entity.commonsense;

import com.mr.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommonSense extends BaseEntity {

    private String title;

    private String picture;
}