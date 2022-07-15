package study.thymeleafstudy.domain.board.presentation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import study.thymeleafstudy.domain.board.service.BoardService;
import study.thymeleafstudy.domain.board.presentation.dto.request.BoardRequestDto;
import study.thymeleafstudy.domain.board.presentation.dto.request.BoardUpdateRequestDto;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/")
    public String allBoard(Model model, @RequestParam(value = "page", defaultValue = "0") int pageNum) {
        model.addAttribute("paging", boardService.pagingBoard(pageNum));
        return "board/list.html";
    }

    @GetMapping("/board")
    public String createBoardPage() {
        return "board/write.html";
    }

    @PostMapping("/board")
    public String createBoard(BoardRequestDto requestDto) {
        boardService.createBoard(requestDto);
        return "redirect:/";
    }

    @GetMapping("/board/{id}")
    public String detailBoardPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("detailBoard", boardService.detailBoard(id));
        return "board/detail.html";
    }

    @GetMapping("/board/edit/{id}")
    public String updateBoardPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("detailBoard", boardService.detailBoard(id));
        return "board/update.html";
    }

    @PutMapping("/board/edit/{id}")
    public String updateBoard(@PathVariable("id") Long id, BoardUpdateRequestDto boardDto) {
        boardService.updateBoard(id, boardDto);
        return "redirect:/";
    }

    @DeleteMapping("/board/{id}")
    public String deleteBoard(@PathVariable("id") Long id) {
        boardService.deleteBoard(id);
        return "redirect:/";
    }

    @GetMapping("/board/search")
    public String searchBoard(@RequestParam("keyword") String keyword, Model model) {
        model.addAttribute("paging", boardService.searchBoards(keyword));
        return "board/list.html";
    }
}
