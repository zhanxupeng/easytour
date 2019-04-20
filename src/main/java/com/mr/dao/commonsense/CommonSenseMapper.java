package com.mr.dao.commonsense;

import com.mr.dao.base.BaseMapper;
import com.mr.entity.commonsense.CommonSense;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommonSenseMapper extends BaseMapper<CommonSense> {
    List<CommonSense> query();
}