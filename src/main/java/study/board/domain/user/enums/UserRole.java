package study.board.domain.user.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum UserRole {

    ADMIN("관리자"),
    NORMAL_USER("일반유저");

    private final String description;
}
