package com.sample.board.core.post.dto;

import com.sample.board.core.common.domain.DataTransferObject;
import com.sample.board.entity.post.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostUpdate extends DataTransferObject {

    private String title;
    private String content;

    public Post updatePost(Post post) {
        post.setTitle(title);
        post.setContent(content);
        return post;
    }
}
