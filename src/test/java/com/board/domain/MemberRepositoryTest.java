package com.board.domain;


import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {
    
    @Autowired
    MemberRepository repository;

    @After
    public void clean(){
        repository.deleteAll();
    }
    @Test
    public void 회원_저장() {
        String id = "a1";
        String name = "y";
        String password = "d";
        String email = "@";

        Member saveMember = repository.save(Member.builder()
                .id(id)
                .name(name)
                .password(password)
                .email(email)
                .build());
        assertThat(saveMember.getMemberId()).isEqualTo(id);
        assertThat(saveMember.getMemberPassword()).isEqualTo(password);
        assertThat(saveMember.getMemberName()).isEqualTo(name);
        assertThat(saveMember.getMemberEmail()).isEqualTo(email);


    }


    @Test
    public void 회원_저장_불러오기 () {
        //g
        String id = "a1";
        String name = "y";
        String password = "d";
        String email="@";



        repository.save(Member.builder()
                .id(id)
                .name(name)
                .password(password)
                .email(email)
                .build());

        //w
        List<Member> list = repository.findAll();



        //t
        Member member = list.get(0);
        assertThat(member.getMemberId()).isEqualTo(id);
        assertThat(member.getMemberName()).isEqualTo(name);
        assertThat(member.getMemberPassword()).isEqualTo(password);
        assertThat(member.getMemberEmail()).isEqualTo(email);

    }


}