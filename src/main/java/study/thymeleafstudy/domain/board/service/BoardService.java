package study.thymeleafstudy.domain.board.service;

import org.springframework.data.domain.Page;
import study.thymeleafstudy.domain.board.presentation.dto.request.BoardRequestDto;
import study.thymeleafstudy.domain.board.presentation.dto.response.BoardResponseDto;
import study.thymeleafstudy.domain.board.presentation.dto.request.BoardUpdateRequestDto;

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
