package com.board.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "comment")
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;


    @Column(length = 255, name = "comment_content")
    private String commentContent;



    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "board_no")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    private Member member;


    @Builder
    public Comment (String commentContent, Board board, Member member) {
        this.commentContent = commentContent;
        this.board = board;
        this.member = member;
    }

    public void update(String commentContent) {
        this.commentContent = commentContent;
    }


}
