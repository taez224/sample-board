package com.sample.board.entity.post.store.mongo;

import com.sample.board.entity.post.Post;
import com.sample.board.entity.post.store.PostStore;
import com.sample.board.entity.post.store.mongo.repository.PostMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostMongoStore implements PostStore {

    private final PostMongoRepository postMongoRepository;

    @Override
    public void create(Post user) {
        postMongoRepository.save(user);
    }

    @Override
    public Post retrieve(String id) {
        return  postMongoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Post> retrieveAll() {
        return postMongoRepository.findAll();
    }

    @Override
    public void update(Post post) {
        postMongoRepository.save(post);
    }

    @Override
    public void delete(Post post) {
        postMongoRepository.delete(post);
    }

    @Override
    public void delete(String id) {
        postMongoRepository.deleteById(id);
    }

    @Override
    public boolean exist(String id) { return postMongoRepository.existsById(id); }

}
