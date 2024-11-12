package study.board.domain.post.dto;


import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import study.board.domain.post.entity.Post;

@Data
public class PostResponce {

    private final String userName;
    private final String title;
    private final String content;

    @Builder
    public PostResponce(String userName, String title, String content) {
        this.userName = userName;
        this.title = title;
        this.content = content;
    }

    public static PostResponce mapToDto(Post post){
        return PostResponce.builder()
                .userName(post.getUser().getName())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }
}

