package com.mr.entity.dictionary;

import com.mr.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Dictionary extends BaseEntity {

    private String type;

    private String key;

    private String label;
}