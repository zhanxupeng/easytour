package com.mr.dao.dictionary;

import com.mr.dao.base.BaseMapper;
import com.mr.entity.dictionary.Dictionary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DictionaryMapper extends BaseMapper<Dictionary> {
    Dictionary getByTypeAndLabel(@Param("type") String type,
                                 @Param("label") String label);
}