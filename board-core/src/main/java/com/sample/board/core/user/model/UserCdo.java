package com.sample.board.core.user.model;


import com.sample.board.entity.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCdo {
    private String loginId;
    private String password;
    private String nickname;

    public User toEntity() {
        return new User(
               loginId, password, nickname
        );
    }
}
