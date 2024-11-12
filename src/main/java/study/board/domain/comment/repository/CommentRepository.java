package study.board.domain.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.board.domain.comment.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
