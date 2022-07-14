package study.thymeleafstudy.web.dto.users;

import lombok.Builder;
import lombok.Getter;
import study.thymeleafstudy.domain.users.Users;

@Getter
public class UsersResponseDto {

    private Long id;
    private String nickname;
    private String password;

    @Builder
    public UsersResponseDto(Users users) {
        this.id = users.getId();
        this.nickname = users.getNickname();
        this.password = users.getPassword();
    }
}
