package study.thymeleafstudy.domain.member.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import study.thymeleafstudy.domain.member.domain.Member;

@Getter
@AllArgsConstructor
@Builder
public class MemberRequestDto {

    private String nickname;
    private String password;

    public Member toEntity() {
        return Member.builder()
                .nickname(nickname)
                .password(password)
                .build();
    }

}
