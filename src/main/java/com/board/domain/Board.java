package com.board.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Table(name="board")
public class Board extends BaseTimeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long boardId;


    @Column(length = 250, nullable = false, name = "board_title")
    private String boardTitle;

    @Column(columnDefinition = "TEXT", nullable = false, name = "board_content")
    private String boardContent;

    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    private Member member;


    @ColumnDefault("0")
    @Column(name = "board_count")
    private int boardCount;

    @JsonIgnore
    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    private List<Comment> list = new ArrayList<Comment>();

//    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
//    List<Comment> commentList = new ArrayList<>();


    @Builder
    public Board(String boardTitle, String boardContent, Member member) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.member = member;
    }

    public void update(String title, String content) {
        this.boardTitle = title;
        this.boardContent = content;
    }



}
