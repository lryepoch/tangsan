package com.lryepoch.service.impl;

import com.lryepoch.entity.Song;
import com.lryepoch.dao.SongMapper;
import com.lryepoch.service.SongService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lryepoch
 * @since 2021-05-24
 */
@Service
public class SongServiceImpl extends ServiceImpl<SongMapper, Song> implements SongService {

}
