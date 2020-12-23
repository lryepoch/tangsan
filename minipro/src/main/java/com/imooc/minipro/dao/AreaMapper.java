package com.imooc.minipro.dao;

import com.imooc.minipro.entity.Area;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface AreaMapper {
    List<Area> queryArea();
    Area queryAreaById(int areaId);
    int insertArea(Area area);
    int updateArea(Area area);
    int deleteArea(int areaId);
}
