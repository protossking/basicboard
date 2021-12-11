package com.board.web.dto.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberUpdateRequestDto {

    private String password;
    private String email;

    @Builder
    public MemberUpdateRequestDto(String password, String email) {
        this.password = password;
        this.email = email;
    }
}
