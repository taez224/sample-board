package com.sample.board.api.post;

import com.sample.board.domain.post.entity.Post;
import com.sample.board.domain.post.entity.model.PostCdo;
import com.sample.board.core.post.logic.PostLogic;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostLogic postLogic;

    @GetMapping("/")
    public List<Post> findAllPosts() {
        return postLogic.findAllPosts();
    }

    @PostMapping("/")
    public void registerPost(@RequestBody PostCdo cdo) {
        Post post = Post.fromCdo(cdo);
        postLogic.registerPost(post);
    }

    @GetMapping("/{postId}")
    public Post findPostById(@PathVariable String postId) {
        return postLogic.findPostById(postId);
    }

    @PutMapping("/{postId}")
    public void modifyPost(@PathVariable String postId, @RequestBody Post post) {

    }
}
