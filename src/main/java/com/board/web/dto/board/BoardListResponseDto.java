package com.board.web.dto.board;

import com.board.domain.BoardEntity;
import com.board.domain.CommentEntity;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter

public class BoardListResponseDto {

    private Long no;
    private String title;
    private String content;
    private LocalDateTime modifiedDate;
    private String memberId;
    private List<CommentEntity> list;

    public BoardListResponseDto(BoardEntity entity) {
        this.no = entity.getBoardId();
        this.title = entity.getBoardTitle();
        this.content = entity.getBoardContent();
        this.modifiedDate = entity.getModifiedDate();
        this.memberId = entity.getMember().getMemberId();
        this.list = entity.getList();
    }


}
