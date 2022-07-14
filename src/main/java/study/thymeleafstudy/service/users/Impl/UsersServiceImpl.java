package study.thymeleafstudy.service.users.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.thymeleafstudy.domain.users.Users;
import study.thymeleafstudy.domain.users.repository.UsersRepository;
import study.thymeleafstudy.service.users.UsersService;
import study.thymeleafstudy.web.dto.users.UsersRequestDto;

@Service
@RequiredArgsConstructor
@Transactional
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Override
    public Long join(UsersRequestDto requestDto) {
        Users users = requestDto.toEntity();
        users.addUserAuthority();
        usersRepository.save(users);
        return users.getId();
    }
}
