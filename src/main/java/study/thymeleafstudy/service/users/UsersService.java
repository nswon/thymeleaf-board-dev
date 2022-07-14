package study.thymeleafstudy.service.users;

import study.thymeleafstudy.web.dto.users.UsersRequestDto;

public interface UsersService {

    Long join(UsersRequestDto requestDto);
}
