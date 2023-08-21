package com.sample.board.domain.post.entity;

import com.sample.board.domain.common.entity.BaseEntity;
import com.sample.board.domain.post.entity.model.PostCdo;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "POST")
public class Post extends BaseEntity {

    private String writer;
    private String password;
    private String title;
    private String content;

    public static Post fromCdo(PostCdo postCdo) {
        return new Post(
                postCdo.getWriter(),
                postCdo.getPassword(),
                postCdo.getTitle(),
                postCdo.getContent()
        );
    }
}
