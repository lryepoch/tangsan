package com.lryepoch.service;

import com.lryepoch.entity.SongList;
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
public interface SongListService extends IService<SongList> {

    List<SongList> allSongList();

    List<SongList> songListOfTitle(String title);

    List<SongList> likeTitle(String s);

    List<SongList> likeStyle(String s);

    boolean addSongList(SongList songList);

    boolean updateSongListMsg(SongList songList);

    boolean updateSongListImg(SongList songList);

    boolean deleteSongList(int parseInt);
}
