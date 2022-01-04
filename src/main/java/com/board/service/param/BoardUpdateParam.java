package com.board.service.param;

import lombok.Getter;

@Getter
public class BoardUpdateParam {

    private String title;
    private String content;
    private String memberId;



    public BoardUpdateParam(String title, String content, String memberId) {
        this.title = title;
        this.content = content;
        this.memberId = memberId;

    }


}
