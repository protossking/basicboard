package com.board.service;


import com.board.domain.Member;
import com.board.domain.MemberRepository;
import com.board.web.dto.member.MemberListResponseDto;
import com.board.web.dto.member.MemberResponseDto;
import com.board.web.dto.member.MemberSaveRequestDto;
import com.board.web.dto.member.MemberUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {


    private final MemberRepository repository;

    private final PasswordEncoder passwordEncoder;


    @Transactional
    public Long save (MemberSaveRequestDto requestDto) {
        String encodedPassword = passwordEncoder.encode(requestDto.getPassword());
//        log.info("{encodedPassword}",encodedPassword);
//        log.info("{encodedPassword}",encodedPassword.length());
        System.out.println("encodedPassword" + encodedPassword);

        return repository.save(requestDto.toEntity(encodedPassword)).getMemberNo();
    }


    @Transactional
    public Long update(Long no, MemberUpdateRequestDto dto) {
        Member member = repository.findById(no).orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다 " + no));
        member.update(dto.getPassword(), dto.getEmail());

        return no;
    }


    public MemberResponseDto findByNo(Long no) {
        Member member = repository.findById(no).orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다 " + no));
        return new MemberResponseDto(member);
    }



    @Transactional(readOnly = true)
    public List<MemberListResponseDto> findAll() {
        return repository.findAll().stream().map(MemberListResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long no) {
        Member member = repository.findById(no).orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다 " + no));
        repository.delete(member);

    }
}
