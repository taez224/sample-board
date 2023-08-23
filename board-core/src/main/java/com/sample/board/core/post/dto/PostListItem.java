package com.sample.board.core.post.dto;

import com.sample.board.core.common.domain.BaseDomain;
import com.sample.board.entity.post.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostListItem extends BaseDomain {

    private String writer;
    private String title;

    public static PostListItem fromEntity(Post post) {
        PostListItem dto = new PostListItem();
        BeanUtils.copyProperties(post, dto);
        return dto;
    }
}
