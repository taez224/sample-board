package com.sample.board.entity.comment.store.mongo;

import com.sample.board.entity.comment.Comment;
import com.sample.board.entity.comment.store.CommentStore;
import com.sample.board.entity.comment.store.mongo.repository.CommentMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentMongoStore implements CommentStore {

    private final CommentMongoRepository commentMongoRepository;

    @Override
    public void create(Comment comment) {
        commentMongoRepository.save(comment);
    }

    @Override
    public Comment retrieve(String id) {
        return commentMongoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Comment> retrieveAll() {
        return commentMongoRepository.findAll();
    }

    @Override
    public void update(Comment comment) {
        commentMongoRepository.save(comment);
    }

    @Override
    public void delete(Comment comment) {
        commentMongoRepository.delete(comment);
    }

    @Override
    public void delete(String id) {
        commentMongoRepository.deleteById(id);
    }

    @Override
    public List<Comment> retrieveByPostId(String postId) {
        return commentMongoRepository.findByPostId(postId);
    }
}
