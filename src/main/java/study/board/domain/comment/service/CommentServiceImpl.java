package study.board.domain.comment.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.board.domain.comment.dto.CommentRequest;
import study.board.domain.comment.dto.CommentResponce;
import study.board.domain.comment.entity.Comment;
import study.board.domain.comment.repository.CommentRepository;
import study.board.domain.post.entity.Post;
import study.board.domain.post.repository.PostRepository;
import study.board.domain.user.entity.User;
import study.board.domain.user.repository.UserRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Override
    public void createComment(CommentRequest request) {

        User findUser = userRepository.findById(request.getUserId())
                .orElseThrow(() -> {
                    log.error("해당 유저가 존재하지 않습니다.");
                    throw new RuntimeException("Can't find user by Id : " + request.getUserId());
                });
        Post findPost = postRepository.findById(request.getPostId())
                .orElseThrow(() -> {
                    log.error("해당 포스트가 존재하지 않습니다.");
                    throw new RuntimeException("Can't find post by Id : " + request.getPostId());
                });

        commentRepository.save(request.of(findUser, findPost, request));

    }

    @Override
    public List<CommentResponce> getComment(Long postId) {

        Post findPost = postRepository.findById(postId)
                .orElseThrow(() -> {
                    log.error("해당 포스트가 존재하지 않습니다.");
                    throw new RuntimeException("Can't find post by Id : " + postId);
                });

        return commentRepository.findByPost(findPost)
                .stream()
                .map(CommentResponce::mapToDto)
                .toList();
    }

    @Override
    public void updateComment(Long commentId, CommentRequest request) {
        Comment findComment = commentRepository.findById(commentId).get();
        findComment.update(request);

        commentRepository.save(findComment);
    }

    @Override
    public void deleteById(Long commentId) {
        Comment findComment = commentRepository.findById(commentId).get();
        findComment.deleteStatus();
    }
}
