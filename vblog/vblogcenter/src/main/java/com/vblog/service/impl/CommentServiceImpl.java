package com.vblog.service.impl;

import com.vblog.entity.Comment;
import com.vblog.dao.CommentMapper;
import com.vblog.service.CommentService;
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
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
