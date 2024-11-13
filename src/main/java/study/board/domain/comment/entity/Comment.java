package study.board.domain.comment.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.board.domain.comment.dto.CommentRequest;
import study.board.domain.comment.enums.CommentStatus;
import study.board.domain.common.BaseTimeEntity;
import study.board.domain.post.entity.Post;
import study.board.domain.user.entity.User;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "comment")
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comment_id")
    private Long id;

    @Column(nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CommentStatus status;

    @ManyToOne(cascade = CascadeType.MERGE, targetEntity = User.class)
    @Column(nullable = false)
    private User user;

    @OneToOne(cascade = CascadeType.MERGE, targetEntity = Post.class)
    @Column(nullable = false)
    private Post post;

    @Builder
    public Comment(String content, CommentStatus status, User user, Post post) {
        this.content = content;
        this.status = status;
        this.user = user;
        this.post = post;
    }

    public void update(CommentRequest request) {
        Comment.builder()
                .content(request.getContent())
                .build();
    }

    public void deleteStatus() {
        Comment.builder()
                .status(CommentStatus.DELETE)
                .build();
    }
}
