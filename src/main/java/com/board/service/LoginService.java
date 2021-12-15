package com.board.service;

import com.board.domain.Member;
import com.board.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login (String memberId, String memberPassword) {
        Member findMember = memberRepository.findByMemberId(memberId);
        if(findMember.getMemberPassword().equals(memberPassword)) {
            return findMember;
        }
        return null;

    }
}
