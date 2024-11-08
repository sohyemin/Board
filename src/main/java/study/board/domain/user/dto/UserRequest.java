package study.board.domain.user.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import study.board.domain.user.entity.User;
import study.board.domain.user.enums.UserRole;

@Data
public class UserRequest {

    private String name;
    private String phone;
    private String email;
    private UserRole role;

    public User of(){
        return User.builder()
                .name(name)
                .phone(phone)
                .email(email)
                .role(role)
                .build();
    }
}
