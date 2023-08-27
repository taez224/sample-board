package com.sample.board.core.comment.logic;

import com.sample.board.core.comment.model.CommentCdo;
import com.sample.board.core.comment.model.CommentDetail;
import com.sample.board.core.comment.model.CommentList;
import com.sample.board.core.comment.model.CommentUpdate;
import com.sample.board.entity.comment.Comment;
import com.sample.board.entity.comment.store.CommentStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentLogic {

    private final CommentStore commentStore;

    public void registerComment(String postId, CommentCdo cdo) {
        //
        commentStore.create(cdo.toEntity(postId));
    }

    public CommentList findCommentsByPostId(String postId) {
        //
        return CommentList.fromEntities(commentStore.retrieveByPostId(postId));
    }

    public CommentDetail findCommentById(String commentId) {
        //
        return CommentDetail.fromEntity(findCommentByIdWithException(commentId));
    }

    public void modifyComment(String commentId, CommentUpdate commentUpdate) {
        //
        Comment targetComment = findCommentByIdWithException(commentId);
        commentStore.update(commentUpdate.updateComment(targetComment));
    }

    public void deleteComment(String commentId) {
        //
        Comment targetComment = findCommentByIdWithException(commentId);
        commentStore.delete(targetComment);
    }

    private Comment findCommentByIdWithException(String commentId) {
        Comment targetComment = commentStore.retrieve(commentId);
        Assert.notNull(targetComment, "targetComment is null!");
        return targetComment;
    }
}
