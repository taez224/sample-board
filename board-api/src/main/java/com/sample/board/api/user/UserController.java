package com.sample.board.api.user;

import com.sample.board.api.common.BaseResponse;
import com.sample.board.api.user.command.RegisterUserCommand;
import com.sample.board.core.user.logic.UserLogic;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserLogic userLogic;

    @PostMapping("/sign-up")
    public BaseResponse<String> signUp(@RequestBody RegisterUserCommand command) {
        Assert.notNull(command.getUserCdo(), "userCdo should not be null!");

        String loginId = userLogic.registerUser(command.getUserCdo());

        return BaseResponse.of(loginId);
    }
}
