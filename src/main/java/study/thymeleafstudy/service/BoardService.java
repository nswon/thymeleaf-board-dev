package study.thymeleafstudy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.thymeleafstudy.dto.BoardRequestDto;
import study.thymeleafstudy.dto.BoardResponseDto;
import study.thymeleafstudy.entity.Board;
import study.thymeleafstudy.repository.BoardRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long savePost(BoardRequestDto requestDto) {
        return boardRepository.save(requestDto.toEntity()).getId();
    }

    public List<BoardResponseDto> all() {
        return boardRepository.findAll().stream()
                .map(BoardResponseDto::new)
                .collect(Collectors.toList());
    }

    public BoardResponseDto detail(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 게시글입니다."));

        return BoardResponseDto.builder()
                .board(board)
                .build();
    }

    @Transactional
    public Long update(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 게시글입니다."));

        board.update(requestDto.getTitle(), requestDto.getContent(), requestDto.getWriter());
        return board.getId();
    }

    @Transactional
    public void delete(Long id) {
        boardRepository.deleteById(id);
    }
}
