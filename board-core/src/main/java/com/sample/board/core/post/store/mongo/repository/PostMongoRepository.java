package com.sample.board.core.post.store.mongo.repository;


import com.sample.board.domain.post.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostMongoRepository extends MongoRepository<Post, String> {


}
