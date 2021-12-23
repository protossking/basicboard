package com.board.web.dto.board;


import com.board.domain.BoardEntity;
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




    public BoardDetailResponseDto (BoardEntity board) {
        this.memberId = board.getMemberEntity().getMemberId();
        this.boardNo = board.getBoardId();
        this.boardTitle = board.getBoardTitle();
        this.boardContent = board.getBoardContent();
        this.createdDate = board.getCreatedDate();
        this.modifiedDate = board.getModifiedDate();



    }

}
