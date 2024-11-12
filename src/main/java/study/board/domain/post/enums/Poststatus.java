package study.board.domain.post.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Poststatus {

    PUBLIC("공개"),
    PRIVATE("비공개"),
    DELETE("삭제");

    private final String status;
}
