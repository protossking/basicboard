package com.board.service;

import com.board.domain.MemberEntity;
import com.board.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final MemberRepository memberRepository;

    public MemberEntity login (String memberId, String memberPassword) {
        MemberEntity findMemberEntity = memberRepository.findByMemberId(memberId);
        BCryptPasswordEncoder encode = new BCryptPasswordEncoder();

        if(encode.matches(memberPassword, findMemberEntity.getMemberPassword())) {
            System.out.println("로그인 성공 ");
            return findMemberEntity;
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
