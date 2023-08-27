package com.sample.board.core.user.logic;

import com.sample.board.core.user.model.UserCdo;
import com.sample.board.entity.user.store.UserStore;
import com.sample.board.entity.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@Transactional
@RequiredArgsConstructor
public class UserLogic {

    private final UserStore userStore;

    public String registerUser(UserCdo cdo) {
        //
        Assert.isTrue(!userStore.exists(cdo.getLoginId()), "User already exists with id: " + cdo.getLoginId());
        userStore.create(cdo.toEntity());
        return cdo.getLoginId();
    }

    public User findUserById(String userId) {
        //
        return userStore.retrieve(userId);
    }

    public User modifyUser(User user) {
        //
        userStore.update(user);
        return user;
    }
}
