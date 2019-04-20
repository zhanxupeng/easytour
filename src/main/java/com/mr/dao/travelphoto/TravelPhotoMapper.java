package com.mr.dao.travelphoto;

import com.mr.dao.base.BaseMapper;
import com.mr.dto.TravelListDTO;
import com.mr.entity.travelphoto.TravelPhoto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TravelPhotoMapper extends BaseMapper<TravelPhoto> {
    List<TravelListDTO> selectByCategory(@Param("category") String category);
}