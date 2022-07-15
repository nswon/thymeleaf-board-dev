package study.thymeleafstudy.domain.member.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import study.thymeleafstudy.domain.member.domain.Member;

@Getter
public class MemberResponseDto {

    private Long id;
    private String nickname;
    private String password;

    @Builder
    public MemberResponseDto(Member member) {
        this.id = member.getId();
        this.nickname = member.getNickname();
        this.password = member.getPassword();
    }
}
