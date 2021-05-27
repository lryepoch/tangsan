package com.lryepoch.service;

import com.lryepoch.entity.Rank;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lryepoch
 * @since 2021-05-24
 */
public interface RankService extends IService<Rank> {

    int rankOfSongListId(long parseLong);

    boolean addRank(Rank rank);
}
