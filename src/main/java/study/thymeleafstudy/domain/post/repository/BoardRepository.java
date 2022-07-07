package study.thymeleafstudy.domain.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.thymeleafstudy.domain.post.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
