package com.sample.board.core.user.store;


import com.sample.board.domain.user.entity.User;

import java.util.List;

public interface UserStore {

    void create(User user);
    void createAll(List<User> users);
    User retrieve(String id);
    void update(User user);
    void delete(User user);
    void delete(String id);
    boolean exists(String id);

}
