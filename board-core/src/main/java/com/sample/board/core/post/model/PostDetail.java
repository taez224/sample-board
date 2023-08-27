package com.sample.board.core.post.model;

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
public class PostDetail extends BaseDomain {

    private String writer;
    private String title;
    private String content;

    public static PostDetail fromEntity(Post post) {
        PostDetail dto = new PostDetail();
        BeanUtils.copyProperties(post, dto);
        return dto;
    }

    public static PostDetail sample(String id) {
        PostDetail sample =  new PostDetail(
                "sample-writer",
                "sample-title",
                "sample-content"
        );
        sample.setId(id);
        return sample;
    }

}
