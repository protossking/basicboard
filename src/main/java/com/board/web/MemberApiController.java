package com.board.web;

import com.board.service.MemberService;
import com.board.web.dto.member.MemberListResponseDto;
import com.board.web.dto.member.MemberResponseDto;
import com.board.web.dto.member.MemberSaveRequestDto;
import com.board.web.dto.member.MemberUpdateRequestDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Member Controller API V1")
@RequiredArgsConstructor
@RestController
public class MemberApiController {

    private final MemberService service;


    @GetMapping("api/v1/members")
    @ApiOperation(value = "회원 목록", notes = "회원 전체 목록으로 보여준다")
    public List<MemberListResponseDto> findAll() {
        List<MemberListResponseDto> all = service.findAll();
        return all;
    }

    @GetMapping("/api/v1/member/{no}")
    @ApiOperation(value = "회원 조회", notes = "회원 한명을 보여준다 ")
    public MemberResponseDto findById(@PathVariable Long no) {
        return service.findByNo(no);
    }

    @PutMapping("api/v1/member/{no}")
    @ApiOperation(value = "회원 수정", notes = "회원 한명의 정보를 수정한다 ")
    public Long update(@PathVariable Long no, @RequestBody MemberUpdateRequestDto dto) {
        return service.update(no, dto);

    }

    @DeleteMapping("/api/v1/member/{no}")
    @ApiOperation(value = "회원 삭제", notes = "해당 회원을 삭제한다")
    public Long delete(@PathVariable Long no) {
        service.delete(no);
        return no;
    }

    @PostMapping("/api/v1/member")
    @ApiOperation(value = "회원 등록", notes = "회원을 등록한다")
    public Long save(@RequestBody MemberSaveRequestDto dto) {
        return service.save(dto);
    }
}
