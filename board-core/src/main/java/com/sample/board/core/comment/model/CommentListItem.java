package com.sample.board.core.comment.model;

import com.sample.board.core.common.domain.BaseDomain;
import com.sample.board.entity.comment.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentListItem extends BaseDomain {

    private String writer;
    private String content;

    public static CommentListItem fromEntity(Comment comment) {
        CommentListItem dto = new CommentListItem();
        BeanUtils.copyProperties(comment, dto);
        return dto;
    }
}
