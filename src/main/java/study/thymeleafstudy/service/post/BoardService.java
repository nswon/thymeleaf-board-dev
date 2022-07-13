package study.thymeleafstudy.service.post;

import org.springframework.data.domain.Page;
import study.thymeleafstudy.web.dto.post.BoardRequestDto;
import study.thymeleafstudy.web.dto.post.BoardResponseDto;
import study.thymeleafstudy.web.dto.post.BoardUpdateRequestDto;

import java.util.List;

public interface BoardService {

    Long createBoard(BoardRequestDto requestDto);
    List<BoardResponseDto> allBoard();
    BoardResponseDto detailBoard(Long id);
    Long updateBoard(Long id, BoardUpdateRequestDto requestDto);
    Long deleteBoard(Long id);
    Page<BoardResponseDto> searchBoards(String keyword);
    Page<BoardResponseDto> pagingBoard(int pageNum);
}
