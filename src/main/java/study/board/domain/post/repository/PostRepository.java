package study.board.domain.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.board.domain.post.entity.Post;
import study.board.domain.user.entity.User;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    public List<Post> findByUser(User user);
}
