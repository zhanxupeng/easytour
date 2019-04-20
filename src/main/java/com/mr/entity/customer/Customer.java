package com.mr.entity.customer;

import com.mr.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Customer extends BaseEntity {
    private String userName;

    private String password;

    private String nickName;

    private String sex;

    private String headPicture;

    private Integer goldCoin;
}