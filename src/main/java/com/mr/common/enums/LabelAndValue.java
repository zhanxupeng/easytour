package com.mr.common.enums;

import java.io.Serializable;

/**
 * 枚举接口
 *
 * @author chenlw
 * @version 1.0  2018/7/30
 */
public interface LabelAndValue<T> extends Serializable {

    /**
     * 获取枚举的Value
     *
     * @return 枚举Value
     * @author chenlw  v1.0   2018/7/30
     */
    T getValue();

    /**
     * 获取枚举的Label
     *
     * @return 枚举Label
     * @author chenlw  v1.0   2018/7/30
     */
    String getLabel();
}
