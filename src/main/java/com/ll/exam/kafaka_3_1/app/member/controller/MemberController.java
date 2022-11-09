package com.ll.exam.kafaka_3_1.app.member.controller;

import com.ll.exam.kafaka_3_1.app.email.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final EmailService emailService;

    @PostMapping("/join")
    @ResponseBody
    public String join(String email) {
        emailService.send(email, "회원가입을 축하합니다.");

        return "회원가입이 완료되었습니다.";
    }
}
