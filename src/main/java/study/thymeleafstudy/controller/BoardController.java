package study.thymeleafstudy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import study.thymeleafstudy.dto.BoardRequestDto;
import study.thymeleafstudy.dto.BoardResponseDto;
import study.thymeleafstudy.service.BoardService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/")
    public String list(Model model) {
        List<BoardResponseDto> boardDtoList = boardService.all();
        model.addAttribute("boardList", boardDtoList);

        return "board/list.html";
    }

    @GetMapping("/post")
    public String write() {
        return "board/write.html";
    }

    @PostMapping("/post")
    public String write(BoardRequestDto requestDto) {
        boardService.savePost(requestDto);
        return "redirect:/";
    }

    @GetMapping("/post/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        BoardResponseDto boardDto = boardService.detail(id);
        model.addAttribute("boardDto", boardDto);
        return "board/detail.html";
    }

    @GetMapping("/post/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        BoardResponseDto boardDto = boardService.detail(id);
        model.addAttribute("boardDto", boardDto);
        return "board/update.html";
    }

    @PutMapping("/post/edit/{id}")
    public String update(@PathVariable("id") Long id, BoardRequestDto boardDto) {
        boardService.update(id, boardDto);
        return "redirect:/";
    }

    @DeleteMapping("/post/{id}")
    public String delete(@PathVariable("id") Long id) {
        boardService.delete(id);
        return "redirect:/";
    }
}
