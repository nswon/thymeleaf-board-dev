package study.thymeleafstudy.domain.member.service;

import study.thymeleafstudy.domain.member.presentation.dto.request.MemberRequestDto;
import study.thymeleafstudy.domain.member.presentation.dto.response.MemberResponseDto;

public interface MemberService {

    Long join(MemberRequestDto requestDto);
    MemberResponseDto findMember(Long id);
}
