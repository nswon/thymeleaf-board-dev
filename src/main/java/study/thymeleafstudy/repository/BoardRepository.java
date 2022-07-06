package study.thymeleafstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.thymeleafstudy.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
