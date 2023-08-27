package com.sample.board.core.post.model;


import com.sample.board.entity.post.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostCdo {
    private String writer;
    private String password;
    private String title;
    private String content;

    public Post toEntity() {
        return new Post(
                writer,
                password,
                title,
                content
        );
    }

}
