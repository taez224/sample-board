package com.sample.board.api.user.command;

import com.sample.board.api.common.BaseRequest;
import com.sample.board.core.user.model.UserCdo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserCommand extends BaseRequest {
    //
    private UserCdo userCdo;

}
