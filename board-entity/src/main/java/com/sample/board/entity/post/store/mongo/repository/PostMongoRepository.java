package com.sample.board.entity.post.store.mongo.repository;


import com.sample.board.entity.post.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostMongoRepository extends MongoRepository<Post, String> {


}
