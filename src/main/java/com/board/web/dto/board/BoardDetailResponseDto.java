package com.board.web.dto.board;


import com.board.domain.BoardEntity;
import com.board.service.BoardDetail;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor

public class BoardDetailResponseDto {

    private String memberId;
    private Long boardNo;
    private String boardTitle;
    private String boardContent;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;


    public BoardDetailResponseDto(BoardDetail boardDetail) {
        this.memberId = boardDetail.getMemberId();
        this.boardNo = boardDetail.getBoardNo();
        this.boardTitle = boardDetail.getBoardTitle();
        this.boardContent = boardDetail.getBoardContent();
        this.createdDate = boardDetail.getCreatedTime();
        this.modifiedDate = boardDetail.getModifiedDate();
    }




}
