package study.thymeleafstudy.domain.member.service;

import study.thymeleafstudy.domain.member.presentation.dto.request.MemberRequestDto;

public interface MemberService {

    Long join(MemberRequestDto requestDto);
}
