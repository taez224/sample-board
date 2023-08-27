package com.sample.board.core.comment.model;

import com.sample.board.core.common.domain.BaseDomain;
import com.sample.board.entity.comment.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDetail extends BaseDomain {

    private String writer;
    private String postId;
    private String content;

    public static CommentDetail fromEntity(Comment comment) {
        CommentDetail dto = new CommentDetail();
        BeanUtils.copyProperties(comment, dto);
        return dto;
    }

    public static CommentDetail sample(String id) {
        CommentDetail sample =  new CommentDetail(
                "sample-writer",
                UUID.randomUUID().toString(),
                "sample-content"
        );
        sample.setId(id);
        return sample;
    }

}
