package com.lryepoch.service;

import com.lryepoch.entity.Song;
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
public interface SongService extends IService<Song> {

    List<Song> allSong();

    List<Song> songOfId(int parseInt);

    List<Song> songOfSingerId(int parseInt);

    List<Song> songOfSingerName(String s);

    List<Song> songOfName(String name);

    boolean addSong(Song song);

    boolean updateSongMsg(Song song);

    boolean updateSongPic(Song song);

    boolean updateSongUrl(Song song);
}
