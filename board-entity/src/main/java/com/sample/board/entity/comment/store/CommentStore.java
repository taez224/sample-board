package com.sample.board.entity.comment.store;

import com.sample.board.entity.comment.Comment;

import java.util.List;

public interface CommentStore {
    void create(Comment comment);
    Comment retrieve(String id);
    List<Comment> retrieveAll();
    void update(Comment comment);
    void delete(Comment comment);
    void delete(String id);

    List<Comment> retrieveByPostId(String postId);
}
