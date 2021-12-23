package com.board.web.dto.board;


import com.board.domain.BoardEntity;
import com.board.domain.MemberEntity;
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
    private MemberEntity memberEntity;

    @Builder
    public BoardSaveRequestDto(String title, String content, MemberEntity memberEntity) {
        this.title = title;
        this.content = content;
        this.memberEntity = memberEntity;
    }


    public BoardEntity toEntity() {

        return BoardEntity.builder()
                .boardTitle(title)
                .memberEntity(memberEntity)
                .boardContent(content)
                .build();
    }


}
