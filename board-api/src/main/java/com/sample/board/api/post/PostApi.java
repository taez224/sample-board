package com.sample.board.api.post;

import com.sample.board.api.common.BaseResponse;
import com.sample.board.api.post.command.RegisterPostCommand;
import com.sample.board.core.post.model.PostDetail;
import com.sample.board.core.post.model.PostList;
import com.sample.board.core.post.model.PostUpdate;

public interface PostApi {

    BaseResponse<PostList> findAllPosts();

    BaseResponse<String> registerPost(RegisterPostCommand command);

    BaseResponse<PostDetail> findPostById(String postId);

    BaseResponse<String> modifyPost(String postId, PostUpdate postUpdate);

    BaseResponse<String> deletePost(String postId);
}
