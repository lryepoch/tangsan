package com.lryepoch.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lryepoch.entity.Collect;
import com.lryepoch.dao.CollectMapper;
import com.lryepoch.service.CollectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lryepoch
 * @since 2021-05-24
 */
@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements CollectService {
    @Autowired
    private CollectMapper collectMapper;

    /**
     * 返回所有用户收藏列表
     */
    @Override
    public List<Collect> allCollect() {
        return list();
    }

    @Override
    public List<Collect> collectionOfUser(int userId) {
        QueryWrapper<Collect> queryWrapper = new QueryWrapper<>();
        queryWrapper.or().eq("user_id", userId);
        return list(queryWrapper);
    }

    @Override
    public boolean existSongId(int userId, int songId) {
        return collectMapper.existSongId(userId, songId) > 0 ? true : false;
    }

    @Override
    public boolean addCollection(Collect collect) {
        return save(collect);
    }

    @Override
    public boolean updateCollectMsg(Collect collect) {
        return updateById(collect);
    }

    @Override
    public boolean deleteCollect(int user_id, int song_id) {
        return collectMapper.deleteCollect(user_id, song_id) > 0 ? true : false;
    }
}
