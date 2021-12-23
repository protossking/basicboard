package com.board.service.param;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberUpdateParam {
    private String memberPassword;
    private String memberEmail;

    public MemberUpdateParam(String memberPassword, String memberEmail) {
        this.memberPassword = memberPassword;
        this.memberEmail = memberEmail;
    }
}
