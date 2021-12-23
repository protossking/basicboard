package com.board.service;

import com.board.domain.MemberEntity;
import com.board.domain.MemberRepository;
import com.board.service.param.MemberSaveParam;
import com.board.web.dto.member.MemberResponseDto;
import com.board.web.dto.member.MemberSaveRequestDto;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberServiceTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberService memberService;

    @Autowired
    private  PasswordEncoder passwordEncoder;


    @After
    public void cleanUp (){
        memberRepository.deleteAll();;
    }

    @Test
    public void 회원_등록() {
        //g
        String memberId = "asd";
        String memberName = "asdname";
        String memberPassword = "ccc";
        String memberEmail = "asd@";


        MemberSaveRequestDto request = MemberSaveRequestDto.builder()
                .id(memberId)
                .name(memberName)
                .password(memberPassword)
                .email(memberEmail)
                .build();
        memberService.save(request.toParam());

        //w

        List<MemberEntity> list = memberRepository.findAll();
        MemberEntity memberEntity = list.get(0);

        //t
        Assertions.assertThat(memberEntity.getMemberId()).isEqualTo(memberId);
        Assertions.assertThat(memberEntity.getMemberName()).isEqualTo(memberName);
        Assertions.assertThat(memberEntity.getMemberEmail()).isEqualTo(memberEmail);

    }

}