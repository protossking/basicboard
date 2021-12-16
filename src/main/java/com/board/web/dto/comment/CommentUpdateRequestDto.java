package com.board.web.dto.comment;

import com.board.domain.Board;
import com.board.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CommentUpdateRequestDto {

    private String commentContent;
    private Member member;
    private Board board;


    @Builder
    public CommentUpdateRequestDto(String commentContent, Member member, Board board) {
        this.commentContent = commentContent;
        this.member = member;
        this.board = board;
    }

}
