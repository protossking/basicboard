package com.board.service;


import com.board.domain.MemberEntity;
import com.board.domain.MemberRepository;
import com.board.service.param.MemberUpdateParam;
import com.board.service.param.MemberSaveParam;
import com.board.web.dto.member.MemberListResponseDto;
import com.board.web.dto.member.MemberResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long save (MemberSaveParam param) {
        String encodedPassword = passwordEncoder.encode(param.getMemberPassword());
        return memberRepository.save(param.toEntity(encodedPassword)).getMemberNo();

    }
    public MemberResponseDto findByNo(Long no) {
        Optional<MemberEntity> memberEntity = memberRepository.findById(no);
        return new MemberResponseDto(memberEntity.get());
    }

    @Transactional
    public void update(Long no,
                       MemberUpdateParam param) {

        Optional<MemberEntity> memberEntity = memberRepository.findById(no);
        String encodedPassword = passwordEncoder.encode(param.getMemberPassword());
        memberEntity.get().update(encodedPassword, param.getMemberEmail());
    }
    @Transactional(readOnly = true)
    public List<MemberListResponseDto> findAll() {
        return memberRepository.findAll().stream().map(MemberListResponseDto::new).collect(Collectors.toList());
    }
    @Transactional
    public void delete(Long no) {
        Optional<MemberEntity> memberEntity = memberRepository.findById(no);
        memberRepository.delete(memberEntity.get());
    }
}
