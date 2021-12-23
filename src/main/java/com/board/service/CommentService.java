package com.board.service;

import com.board.domain.*;
import com.board.web.dto.comment.CommentSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;


    public Long write(CommentSaveRequestDto dto, Long boardNo , MemberEntity memberEntity) {

        Optional<BoardEntity> findBoard = boardRepository.findById(boardNo);

        CommentEntity comment = CommentEntity.builder()
                .commentContent(dto.getCommentContent())
                .memberEntity(memberEntity)
                .board(findBoard.get())
                .build();

        return commentRepository.save(comment).getCommentId();


    }




}
