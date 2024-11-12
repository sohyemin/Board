package study.board.domain.comment.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CommentStatus {

    PUBLIC("공개"),
    DELETE("삭제");

    private final String status;
}
