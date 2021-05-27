package com.lryepoch.service;

import com.lryepoch.entity.Collect;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lryepoch
 * @since 2021-05-24
 */
public interface CollectService extends IService<Collect> {

    List<Collect> allCollect();

    List<Collect> collectionOfUser(int parseInt);

    boolean existSongId(int parseInt, int parseInt1);

    boolean addCollection(Collect collect);

    boolean updateCollectMsg(Collect collect);

    boolean deleteCollect(int parseInt, int parseInt1);
}
