package study.board.domain.post.service;

import study.board.domain.post.dto.PostRequest;
import study.board.domain.post.dto.PostResponce;

import java.util.List;

public interface PostService {

    //Create
    public void createPost(PostRequest postRequest);

    //Read
    public List<PostResponce> getPostList();

    public List<PostResponce> getPostByUserId(Long userId);

    public PostResponce getPostByPostId(Long postId);

    //Update
    public void updatePost(Long postId, PostRequest postRequest);

    //Delete
    public void deleteById(Long postId);

    public void deleteAll();

}
