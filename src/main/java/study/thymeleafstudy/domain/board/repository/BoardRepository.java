package study.thymeleafstudy.domain.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.thymeleafstudy.domain.board.Board;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findByTitleContaining(String keyword);
}
