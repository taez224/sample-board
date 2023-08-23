package com.sample.board.api.post;

import com.sample.board.api.post.command.RegisterPostCommand;
import com.sample.board.core.post.dto.PostDetail;
import com.sample.board.core.post.dto.PostList;
import com.sample.board.core.post.dto.PostUpdate;

public interface PostApi {

    PostList findAllPosts();

    void registerPost(RegisterPostCommand cdo);

    PostDetail findPostById(String postId);

    void modifyPost(String postId, PostUpdate postUpdate);

    void deletePost(String postId);
}
