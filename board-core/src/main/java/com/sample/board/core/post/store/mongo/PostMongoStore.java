package com.sample.board.core.post.store.mongo;

import com.sample.board.core.post.store.mongo.repository.PostMongoRepository;
import com.sample.board.domain.post.entity.Post;
import com.sample.board.core.post.store.PostStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
        Optional<Post> post = postMongoRepository.findById(id);
        return post.orElse(null);
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
        postMongoRepository.deleteById(post.getId());
    }

    @Override
    public void delete(String id) {
        postMongoRepository.deleteById(id);
    }



}
