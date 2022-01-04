package com.board.service;

import com.board.domain.BoardEntity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardDetail {

    private  Long boardNo;
    private  String memberId;
    private  String boardTitle;
    private  String boardContent;
    private  LocalDateTime createdTime;
    private  LocalDateTime modifiedDate;

    public BoardDetail (BoardEntity boardEntity) {
        this.boardNo = boardEntity.getBoardId();
        this.memberId = boardEntity.getMemberEntity().getMemberId();
        this.boardTitle = boardEntity.getBoardTitle();
        this.boardContent = boardEntity.getBoardContent();
        this.createdTime = boardEntity.getCreatedDate();
        this.modifiedDate = boardEntity.getModifiedDate();
    }


}
