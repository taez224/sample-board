package com.sample.board.core.post.store;


import com.sample.board.domain.post.entity.Post;

import java.util.List;

public interface PostStore {

    void create(Post post);
    Post retrieve(String id);
    List<Post> retrieveAll();
    void update(Post post);
    void delete(Post post);
    void delete(String id);

}
