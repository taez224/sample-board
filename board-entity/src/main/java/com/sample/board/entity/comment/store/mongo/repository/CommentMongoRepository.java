package com.sample.board.entity.comment.store.mongo.repository;

import com.sample.board.entity.comment.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentMongoRepository extends MongoRepository<Comment, String> {
    //
    List<Comment> findByPostId(String postId);
}
