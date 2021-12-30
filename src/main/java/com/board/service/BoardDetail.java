package com.board.service;

import com.board.domain.BoardEntity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardDetail {
    private final String memberId;
    private final Long boardNo;
    private final String boardTitle;
    private final String boardContent;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

    public BoardDetail(BoardEntity boardEntity) {
        this.memberId = boardEntity.getMember().getMemberId();
        this.boardNo = boardEntity.getBoardId();
        this.boardTitle = boardEntity.getBoardTitle();
        this.boardContent = boardEntity.getBoardContent();
        this.createdDate = boardEntity.getCreatedDate();
        this.modifiedDate = boardEntity.getModifiedDate();
    }
}
