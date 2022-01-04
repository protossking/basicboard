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


    @PostMapping("/api/v1/member")
    @ApiOperation(value = "회원 등록", notes = "회원을 등록한다")
    public Long save(@RequestBody MemberSaveRequestDto request) {
        return service.save(request.toParam());
    }

    @GetMapping("/api/v1/member/{no}")
    @ApiOperation(value = "회원 조회", notes = "회원 한명을 조회한다. ")
    public MemberResponseDto findMember(@PathVariable Long no){
        if(service.findByNo(no).equals(null)) {
            throw new IllegalArgumentException("해당 번호의 회원이 없습니다");
        }
        return service.findByNo(no);
    }

    @PutMapping("api/v1/member/{no}")
    @ApiOperation(value = "회원 수정", notes = "회원 한명의 정보를 수정한다 ")
    public void update(@PathVariable Long no,
                       @RequestBody MemberUpdateRequestDto request) {
        if(service.findByNo(no).equals(null)) {
            throw new IllegalArgumentException("해당 번호의 회원이 없습니다");
        }
        service.update(no, request.toParam());
    }
    @GetMapping("api/v1/members")
    @ApiOperation(value = "회원 목록", notes = "회원 전체 목록으로 보여준다")
    public List<MemberListResponseDto> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/api/v1/member/{no}")
    @ApiOperation(value = "회원 삭제", notes = "해당 회원을 삭제한다")
    public Long delete(@PathVariable Long no) {
        if(service.findByNo(no).equals(null)) {
            throw new IllegalArgumentException("해당 번호의 회원이 없습니다");
        }
        service.delete(no);
        return no;
    }





}
