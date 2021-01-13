package com.vblog.service.impl;

import com.vblog.entity.Tag;
import com.vblog.dao.TagMapper;
import com.vblog.service.TagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lryepoch
 * @since 2021-01-13
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

}
