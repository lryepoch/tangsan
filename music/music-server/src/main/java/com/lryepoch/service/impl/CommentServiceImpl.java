package com.lryepoch.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lryepoch.entity.Comment;
import com.lryepoch.dao.CommentMapper;
import com.lryepoch.service.CommentService;
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
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> allComment() {
        return list();
    }

    @Override
    public List<Comment> commentOfSongId(int songId) {
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("song_id", songId);
        return commentMapper.selectList(queryWrapper);
    }

    @Override
    public List<Comment> commentOfSongListId(int songListId) {
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("song_list_id", songListId);
        return commentMapper.selectList(queryWrapper);
    }

    @Override
    public boolean addComment(Comment comment) {
        return save(comment);
    }

    @Override
    public boolean updateCommentMsg(Comment comment) {
        return updateById(comment);
    }

    @Override
    public boolean deleteComment(int id) {
        return commentMapper.deleteById(id) > 0 ? true : false;
    }
}
