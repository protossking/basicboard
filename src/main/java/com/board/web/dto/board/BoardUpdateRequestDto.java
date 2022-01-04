package com.board.web.dto.board;

import com.board.service.param.BoardUpdateParam;
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
    private String memberId;

    public BoardUpdateRequestDto(String title, String content, String memberId) {
        this.title = title;
        this.content = content;
        this.memberId = memberId;
    }

    public BoardUpdateParam toParam() {
        return new BoardUpdateParam(this.title, this.content, this.memberId);
    }



}
