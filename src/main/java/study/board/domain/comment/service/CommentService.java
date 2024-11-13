package study.board.domain.comment.service;

import study.board.domain.comment.dto.CommentRequest;
import study.board.domain.comment.dto.CommentResponce;

import java.util.List;

public interface CommentService {
    //CREATE
    public void createComment(CommentRequest request);

    //READ
    public List<CommentResponce> getComment(Long postId);

    //UPDATE
    public void updateComment(Long commentId, CommentRequest request);

    //DELETE
    public void deleteById(Long commentId);
}
