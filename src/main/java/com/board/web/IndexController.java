package com.board.web;


import com.board.domain.MemberEntity;
import com.board.service.LoginService;
import com.board.service.MemberService;
import com.board.web.dto.member.MemberResponseDto;
import com.board.web.login.LoginForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class IndexController {

    private final MemberService memberService;

    private final LoginService loginService;


    @PostMapping("/login")
    public MemberResponseDto login(@RequestBody LoginForm loginForm, HttpServletRequest request) {
        MemberEntity loginMemberEntity = loginService.login(loginForm.getLoginId(), loginForm.getLoginPassword());

        if(loginMemberEntity != null) {

            HttpSession session = request.getSession(true);
            session.setAttribute("LOGINMEMBER", loginMemberEntity);
            System.out.println("-----------------------");
            MemberEntity loginmember =(MemberEntity)session.getAttribute("LOGINMEMBER");

            System.out.println(loginmember.getMemberId());
            System.out.println(session.getAttribute("LOGINMEMBER"));
            return new MemberResponseDto(loginMemberEntity);
        }
        return null;
    }

    @PostMapping("/doLogout")
    public ResponseEntity logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session != null) {
            System.out.println("세션날림");
            session.invalidate();
        }
        if(!request.isRequestedSessionIdValid()) {
            System.out.println("세션이 무효화 상태임");
        }

        return new ResponseEntity(HttpStatus.OK);
    }



}
