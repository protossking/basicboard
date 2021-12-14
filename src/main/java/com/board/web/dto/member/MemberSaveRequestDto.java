package com.board.web.dto.member;


import com.board.domain.Member;
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

    public Member toEntity() {
        return Member.builder()
                .memberId(id)
                .memberName(name)
                .memberPassword(password)
                .memberEmail(email)
                .build();


    }
}
