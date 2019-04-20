package com.mr.controller.travelphoto.view;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhanxp
 * @version 1.0  2019/2/15
 * @Description todo
 */
@Setter
@Getter
@ToString
public class TravelDetailVM implements Serializable {
    private List<String> pictureList;

    private String city;

    private String sceneryName;

    private String title;

    private String content;
}
