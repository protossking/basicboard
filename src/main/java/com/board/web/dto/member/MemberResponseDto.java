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
        this.id = entity.getMemberId();
        this.name = entity.getMemberName();
        this.password = entity.getMemberPassword();
        this.email = entity.getMemberEmail();
    }
}
