package com.board.service;

import com.board.domain.Member;
import com.board.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login (String memberId, String memberPassword) {
        Member findMember = memberRepository.findByMemberId(memberId);
        BCryptPasswordEncoder encode = new BCryptPasswordEncoder();

        if(encode.matches(memberPassword, findMember.getMemberPassword())) {
            System.out.println("로그인 성공 ");
            return findMember;
        }


//        if(findMember.getMemberPassword().equals(memberPassword)) {
//            System.out.println("로그인 성공 !!!! ");
//            return findMember;
//        }
        System.out.println("로그인 실패 ");
//        return null;
        return null;
    }
}
