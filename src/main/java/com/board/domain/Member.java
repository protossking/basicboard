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
    private Long no;

    @Column(length = 20, nullable = false)
    private String id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String password;

    @Column(length = 30, nullable = true)
    private String email;

    @Builder
    public Member(String id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    @OneToMany(mappedBy = "member")
    private List<Board> boardList = new ArrayList<>();


    public void update(String password, String email) {
        this.password = password;
        this.email = email;
    }

}
