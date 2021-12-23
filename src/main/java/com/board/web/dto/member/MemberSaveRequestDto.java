package com.board.web.dto.member;


import com.board.domain.MemberEntity;
import com.board.service.param.MemberSaveParam;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberSaveRequestDto {


    private String id;
    private String name;
    private String password;
    private String email;


    @Builder
    public MemberSaveRequestDto(String id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public MemberEntity toEntity(String encodedPassword) {
        return MemberEntity.builder()
                .memberId(id)
                .memberName(name)
                .memberPassword(encodedPassword)
                .memberEmail(email)
                .build();


    }

    public MemberSaveParam toParam() {
        return MemberSaveParam.builder()
                .memberId(this.id)
                .memberName(this.name)
                .memberPassword(this.password)
                .memberEmail(this.email)
                .build();
    }

}
