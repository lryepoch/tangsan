package com.lryepoch.service;

import com.lryepoch.entity.ListSong;
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
public interface ListSongService extends IService<ListSong> {

    List<ListSong> allListSong();

    List<ListSong> listSongOfSongId(int parseInt);

    boolean addListSong(ListSong listsong);

    boolean deleteListSong(int parseInt);

    boolean updateListSongMsg(ListSong listsong);
}
