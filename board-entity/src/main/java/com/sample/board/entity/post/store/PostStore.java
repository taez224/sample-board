package com.sample.board.entity.post.store;


import com.sample.board.entity.post.Post;

import java.util.List;

public interface PostStore {

    void create(Post post);
    Post retrieve(String id);
    List<Post> retrieveAll();
    void update(Post post);
    void delete(Post post);
    void delete(String id);
    boolean exist(String id);
}
