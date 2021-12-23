package com.board.web.dto.member;

import com.board.service.param.MemberUpdateParam;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Builder
public class MemberUpdateRequestDto {

    private String memberPassword;
    private String memberEmail;




    public MemberUpdateRequestDto(String memberPassword, String memberEmail) {
        this.memberPassword = memberPassword;
        this.memberEmail = memberEmail;

    }


    public MemberUpdateParam toParam() {
        return MemberUpdateParam.builder()
                .memberPassword(this.memberPassword)
                .memberEmail(this.memberEmail)
                .build();
    }
}
