package com.board.web.dto.board;

import com.board.domain.Board;
import com.board.domain.Member;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter

public class BoardListResponseDto {

    private Long no;
    private String title;
    private String content;
    private LocalDateTime modifiedDate;
    private String memberId;

    public BoardListResponseDto(Board entity) {
        this.no = entity.getBoardId();
        this.title = entity.getBoardTitle();
        this.content = entity.getBoardContent();
        this.modifiedDate = entity.getModifiedDate();
        this.memberId = entity.getMember().getMemberId();
    }
}