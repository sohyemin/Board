package study.board.domain.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.board.domain.comment.dto.CommentResponce;
import study.board.domain.comment.entity.Comment;
import study.board.domain.post.entity.Post;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    public List<Comment> findByPost(Post post);
}
