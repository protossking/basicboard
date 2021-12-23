package com.board.web.dto.board;

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

    @Builder
    public BoardUpdateRequestDto(String title, String content, String memberId) {
        this.title = title;
        this.content = content;
        this.memberId = memberId;
    }



}
