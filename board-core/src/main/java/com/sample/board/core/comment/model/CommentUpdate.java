package com.sample.board.core.comment.model;

import com.sample.board.core.common.domain.DataTransferObject;
import com.sample.board.entity.comment.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentUpdate extends DataTransferObject {

    private String content;

    public Comment updateComment(Comment comment) {
        comment.setContent(content);
        return comment;
    }
}
