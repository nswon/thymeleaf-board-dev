package study.thymeleafstudy.service.post.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.thymeleafstudy.service.post.BoardService;
import study.thymeleafstudy.web.dto.post.BoardRequestDto;
import study.thymeleafstudy.web.dto.post.BoardResponseDto;
import study.thymeleafstudy.domain.board.Board;
import study.thymeleafstudy.domain.board.repository.BoardRepository;
import study.thymeleafstudy.web.dto.post.BoardUpdateRequestDto;

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
    public Page<Board> searchBoards(String keyword) {
        return new PageImpl<>(boardRepository.findByTitleContaining(keyword));
    }

    @Override
    public Page<Board> pagingBoard(int pageNum) {
        Pageable pageable = PageRequest.of(pageNum, 10);
        return boardRepository.findAll(pageable);
    }
}
