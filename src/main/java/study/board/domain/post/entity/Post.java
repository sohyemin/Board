package study.board.domain.post.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.board.domain.common.BaseTimeEntity;
import study.board.domain.post.dto.PostRequest;
import study.board.domain.post.enums.Poststatus;
import study.board.domain.user.entity.User;


@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "Post")
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE, targetEntity = User.class)
    @JoinColumn(name = "user_id", updatable = false)
    private User user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 1500)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Poststatus status;

    @Builder
    public Post(Long id, User user, String title, String content, Poststatus status) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.content = content;
        this.status = status;
    }

    public Post update(PostRequest request){
        return Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .status(request.getStatus())
                .build();
    }
}
