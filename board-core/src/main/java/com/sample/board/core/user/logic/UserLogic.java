package com.sample.board.core.user.logic;

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

    public String registerUser(User user) {
        //
        Assert.isTrue(!userStore.exists(user.getLoginId()), "User already exists with id: " + user.getLoginId());
        userStore.create(user);
        return user.getLoginId();
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
