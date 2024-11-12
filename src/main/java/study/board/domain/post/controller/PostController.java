package study.board.domain.post.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import study.board.domain.post.dto.PostRequest;
import study.board.domain.post.dto.PostResponce;
import study.board.domain.post.service.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/post")
    private void uploadPost(@RequestBody PostRequest postRequest){
        postService.createPost(postRequest);
    }

    @GetMapping("/Board")
    private List<PostResponce> getAllPost(){
        return postService.getPostList();
    }

    @GetMapping("/Board/UserId={id}")
    private List<PostResponce> getPostByUser(@PathVariable("id") Long userId){
        return postService.getPostByUserId(userId);
    }

    @GetMapping("/Board/{id}")
    private PostResponce getPostByPostId(@PathVariable("id") Long postId) {
        return postService.getPostByPostId(postId);
    }
}
