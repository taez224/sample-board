package com.sample.board.core.user.store.mongo;

import com.sample.board.domain.user.entity.User;
import com.sample.board.core.user.store.UserStore;
import com.sample.board.core.user.store.mongo.repository.UserMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserMongoStore implements UserStore {

    private final UserMongoRepository userMongoRepository;

    @Override
    public void create(User user) {
        userMongoRepository.save(user);
    }

    @Override
    public void createAll(List<User> users) {
        userMongoRepository.saveAll(users);
    }

    @Override
    public User retrieve(String id) {
        Optional<User> user = userMongoRepository.findByLoginId(id);
        return user.orElse(null);
    }

    @Override
    public void update(User user) {
        userMongoRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userMongoRepository.deleteById(user.getLoginId());
    }

    @Override
    public void delete(String id) {
        userMongoRepository.deleteById(id);
    }

    @Override
    public boolean exists(String id) {
        return userMongoRepository.existsByLoginId(id);
    }

}
