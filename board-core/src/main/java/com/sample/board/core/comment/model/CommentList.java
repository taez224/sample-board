package com.sample.board.core.comment.model;

import com.sample.board.core.common.domain.DataTransferObject;
import com.sample.board.entity.comment.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentList extends DataTransferObject {

    private List<CommentListItem> comments;

    public static CommentList fromEntities(List<Comment> comments) {
        List<CommentListItem> listItemDtos = comments.stream().map(CommentListItem::fromEntity).collect(Collectors.toList());
        return new CommentList(listItemDtos);
    }

}
