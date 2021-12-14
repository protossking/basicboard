package com.board.domain;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    MemberRepository memberRepository;

    @After
    public void cleanUp() {
        boardRepository.deleteAll();
    }

    @Test
    public void 게시글_저장() {

        String title = "title";
        String content = "content";
        Member member = Member.builder()
                .id("mid")
                .password("mpw")
                .name("mname")
                .email("memail")
                .build();

        memberRepository.save(member);

        boardRepository.save(Board.builder()
                .title(title)
                .content(content)
                .member(member)
                .build());

        List<Board> list = boardRepository.findAll();

        Board board = list.get(0);
        Assertions.assertThat(board.getBoardTitle()).isEqualTo(title);
        Assertions.assertThat("mname").isEqualTo(member.getMemberName());
        Assertions.assertThat(board.getBoardContent()).isEqualTo(content);
    }

}