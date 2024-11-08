package study.board.domain.user.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import study.board.domain.user.enums.UserRole;

@Data
@NoArgsConstructor
public class UserInfo {

    private String name;
    private UserRole role;

}
