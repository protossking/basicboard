package com.board.web.dto.board;


import com.board.domain.BoardEntity;
import com.board.domain.MemberEntity;
import com.board.service.param.BoardSaveParam;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
public class BoardSaveRequestDto {

    private String title;
    private String content;



    @Builder
    public BoardSaveRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public BoardSaveParam toParam() {
        return BoardSaveParam.builder()
                .title(title)
                .content(content)
                .build();
    }




}
