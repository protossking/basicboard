package com.board.service;

import com.board.domain.*;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceTest {

    @Autowired
    BoardRepository boardRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    MemberRepository memberRepository;

    @After
    public void cleanAll() {
        commentRepository.deleteAll();
        memberRepository.deleteAll();
        boardRepository.deleteAll();
    }

    @Test
    public void 댓글_저장() {
        //g
        String memberId = "aa";
        String memberName = "a";
        String memberEmail = "s";
        String memebrPassword = "c";
        Member member = Member.builder()
                .memberId(memberId)
                .memberName(memberName)
                .memberEmail(memberEmail)
                .memberPassword(memebrPassword)
                .build();

        memberRepository.save(member);

        String boardTitle = "title";
        String boardContent = "content";
        Member boardMember = member;
        BoardEntity boardEntity = BoardEntity.builder()
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .member(member)
                .build();

        Long boardNo = boardRepository.save(boardEntity).getBoardId();
        String commentContent = "commentContent";
        CommentEntity commentEntity = CommentEntity.builder()
                .board(boardEntity)
                .member(member)
                .commentContent(commentContent)
                .build();

        Long commentId = commentRepository.save(commentEntity).getCommentId();

        //w
        List<CommentEntity> list = commentRepository.findAll();

        Long commentNo = list.get(list.size() - 1).getCommentId();
        String commentContent2 = list.get(list.size() - 1).getCommentContent();
        String commentMemberName = list.get(list.size() - 1).getMember().getMemberName();
        Long commentBoardNo = list.get(list.size() - 1).getBoard().getBoardId();


        //t
        assertThat(commentNo).isEqualTo(commentId);
        assertThat(commentContent).isEqualTo(commentContent2);
        assertThat(memberName).isEqualTo(commentMemberName);
        assertThat(commentBoardNo).isEqualTo(boardNo);
    }
}