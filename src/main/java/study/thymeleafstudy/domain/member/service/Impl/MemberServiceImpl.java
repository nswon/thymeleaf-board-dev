package study.thymeleafstudy.domain.member.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.thymeleafstudy.domain.member.domain.Member;
import study.thymeleafstudy.domain.member.domain.repository.MemberRepository;
import study.thymeleafstudy.domain.member.presentation.dto.response.MemberResponseDto;
import study.thymeleafstudy.domain.member.service.MemberService;
import study.thymeleafstudy.domain.member.presentation.dto.request.MemberRequestDto;

import java.util.NoSuchElementException;

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

    @Override
    public MemberResponseDto findMember(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("해당 닉네임의 사용자가 존재하지 않습니다."));

        return MemberResponseDto.builder()
                .member(member)
                .build();
    }
}
