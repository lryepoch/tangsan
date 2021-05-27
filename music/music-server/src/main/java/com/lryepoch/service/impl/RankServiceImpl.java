package com.lryepoch.service.impl;

import com.lryepoch.entity.Rank;
import com.lryepoch.dao.RankMapper;
import com.lryepoch.service.RankService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lryepoch
 * @since 2021-05-24
 */
@Service
public class RankServiceImpl extends ServiceImpl<RankMapper, Rank> implements RankService {

    @Autowired
    private RankMapper rankMapper;

    @Override
    public int rankOfSongListId(long songListId) {
        return rankMapper.selectScoreSum(songListId) / rankMapper.selectRankNum(songListId);
    }

    @Override
    public boolean addRank(Rank rank) {
        return rankMapper.insert(rank) > 0 ? true : false;
    }
}
