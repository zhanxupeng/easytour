package com.mr.dao.base;

import org.apache.ibatis.annotations.Param;

/**
 * @author zhanxp
 * @version 1.0  2019/2/7
 * @Description todo
 */
public interface BaseMapper<T> {
    int delete(@Param("id") String id);

    int insert(T record);

    T getById(@Param("id") String id);

    int update(T record);
}
