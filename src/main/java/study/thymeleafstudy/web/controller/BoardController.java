package study.thymeleafstudy.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import study.thymeleafstudy.service.BoardService;
import study.thymeleafstudy.web.dto.BoardRequestDto;
import study.thymeleafstudy.web.dto.BoardResponseDto;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/")
    public String allPost(Model model) {
        List<BoardResponseDto> boardAllList = boardService.all();
        model.addAttribute("boardAllList", boardAllList);
        return "board/list.html";
    }

    @GetMapping("/post")
    public String createPostPage() {
        return "board/write.html";
    }

    @PostMapping("/post")
    public String createPost(BoardRequestDto requestDto) {
        boardService.create(requestDto);
        return "redirect:/";
    }

    @GetMapping("/post/{id}")
    public String detailPost(@PathVariable("id") Long id, Model model) {
        BoardResponseDto boardDto = boardService.detail(id);
        model.addAttribute("boardDto", boardDto);
        return "board/detail.html";
    }

    @GetMapping("/post/edit/{id}")
    public String updatePostPage(@PathVariable("id") Long id, Model model) {
        BoardResponseDto boardDto = boardService.detail(id);
        model.addAttribute("boardDto", boardDto);
        return "board/update.html";
    }

    @PutMapping("/post/edit/{id}")
    public String updatePost(@PathVariable("id") Long id, BoardRequestDto boardDto) {
        boardService.update(id, boardDto);
        return "redirect:/";
    }

    @DeleteMapping("/post/{id}")
    public String deletePost(@PathVariable("id") Long id) {
        boardService.delete(id);
        return "redirect:/";
    }
}
