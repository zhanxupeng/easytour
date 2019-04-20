package com.mr.controller.travelphoto.view;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author zhanxp
 * @version 1.0  2019/2/8
 * @Description todo
 */
@Getter
@Setter
@ToString
public class TravelListVM implements Serializable {
    private String id;
    private String image;
    private String brief;
    private String headPicture;
    private String nickName;
}
