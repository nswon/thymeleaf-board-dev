package study.thymeleafstudy.domain.board.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.thymeleafstudy.domain.board.domain.Board;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findByTitleContaining(String keyword);
}
