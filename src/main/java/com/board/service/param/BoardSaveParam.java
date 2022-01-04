package com.board.service.param;


import com.board.domain.BoardEntity;
import com.board.domain.MemberEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardSaveParam {

    private String title;
    private String content;

    public BoardSaveParam(String title, String content) {

        this.title = title;
        this.content = content;

    }

    public BoardEntity toEntity(MemberEntity memberEntity) {

        return BoardEntity.builder()
                .boardTitle(title)
                .boardContent(content)
                .memberEntity(memberEntity)
                .build();
    }
}
