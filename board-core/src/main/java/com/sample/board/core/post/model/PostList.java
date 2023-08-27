package com.sample.board.core.post.model;

import com.sample.board.core.common.domain.DataTransferObject;
import com.sample.board.entity.post.Post;
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
public class PostList extends DataTransferObject {

    private List<PostListItem> posts;

    public static PostList fromEntities(List<Post> posts) {
        List<PostListItem> listItemDtos = posts.stream().map(PostListItem::fromEntity).collect(Collectors.toList());
        return new PostList(listItemDtos);
    }

}
