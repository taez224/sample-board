package com.sample.board.core.post.logic;

import com.sample.board.core.post.dto.PostDetail;
import com.sample.board.core.post.dto.PostList;
import com.sample.board.core.post.dto.PostUpdate;
import com.sample.board.entity.post.Post;
import com.sample.board.entity.post.model.PostCdo;
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
        postStore.create(Post.fromCdo(cdo));
    }

    public PostList findAllPosts() {
        //
        return PostList.fromEntities(postStore.retrieveAll());
    }

    public PostDetail findPostById(String id) {
        //
        return PostDetail.fromEntity(findPostByIdWithException(id));
    }

    public PostDetail modifyPost(String postId, PostUpdate postUpdate) {
        //
        Post targetPost = findPostByIdWithException(postId);
        postStore.update(postUpdate.updatePost(targetPost));
        return PostDetail.fromEntity(postStore.retrieve(postId));
    }

    public void deletePost(String id) {
        //
        postStore.delete(id);
    }

    private Post findPostByIdWithException(String postId) {
        Post targetPost = postStore.retrieve(postId);
        Assert.notNull(targetPost, "targetPost is null!");
        return targetPost;
    }
}
