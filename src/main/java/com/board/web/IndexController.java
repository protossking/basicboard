package com.board.web;


import com.board.domain.Member;
import com.board.service.LoginService;
import com.board.service.MemberService;
import com.board.web.dto.member.MemberResponseDto;
import com.board.web.login.LoginForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
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
        Member loginMember = loginService.login(loginForm.getLoginId(), loginForm.getLoginPassword());

        if(loginMember != null) {

            HttpSession session = request.getSession(true);
            session.setAttribute("LOGINMEMBER", loginMember);
            System.out.println("-----------------------");
            Member loginmember =(Member)session.getAttribute("LOGINMEMBER");

            System.out.println(loginmember.getMemberId());
            System.out.println(session.getAttribute("LOGINMEMBER"));
            return new MemberResponseDto(loginMember);
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
