package com.board.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Table(name="member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    private Long memberNo;

    @Column(length = 20, nullable = false, name = "member_id")
    private String memberId;

    @Column(length = 20, nullable = false, name = "member_name")
    private String memberName;

    @Column(length = 20, nullable = false, name = "member_password")
    private String memberPassword;

    @Column(length = 30, nullable = true, name = "member_email")
    private String memberEmail;

    @Builder
    public Member(String memberId, String memberName, String memberPassword, String memberEmail) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberPassword = memberPassword;
        this.memberEmail = memberEmail;
    }

//    @OneToMany(mappedBy = "member")
//    private List<Board> boardList = new ArrayList<>();


    public void update(String password, String email) {
        this.memberPassword = password;
        this.memberEmail = email;
    }

}
