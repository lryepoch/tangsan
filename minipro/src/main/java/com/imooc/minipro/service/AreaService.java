package com.imooc.minipro.service;

import com.imooc.minipro.entity.Area;

import java.util.List;

public interface AreaService {
    List<Area> queryArea();
    Area queryAreaById(int areaId);
    boolean insertArea(Area area);
    boolean updateArea(Area area);
    boolean deleteArea(int areaId);
}
