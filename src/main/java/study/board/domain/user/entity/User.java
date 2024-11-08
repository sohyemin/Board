package study.board.domain.user.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import study.board.domain.user.enums.UserRole;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    private String email;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Builder
    public User(String name, String phone, String email, UserRole role) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.role = role;
    }

    public void update(User user) {
        this.name = user.name;
        this.phone = user.phone;
        this.email = user.email;
        this.role = user.role;
    }
}
