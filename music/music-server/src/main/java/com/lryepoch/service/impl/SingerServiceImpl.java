package com.lryepoch.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lryepoch.entity.Singer;
import com.lryepoch.dao.SingerMapper;
import com.lryepoch.service.SingerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lryepoch
 * @since 2021-05-24
 */
@Service
public class SingerServiceImpl extends ServiceImpl<SingerMapper, Singer> implements SingerService {

    @Autowired
    private SingerMapper singerMapper;

    @Override
    public List<Singer> allSinger() {
        return list();
    }

    @Override
    public List<Singer> singerOfName(String name) {
        QueryWrapper<Singer> queryWrapper = new QueryWrapper<>();
        queryWrapper.or().like("name", name);
        return list(queryWrapper);
    }

    @Override
    public List<Singer> singerOfSex(int sex) {
        QueryWrapper<Singer> queryWrapper = new QueryWrapper<>();
        queryWrapper.or().eq("sex", sex);
        return list(queryWrapper);
    }

    @Override
    public boolean addSinger(Singer singer) {
        return save(singer);
    }

    @Override
    public boolean updateSingerMsg(Singer singer) {
        return updateById(singer);
    }

    @Override
    public boolean updateSingerPic(Singer singer) {
        return updateById(singer);
    }

    @Override
    public boolean deleteSinger(int id) {
        return removeById(id);
    }


}
