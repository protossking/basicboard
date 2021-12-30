package com.board.web.dto.comment;

import com.board.domain.BoardEntity;
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
    private BoardEntity boardEntity;

    @Builder
    public CommentSaveRequestDto(String commentContent, Member member, BoardEntity boardEntity) {
        this.commentContent = commentContent;
        this.member = member;
        this.boardEntity = boardEntity;
    }
}
