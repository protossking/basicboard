package com.board.web.dto.board;


import com.board.domain.BoardEntity;
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


    public BoardEntity toEntity(Member member) {
        return BoardEntity.builder()
                .boardTitle(title)
                .boardContent(content)
                .member(member)
                .build();
    }
}
