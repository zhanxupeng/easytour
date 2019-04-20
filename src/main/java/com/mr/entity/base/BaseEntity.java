package com.mr.entity.base;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author zhanxp
 * @version 1.0  2019/2/7
 * @Description todo
 */
@Getter
@Setter
public class BaseEntity {
    private final static String ADMIN = "1";
    private String id;

    private String creator;

    private Date createDate;

    private String updator;

    private Date updateDate;

    private Long version;

    private String remark;

    public void init() {
        this.id = IdUtil.simpleUUID();
        this.creator = ADMIN;
        this.createDate = new Date();
        this.updator = ADMIN;
        this.updateDate = new Date();
        this.version = 1L;
    }

    public void edit() {
        this.updator = ADMIN;
        this.updateDate = new Date();
        if (ObjectUtil.isNull(version)) {
            throw new RuntimeException("修改数据时，版本号不能为空");
        }
        this.version = this.version + 1;
    }
}
