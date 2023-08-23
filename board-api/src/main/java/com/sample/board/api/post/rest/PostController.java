package com.sample.board.api.post.rest;

import com.sample.board.api.post.command.RegisterPostCommand;
import com.sample.board.api.post.PostApi;
import com.sample.board.core.post.dto.PostDetail;
import com.sample.board.core.post.dto.PostList;
import com.sample.board.core.post.dto.PostUpdate;
import com.sample.board.core.post.logic.PostLogic;
import com.sample.board.entity.post.model.PostCdo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController implements PostApi {

    private final PostLogic postLogic;

    @Override
    @GetMapping("/")
    public PostList findAllPosts() {
        return postLogic.findAllPosts();
    }

    @Override
    @PostMapping("/")
    public void registerPost(@RequestBody RegisterPostCommand command) {
        PostCdo cdo = command.getPostCdo();
        postLogic.registerPost(cdo);
    }

    @Override
    @GetMapping("/{postId}")
    public PostDetail findPostById(@PathVariable String postId) {
        return postLogic.findPostById(postId);
    }

    @Override
    @PutMapping("/{postId}")
    public void modifyPost(@PathVariable String postId, @RequestBody PostUpdate postUpdate) {
        postLogic.modifyPost(postId, postUpdate);
    }

    @Override
    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable String postId) {
        postLogic.deletePost(postId);
    }
}
