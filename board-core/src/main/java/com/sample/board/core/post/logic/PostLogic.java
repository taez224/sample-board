package com.sample.board.core.post.logic;

import com.sample.board.domain.post.entity.Post;
import com.sample.board.core.post.store.PostStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostLogic {

    private final PostStore postStore;

    public void registerPost(Post post) {
        //
        postStore.create(post);
    }

    public List<Post> findAllPosts() {
        //
        return postStore.retrieveAll();
    }

    public Post findPostById(String id) {
        //
        return postStore.retrieve(id);
    }

    public Post modifyPost(Post post) {
        //
        postStore.update(post);
        return post;
    }

    public void deletePost(String id) {
        //
        postStore.delete(id);
    }
}
