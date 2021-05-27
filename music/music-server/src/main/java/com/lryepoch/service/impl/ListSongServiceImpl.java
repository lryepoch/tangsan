package com.lryepoch.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lryepoch.entity.ListSong;
import com.lryepoch.dao.ListSongMapper;
import com.lryepoch.service.ListSongService;
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
public class ListSongServiceImpl extends ServiceImpl<ListSongMapper, ListSong> implements ListSongService {

    @Autowired
    private ListSongMapper listSongMapper;

    @Override
    public List<ListSong> allListSong() {
        return list();
    }

    @Override
    public List<ListSong> listSongOfSongId(int parseInt) {
        QueryWrapper<ListSong> queryWrapper = new QueryWrapper<>();
        queryWrapper.or().eq("song_list_id", parseInt);
        return list(queryWrapper);
    }

    @Override
    public boolean addListSong(ListSong listsong) {
        return save(listsong);
    }

    @Override
    public boolean deleteListSong(int parseInt) {
        QueryWrapper<ListSong> queryWrapper = new QueryWrapper<>();
        queryWrapper.or().eq("song_id", parseInt);
        return listSongMapper.delete(queryWrapper) > 0 ? true : false;
    }

    @Override
    public boolean updateListSongMsg(ListSong listsong) {
        return updateById(listsong);
    }
}
