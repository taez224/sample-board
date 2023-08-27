package com.sample.board.api.comment.rest;

import com.sample.board.api.comment.CommentApi;
import com.sample.board.api.comment.command.RegisterCommentCommand;
import com.sample.board.api.common.BaseResponse;
import com.sample.board.core.comment.logic.CommentLogic;
import com.sample.board.core.comment.model.CommentCdo;
import com.sample.board.core.comment.model.CommentDetail;
import com.sample.board.core.comment.model.CommentList;
import com.sample.board.core.comment.model.CommentUpdate;
import com.sample.board.core.post.logic.PostLogic;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/posts/{postId}/comments")
@RequiredArgsConstructor
public class CommentController implements CommentApi {

    private final CommentLogic commentLogic;
    private final PostLogic postLogic;

    @Override
    @PostMapping("")
    public BaseResponse<String> registerComment(@PathVariable String postId, @RequestBody RegisterCommentCommand command) {
        //
        validatePostId(postId);
        CommentCdo cdo = command.getCommentCdo();
        commentLogic.registerComment(postId, cdo);
        return BaseResponse.created(cdo.getWriter());
    }

    @Override
    @GetMapping("")
    public BaseResponse<CommentList> findCommentsByPostId(@PathVariable String postId) {
        //
        return BaseResponse.of(commentLogic.findCommentsByPostId(postId));
    }

    @Override
    @GetMapping("/{commentId}")
    public BaseResponse<CommentDetail> findCommentByCommentId(@PathVariable String commentId) {
        //
        return BaseResponse.of(commentLogic.findCommentById(commentId));
    }

    @Override
    @PutMapping("/{commentId}")
    public BaseResponse<String> modifyComment(@PathVariable String commentId, @RequestBody CommentUpdate commentUpdate) {
        //
        commentLogic.modifyComment(commentId, commentUpdate);
        return BaseResponse.of(commentId);
    }

    @Override
    @DeleteMapping("/{commentId}")
    public BaseResponse<String> deleteComment(@PathVariable String commentId) {
        //
        commentLogic.deleteComment(commentId);
        return BaseResponse.of(commentId);
    }

    private void validatePostId(String postId) {
        //
        if (!postLogic.existByPostId(postId)) {
         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found!");
        }
    }
}
