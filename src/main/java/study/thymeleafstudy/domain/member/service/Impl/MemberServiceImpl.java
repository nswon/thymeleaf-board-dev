package study.thymeleafstudy.domain.member.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.thymeleafstudy.domain.member.domain.Member;
import study.thymeleafstudy.domain.member.domain.repository.MemberRepository;
import study.thymeleafstudy.domain.member.service.MemberService;
import study.thymeleafstudy.domain.member.presentation.dto.request.MemberRequestDto;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Long join(MemberRequestDto requestDto) {
        Member member = requestDto.toEntity();
        member.addUserAuthority();
        memberRepository.save(member);
        return member.getId();
    }
}
