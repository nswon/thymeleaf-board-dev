package study.thymeleafstudy.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.thymeleafstudy.service.BoardService;
import study.thymeleafstudy.web.dto.BoardRequestDto;
import study.thymeleafstudy.web.dto.BoardResponseDto;
import study.thymeleafstudy.domain.post.Board;
import study.thymeleafstudy.domain.post.repository.BoardRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    @Override
    public Long create(BoardRequestDto requestDto) {
        return boardRepository.save(requestDto.toEntity()).getId();
    }

    @Override
    public List<BoardResponseDto> all() {
        return boardRepository.findAll().stream()
                .map(BoardResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public BoardResponseDto detail(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 게시글입니다."));

        return BoardResponseDto.builder()
                .board(board)
                .build();
    }

    @Transactional
    @Override
    public Long update(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 게시글입니다."));

        board.update(requestDto.getTitle(), requestDto.getContent(), requestDto.getWriter());
        return board.getId();
    }

    @Transactional
    @Override
    public Long delete(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 게시글입니다."));

        boardRepository.deleteById(id);
        return board.getId();
    }
}
