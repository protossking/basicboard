package com.board.web.dto.member;

import com.board.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MemberResponseDto {

    private String id;
    private String name;
    private String password;
    private String email;

    public MemberResponseDto (Member entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.password = entity.getPassword();
        this.email = entity.getEmail();
    }
}
