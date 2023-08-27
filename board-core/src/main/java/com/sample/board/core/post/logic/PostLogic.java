package com.sample.board.core.post.logic;

import com.sample.board.core.post.model.PostCdo;
import com.sample.board.core.post.model.PostDetail;
import com.sample.board.core.post.model.PostList;
import com.sample.board.core.post.model.PostUpdate;
import com.sample.board.entity.post.Post;
import com.sample.board.entity.post.store.PostStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@Transactional
@RequiredArgsConstructor
public class PostLogic {

    private final PostStore postStore;
    public void registerPost(PostCdo cdo) {
        //
        postStore.create(cdo.toEntity());
    }

    public PostList findAllPosts() {
        //
        return PostList.fromEntities(postStore.retrieveAll());
    }

    public PostDetail findPostById(String id) {
        //
        return PostDetail.fromEntity(findPostByIdWithException(id));
    }

    public void modifyPost(String postId, PostUpdate postUpdate) {
        //
        Post targetPost = findPostByIdWithException(postId);
        postStore.update(postUpdate.updatePost(targetPost));
    }

    public void deletePost(String id) {
        //
        Post targetPost = findPostByIdWithException(id);
        postStore.delete(targetPost);
    }

    public boolean existByPostId(String postId) {
        return postStore.exist(postId);
    }

    private Post findPostByIdWithException(String postId) {
        Post targetPost = postStore.retrieve(postId);
        Assert.notNull(targetPost, "Post not found!");
        return targetPost;
    }
}
