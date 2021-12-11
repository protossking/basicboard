package com.board.web.dto.member;

import com.board.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberListResponseDto {

    private String id;
    private String name;
    private String password;
    private String email;

    public MemberListResponseDto(Member entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.password = entity.getPassword();
        this.email = entity.getEmail();
    }
}
