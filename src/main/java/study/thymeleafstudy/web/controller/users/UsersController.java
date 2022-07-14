package study.thymeleafstudy.web.controller.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import study.thymeleafstudy.service.users.UsersService;
import study.thymeleafstudy.web.dto.users.UsersRequestDto;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    @GetMapping("/signup")
    public String signup() {
        return "/users/signup.html";
    }

    @PostMapping("/signup")
    public String signup(UsersRequestDto requestDto) {
        usersService.join(requestDto);
        return "redirect:/";
    }
}
