package com.sample.board.entity.comment;

import com.sample.board.entity.common.BaseEntity;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "COMMENT")
public class Comment extends BaseEntity {

    private String writer;
    private String password;
    private String postId;
    private String content;

    public static Comment sample() {
        return new Comment(
                "sample-writer",
                "sample-pwd",
                UUID.randomUUID().toString(),
                "sample-content"
        );
    }
}
