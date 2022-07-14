package study.thymeleafstudy.web.dto.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import study.thymeleafstudy.domain.users.Users;

@Getter
@AllArgsConstructor
@Builder
public class UsersRequestDto {

    private String nickname;
    private String password;

    public Users toEntity() {
        return Users.builder()
                .nickname(nickname)
                .password(password)
                .build();
    }

}
