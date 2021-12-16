package com.board.service;

import com.board.domain.*;
import com.board.web.dto.comment.CommentSaveRequestDto;
import com.board.web.dto.comment.CommentUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;


    public Long write(CommentSaveRequestDto dto, Long boardNo , String memberId) {
        Member findMember = memberRepository.findByMemberId(memberId);
        Optional<Board> findBoard = boardRepository.findById(boardNo);

        Comment comment = Comment.builder()
                .commentContent(dto.getCommentContent())
                .member(findMember)
                .board(findBoard.get())
                .build();

        return commentRepository.save(comment).getCommentId();


    }

//    public Long modify(CommentUpdateRequestDto dto, Long boardNo, Long commentNo, String memberId) {
//        commentRepository.modify(dto.getCommentContent(), boardNo, memberId)
//
//
//    }


}
