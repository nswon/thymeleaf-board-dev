package study.thymeleafstudy.domain.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.thymeleafstudy.domain.users.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
