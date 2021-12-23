package com.board.web.dto.comment;

import com.board.domain.BoardEntity;
import com.board.domain.CommentEntity;
import com.board.domain.MemberEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentSaveRequestDto {

    private String commentContent;
    private MemberEntity memberEntity;
    private BoardEntity board;

    @Builder
    public CommentSaveRequestDto(String commentContent, MemberEntity memberEntity, BoardEntity board) {
        this.commentContent = commentContent;
        this.memberEntity = memberEntity;
        this.board = board;
    }

    public CommentEntity toEntity() {
        return CommentEntity.builder()
                .commentContent(commentContent)
                .memberEntity(memberEntity)
                .board(board)
                .build();

    }
}
