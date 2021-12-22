package com.board.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardUpdateParam {
    private String title;
    private String content;
    private String boardAuthorId;

    public BoardUpdateParam(String title, String content, String boardAuthorId) {
        this.title = title;
        this.content = content;
        this.boardAuthorId = boardAuthorId;
    }
}