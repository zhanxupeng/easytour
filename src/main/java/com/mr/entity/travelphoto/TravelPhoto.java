package com.mr.entity.travelphoto;

import com.mr.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TravelPhoto extends BaseEntity {

    private String customerId;

    private String category;

    private String pictures;

    private String city;

    private String sceneryName;

    private String title;

    private String brief;

    private String content;
}