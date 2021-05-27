package com.lryepoch.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lryepoch.entity.Comment;
import com.lryepoch.entity.Song;
import com.lryepoch.dao.SongMapper;
import com.lryepoch.service.SongService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class SongServiceImpl extends ServiceImpl<SongMapper, Song> implements SongService {

    @Autowired
    private SongMapper songMapper;

    @Override
    public List<Song> allSong() {
        return list();
    }

    @Override
    public List<Song> songOfId(int songId) {
        QueryWrapper<Song> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", songId);
        return songMapper.selectList(queryWrapper);
    }

    @Override
    public List<Song> songOfSingerId(int singerId) {
        QueryWrapper<Song> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("singer_id", singerId);
        return songMapper.selectList(queryWrapper);
    }

    @Override
    public List<Song> songOfSingerName(String singerName) {
        QueryWrapper<Song> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", singerName);
        return songMapper.selectList(queryWrapper);
    }

    @Override
    public List<Song> songOfName(String songName) {
        QueryWrapper<Song> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", songName);
        return songMapper.selectList(queryWrapper);
    }

    @Override
    public boolean addSong(Song song) {
        return save(song);
    }

    @Override
    public boolean updateSongMsg(Song song) {
        return updateById(song);
    }

    @Override
    public boolean updateSongPic(Song song) {
        return updateById(song);
    }

    @Override
    public boolean updateSongUrl(Song song) {
        return updateById(song);
    }
}
