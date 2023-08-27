package com.sample.board.api.post.rest;

import com.sample.board.api.common.BaseResponse;
import com.sample.board.api.post.PostApi;
import com.sample.board.api.post.command.RegisterPostCommand;
import com.sample.board.core.post.logic.PostLogic;
import com.sample.board.core.post.model.PostCdo;
import com.sample.board.core.post.model.PostDetail;
import com.sample.board.core.post.model.PostList;
import com.sample.board.core.post.model.PostUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController implements PostApi {

    private final PostLogic postLogic;

    @Override
    @GetMapping("")
    public BaseResponse<PostList> findAllPosts() {
        return BaseResponse.of(postLogic.findAllPosts());
    }

    @Override
    @PostMapping("")
    public BaseResponse<String> registerPost(@RequestBody RegisterPostCommand command) {
        PostCdo cdo = command.getPostCdo();
        postLogic.registerPost(cdo);
        return BaseResponse.created(cdo.getTitle());
    }

    @Override
    @GetMapping("/{postId}")
    public BaseResponse<PostDetail> findPostById(@PathVariable String postId) {
        return BaseResponse.of(postLogic.findPostById(postId));
    }

    @Override
    @PutMapping("/{postId}")
    public BaseResponse<String> modifyPost(@PathVariable String postId, @RequestBody PostUpdate postUpdate) {
        postLogic.modifyPost(postId, postUpdate);
        return BaseResponse.of(postId);
    }

    @Override
    @DeleteMapping("/{postId}")
    public BaseResponse<String> deletePost(@PathVariable String postId) {
        postLogic.deletePost(postId);
        return BaseResponse.of(postId);
    }
}
