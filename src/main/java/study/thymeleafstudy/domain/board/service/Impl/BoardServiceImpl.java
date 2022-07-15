package study.thymeleafstudy.domain.board.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.thymeleafstudy.domain.board.service.BoardService;
import study.thymeleafstudy.domain.board.presentation.dto.request.BoardRequestDto;
import study.thymeleafstudy.domain.board.presentation.dto.response.BoardResponseDto;
import study.thymeleafstudy.domain.board.domain.Board;
import study.thymeleafstudy.domain.board.domain.repository.BoardRepository;
import study.thymeleafstudy.domain.board.presentation.dto.request.BoardUpdateRequestDto;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    @Transactional
    @Override
    public Long createBoard(BoardRequestDto requestDto) {
        return boardRepository.save(requestDto.toEntity()).getId();
    }

    @Override
    public List<BoardResponseDto> allBoard() {
        return boardRepository.findAll().stream()
                .map(BoardResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public BoardResponseDto detailBoard(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 게시글입니다."));

        return BoardResponseDto.builder()
                .board(board)
                .build();
    }

    @Transactional
    @Override
    public Long updateBoard(Long id, BoardUpdateRequestDto requestDto) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 게시글입니다."));

        board.update(requestDto.getTitle(), requestDto.getContent(), requestDto.getWriter());
        return board.getId();
    }

    @Transactional
    @Override
    public Long deleteBoard(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 게시글입니다."));

        boardRepository.deleteById(id);
        return board.getId();
    }

    @Transactional
    @Override
    public Page<BoardResponseDto> searchBoards(String keyword) {
        List<BoardResponseDto> searchBoardDtoList = boardRepository.findByTitleContaining(keyword).stream()
                .map(BoardResponseDto::new)
                .collect(Collectors.toList());

        return new PageImpl<>(searchBoardDtoList);
    }

    @Override
    public Page<BoardResponseDto> pagingBoard(int pageNum) {
        Pageable pageable = PageRequest.of(pageNum, 10);
        return boardRepository.findAll(pageable)
                .map(BoardResponseDto::new);
    }
}
