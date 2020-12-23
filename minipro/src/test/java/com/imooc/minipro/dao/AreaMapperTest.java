package com.imooc.minipro.dao;

import com.imooc.minipro.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest
@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class AreaMapperTest {

    @Autowired
    AreaMapper areaMapper;

    @Test
    public void queryArea() {
        List<Area> areaList = areaMapper.queryArea();
        System.out.println(areaList);
    }

    @Test
    public void queryAreaById() {
        Area area = areaMapper.queryAreaById(1);
        System.out.println("名称:" + area.getAreaName() + ",ID:" + area.getPriority());
    }

    @Test
    public void insertArea() {
        Area area = new Area();
        area.setAreaName("1南苑");
        area.setPriority(3);
        int enabled = areaMapper.insertArea(area);
        System.out.println(enabled == 1 ? 666 : 777);
    }

    @Test
    public void updateArea() {
        Area area = new Area();
        area.setAreaName("r苑");
        area.setPriority(8);
        area.setAreaId(4);
        int enabled = areaMapper.updateArea(area);
        System.out.println(enabled);
    }

//    @Test
//    public void updateArea(){
//        Area area = new Area();
//        area.setAreaName("wudi");
//        area.setAreaId(4);
//        area.setPriority(2);
//        System.out.println(areaMapper.updateArea(area));
//    }

    @Test
    public void deleteArea() {
        int enabled = areaMapper.deleteArea(3);
        System.out.println(enabled);
    }
}