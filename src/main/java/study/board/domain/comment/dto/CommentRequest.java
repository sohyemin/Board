package study.board.domain.comment.dto;

import lombok.Builder;
import lombok.Data;
import study.board.domain.comment.entity.Comment;
import study.board.domain.post.entity.Post;
import study.board.domain.user.entity.User;

@Data
public class CommentRequest {

    private final String content;
    private final Long userId;
    private final Long postId;

    @Builder
    public CommentRequest(String content, Long userId, Long postId) {
        this.content = content;
        this.userId = userId;
        this.postId = postId;
    }

    public Comment of(User user, Post post, CommentRequest request) {
        return Comment.builder()
                .content(request.getContent())
                .user(user)
                .post(post)
                .build();
    }
}
