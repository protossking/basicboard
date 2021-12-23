package com.board.service.param;

import com.board.domain.MemberEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberSaveParam {

    private String memberId;
    private String memberName;
    private String memberPassword;
    private String memberEmail;

    @Builder
    public MemberSaveParam(String memberId, String memberName, String memberPassword, String memberEmail) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberPassword = memberPassword;
        this.memberEmail = memberEmail;
    }

    public MemberEntity toEntity(String encodedPassword) {
        return MemberEntity.builder()
                .memberId(this.memberId)
                .memberName(this.memberName)
                .memberPassword(encodedPassword)
                .memberEmail(this.memberEmail)
                .build();
    }

}
