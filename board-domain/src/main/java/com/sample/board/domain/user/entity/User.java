package com.sample.board.domain.user.entity;

import com.sample.board.domain.common.entity.BaseEntity;
import com.sample.board.domain.user.entity.model.UserCdo;
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

    public static User fromCdo(UserCdo userCdo) {
        return new User(
                userCdo.getLoginId(),
                userCdo.getPassword(),
                userCdo.getNickname()
        );
    }
}
