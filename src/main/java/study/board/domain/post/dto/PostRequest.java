package study.board.domain.post.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import study.board.domain.post.entity.Post;
import study.board.domain.post.enums.Poststatus;
import study.board.domain.user.entity.User;

@Data
@RequiredArgsConstructor
public class PostRequest {

    private Long user_id;
    private String title;
    private String content;
    private Poststatus status;

    @Builder
    public PostRequest(Long user_id, String title, String content, Poststatus status) {
        this.user_id = user_id;
        this.title = title;
        this.content = content;
        this.status = status;
    }

    public Post mapToEntity(User user){
        return Post.builder()
                .user(user)
                .title(title)
                .content(content)
                .status(status)
                .build();
    }
}
