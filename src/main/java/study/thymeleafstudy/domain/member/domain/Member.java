package study.thymeleafstudy.domain.member.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String nickname;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

//    회원가입시 USER권한 부여
    public void addUserAuthority() {
        this.role = Role.USER;
    }

}
