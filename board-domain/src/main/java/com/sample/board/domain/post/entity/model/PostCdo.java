package com.sample.board.domain.post.entity.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostCdo {
    private String writer;
    private String password;
    private String title;
    private String content;
}
