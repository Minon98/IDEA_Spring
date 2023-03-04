package com.example.hellospring.controller;

import com.example.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

//    @Autowired (직접 주입 하면 안좋다)
    private final MemberService memberService;

//    setter로 주입해도 안좋다
//    @Autowired
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }

//    생성자 주입이 권장된다
        @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
