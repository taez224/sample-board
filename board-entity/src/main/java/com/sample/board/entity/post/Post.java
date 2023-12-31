package com.sample.board.entity.post;

import com.sample.board.entity.common.BaseEntity;
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

    public static Post sample() {
        return new Post(
                "sample-writer",
                "sample-pwd",
                "sample-title",
                "sample-content"
        );
    }
}
