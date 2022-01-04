package com.board.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    MemberEntity findByMemberId(String memberId);

    //save findById findAll(),


}
