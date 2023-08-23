package com.sample.board.entity.user.store.mongo.repository;


import com.sample.board.entity.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserMongoRepository extends MongoRepository<User, String> {

    Optional<User> findByLoginId(String loginId);
    boolean existsByLoginId(String loginId);
}
