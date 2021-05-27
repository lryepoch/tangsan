package com.lryepoch.dao;

import com.lryepoch.entity.Rank;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lryepoch
 * @since 2021-05-24
 */
public interface RankMapper extends BaseMapper<Rank> {

    /**
    * 同一歌单总评分
    */
    int selectScoreSum(long songListId);

    /**
    * 同一歌单总评分人数
    */
    int selectRankNum(long songListId);

}
