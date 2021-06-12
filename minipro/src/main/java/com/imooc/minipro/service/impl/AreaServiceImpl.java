package com.imooc.minipro.service.impl;

import com.imooc.minipro.dao.AreaMapper;
import com.imooc.minipro.entity.Area;
import com.imooc.minipro.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaMapper areaMapper;

    @Override
    public List<Area> queryArea() {
        return areaMapper.queryArea();
    }

    @Override
    public Area queryAreaById(int areaId) {
        return areaMapper.queryAreaById(areaId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertArea(Area area) {
        if (area.getAreaName() != null && !"".equals(area.getAreaName().trim())) {
            //如果名字合法
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());

            int enabled = areaMapper.insertArea(area);
            if (enabled == 1) {
                return true;
            } else {
                throw new RuntimeException("插入区域信息错误");
            }
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateArea(Area area) {
        if (area.getAreaId() != null && area.getAreaId() > 0) {
            int enabled = areaMapper.updateArea(area);
            if (enabled == 1) {
                return true;
            } else {
                throw new RuntimeException("插入区域信息错误");
            }
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteArea(int areaId) {
        if (areaId > 0) {
            int enabled = areaMapper.deleteArea(areaId);
            if (enabled < 1) {
                return false;
            }
        }
        return true;
    }
}
