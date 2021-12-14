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
    private Member member;

    @Builder
    public BoardSaveRequestDto(String title, String content, Member member) {
        this.title = title;
        this.content = content;
        this.member = member;
    }


    public Board toEntity() {

        return Board.builder()
                .boardTitle(title)
                .member(member)
                .boardContent(content)
                .build();
    }


}
