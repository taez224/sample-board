package com.sample.board.core.comment.model;


import com.sample.board.entity.comment.Comment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentCdo {
    private String writer;
    private String password;
    private String content;

    public Comment toEntity(String postId) {
        return new Comment(
                writer,
                password,
                postId,
                content
        );
    }

}
