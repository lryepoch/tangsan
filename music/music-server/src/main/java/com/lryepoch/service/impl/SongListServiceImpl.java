package com.lryepoch.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lryepoch.entity.SongList;
import com.lryepoch.dao.SongListMapper;
import com.lryepoch.service.SongListService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class SongListServiceImpl extends ServiceImpl<SongListMapper, SongList> implements SongListService {


    @Override
    public List<SongList> allSongList() {
        return list();
    }

    @Override
    public List<SongList> songListOfTitle(String title) {
        QueryWrapper<SongList> queryWrapper = new QueryWrapper<>();
        queryWrapper.or().eq("title", title);
        return list(queryWrapper);
    }

    @Override
    public List<SongList> likeTitle(String title) {
        QueryWrapper<SongList> queryWrapper = new QueryWrapper<>();
        queryWrapper.or().like("title", title);
        return list(queryWrapper);
    }

    @Override
    public List<SongList> likeStyle(String style) {
        QueryWrapper<SongList> queryWrapper = new QueryWrapper<>();
        queryWrapper.or().like("style", style);
        return list(queryWrapper);
    }

    @Override
    public boolean addSongList(SongList songList) {
        return save(songList);
    }

    @Override
    public boolean updateSongListMsg(SongList songList) {
        return updateById(songList);
    }

    @Override
    public boolean updateSongListImg(SongList songList) {
        return updateById(songList);
    }

    @Override
    public boolean deleteSongList(int id) {
        return removeById(id);
    }
}
