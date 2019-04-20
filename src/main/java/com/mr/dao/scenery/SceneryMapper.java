package com.mr.dao.scenery;

import com.mr.dao.base.BaseMapper;
import com.mr.dto.RecommendDetailDTO;
import com.mr.dto.SceneryDTO;
import com.mr.dto.SceneryQueryDTO;
import com.mr.dto.SceneryRouteDTO;
import com.mr.entity.scenery.Scenery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SceneryMapper extends BaseMapper<Scenery> {
    List<SceneryDTO> suit(SceneryQueryDTO sceneryQueryDTO);

    List<SceneryRouteDTO> routeSuit(SceneryQueryDTO sceneryQueryDTO);

    SceneryDTO detail(RecommendDetailDTO recommendDetailDTO);
}