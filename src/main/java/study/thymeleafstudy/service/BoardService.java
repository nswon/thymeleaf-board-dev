package study.thymeleafstudy.service;

import study.thymeleafstudy.web.dto.BoardRequestDto;
import study.thymeleafstudy.web.dto.BoardResponseDto;

import java.util.List;

public interface BoardService {

    Long create(BoardRequestDto requestDto);
    List<BoardResponseDto> all();
    BoardResponseDto detail(Long id);
    Long update(Long id, BoardRequestDto requestDto);
    Long delete(Long id);
}
