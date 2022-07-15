package study.thymeleafstudy.domain.member.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import study.thymeleafstudy.domain.member.service.MemberService;
import study.thymeleafstudy.domain.member.presentation.dto.request.MemberRequestDto;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/join")
    public String signup() {
        return "/member/signup.html";
    }

    @PostMapping("/join")
    public String join(MemberRequestDto requestDto) {
        memberService.join(requestDto);
        return "redirect:/";
    }
}
