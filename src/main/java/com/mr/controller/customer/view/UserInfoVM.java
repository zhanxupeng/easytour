package com.mr.controller.customer.view;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zhanxp
 * @version 1.0  2019/2/8
 * @Description todo
 */
@Getter
@Setter
@ToString
public class UserInfoVM {
    private String userName;
    private String headPicture;
    private String nickName;
    private String sex;
    private Integer goldCoin;
}
