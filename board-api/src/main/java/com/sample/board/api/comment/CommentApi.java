package com.sample.board.api.comment;

import com.sample.board.api.comment.command.RegisterCommentCommand;
import com.sample.board.api.common.BaseResponse;
import com.sample.board.core.comment.model.CommentDetail;
import com.sample.board.core.comment.model.CommentList;
import com.sample.board.core.comment.model.CommentUpdate;

public interface CommentApi {

    BaseResponse<String> registerComment(String postId, RegisterCommentCommand command);

    BaseResponse<CommentList> findCommentsByPostId(String postId);

    BaseResponse<CommentDetail> findCommentByCommentId(String commentId);

    BaseResponse<String> modifyComment(String commentId, CommentUpdate commentUpdate);

    BaseResponse<String> deleteComment(String commentId);
}
