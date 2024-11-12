package study.board.domain.comment.dto;

import lombok.Builder;
import lombok.Data;
import study.board.domain.comment.entity.Comment;

import java.time.LocalDateTime;

@Data
public class CommentResponce {

    private final String content;
    private final String userName;
    private final LocalDateTime createdAt;

    @Builder
    public CommentResponce(String content, String userName, LocalDateTime createdAt) {
        this.content = content;
        this.userName = userName;
        this.createdAt = createdAt;
    }

    public static CommentResponce mapToDto(Comment comment) {
        return CommentResponce.builder()
                .content(comment.getContent())
                .userName(comment.getUser().getName())
                .createdAt(comment.getCreatedAt())
                .build();
    }
}
