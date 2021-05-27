package com.lryepoch.service;

import com.lryepoch.entity.Comment;
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
public interface CommentService extends IService<Comment> {

    List<Comment> allComment();

    List<Comment> commentOfSongId(int parseInt);

    List<Comment> commentOfSongListId(int parseInt);

    boolean addComment(Comment comment);

    boolean updateCommentMsg(Comment comment);

    boolean deleteComment(int parseInt);
}
