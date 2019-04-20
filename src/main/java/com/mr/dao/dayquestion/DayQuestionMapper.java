package com.mr.dao.dayquestion;

import com.mr.dao.base.BaseMapper;
import com.mr.entity.dayquestion.DayQuestion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DayQuestionMapper extends BaseMapper<DayQuestion> {
    int countAll();

    List<DayQuestion> query();
}