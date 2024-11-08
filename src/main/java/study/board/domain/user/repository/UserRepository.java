package study.board.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.board.domain.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
