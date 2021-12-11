package com.board.web;

import com.board.service.MemberService;
import com.board.web.dto.member.MemberListResponseDto;
import com.board.web.dto.member.MemberResponseDto;
import com.board.web.dto.member.MemberSaveRequestDto;
import com.board.web.dto.member.MemberUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService service;


    @GetMapping("api/v1/members")
    public List<MemberListResponseDto> findAll() {
        List<MemberListResponseDto> all = service.findAll();
        return all;
    }

    @GetMapping("/api/v1/member/{no}")
    public MemberResponseDto findById(@PathVariable Long no) {
        return service.findByNo(no);
    }

    @PutMapping("api/v1/member/{no}")
    public Long update(@PathVariable Long no, @RequestBody MemberUpdateRequestDto dto) {
        return service.update(no, dto);

    }

    @DeleteMapping("/api/v1/member/{no}")
    public Long delete(@PathVariable Long no) {
        service.delete(no);
        return no;
    }

    @PostMapping("/api/v1/member")
    public Long save(@RequestBody MemberSaveRequestDto dto) {
        return service.save(dto);
    }



}
