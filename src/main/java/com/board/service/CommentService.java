package com.board.service;

import com.board.domain.*;
import com.board.web.dto.comment.CommentSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    public Long write(CommentSaveRequestDto dto, Long boardNo, Member member) {

        Optional<BoardEntity> findBoard = boardRepository.findById(boardNo);

        CommentEntity commentEntity = CommentEntity.builder()
                .commentContent(dto.getCommentContent())
                .member(member)
                .board(findBoard.get())
                .build();

        return commentRepository.save(commentEntity).getCommentId();
    }
}
