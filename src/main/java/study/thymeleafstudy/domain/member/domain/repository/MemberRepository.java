package study.thymeleafstudy.domain.member.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.thymeleafstudy.domain.member.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
