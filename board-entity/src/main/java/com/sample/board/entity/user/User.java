package com.sample.board.entity.user;

import com.sample.board.entity.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "USER")
public class User extends BaseEntity {

    private String loginId;
    private String password;
    private String nickname;

}
