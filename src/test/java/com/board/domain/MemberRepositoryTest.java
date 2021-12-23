package com.board.domain;


import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        String name = "양";
        String id = "aa";
        String password = "a";
        String email = "@";

        MemberEntity entity = MemberEntity.builder()
                .memberId(id)
                .memberName(name)
                .memberPassword(password)
                .memberEmail(email)
                .build();
        repository.save(entity);

        List<MemberEntity> member = repository.findAll();
        MemberEntity memberEntity = member.get(0);

        //then


        assertThat(memberEntity.getMemberName()).isEqualTo(name);
        assertThat(memberEntity.getMemberId()).isEqualTo(id);
        assertThat(memberEntity.getMemberPassword()).isEqualTo(password);
        assertThat(memberEntity.getMemberEmail()).isEqualTo(email);

    }





}