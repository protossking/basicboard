package com.board.web.dto.board;

import com.board.domain.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter

public class BoardListResponseDto {

    private Long no;
    private String title;
    private String content;
    private LocalDateTime modifiedDate;

    public BoardListResponseDto(Board entity) {
        this.no = entity.getNo();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.modifiedDate = entity.getModifiedDate();
    }
}
