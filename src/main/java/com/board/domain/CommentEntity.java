package com.board.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "comment")
public class CommentEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;


    @Column(length = 255, name = "comment_content")
    private String commentContent;



    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "board_no")
    private BoardEntity board;

    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    private MemberEntity memberEntity;


    @Builder
    public CommentEntity(String commentContent, BoardEntity board, MemberEntity memberEntity) {
        this.commentContent = commentContent;
        this.board = board;
        this.memberEntity = memberEntity;
    }

    public void update(String commentContent) {
        this.commentContent = commentContent;
    }


}
