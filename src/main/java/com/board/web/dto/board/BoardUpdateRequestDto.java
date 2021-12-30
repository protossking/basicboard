package com.board.web.dto.board;

import com.board.service.BoardUpdateParam;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
public class BoardUpdateRequestDto {

    private String title;
    private String content;
    private String boardAuthorId;

    @Builder
    public BoardUpdateRequestDto(String title, String content, String boardAuthorId) {
        this.title = title;
        this.content = content;
        this.boardAuthorId = boardAuthorId;
    }

    public BoardUpdateParam toParam() {
        return new BoardUpdateParam(title, content, boardAuthorId);
    }
}
