package com.board.web.dto.comment;

import com.board.domain.Board;
import com.board.domain.Comment;
import com.board.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentSaveRequestDto {

    private String commentContent;
    private Member member;
    private Board board;

    @Builder
    public CommentSaveRequestDto(String commentContent, Member member, Board board) {
        this.commentContent = commentContent;
        this.member = member;
        this.board = board;
    }

    public Comment toEntity() {
        return Comment.builder()
                .commentContent(commentContent)
                .member(member)
                .board(board)
                .build();

    }
}
