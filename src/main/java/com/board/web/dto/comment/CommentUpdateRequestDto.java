package com.board.web.dto.comment;

import com.board.domain.Board;
import com.board.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CommentUpdateRequestDto {

    private String commentContent;



    @Builder
    public CommentUpdateRequestDto(String commentContent) {
        this.commentContent = commentContent;

    }

}
