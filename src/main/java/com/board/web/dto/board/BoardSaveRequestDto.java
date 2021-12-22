package com.board.web.dto.board;


import com.board.domain.Board;
import com.board.domain.Member;
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


    public Board toEntity(Member member) {
        return Board.builder()
                .boardTitle(title)
                .boardContent(content)
                .member(member)
                .build();
    }
}
