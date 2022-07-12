package study.thymeleafstudy.domain.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.thymeleafstudy.domain.post.Board;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByTitleContaining(String keyword);
}
