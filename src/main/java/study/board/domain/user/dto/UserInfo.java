package study.board.domain.user.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import study.board.domain.user.entity.User;
import study.board.domain.user.enums.UserRole;

@Data
@NoArgsConstructor
public class UserInfo {

    private String name;
    private UserRole role;

    @Builder
    public UserInfo(String name, UserRole role) {
        this.name = name;
        this.role = role;
    }

    public static UserInfo mapToDto(User user) {
        return UserInfo.builder()
                .name(user.getName())
                .role(user.getRole())
                .build();
    }
}
