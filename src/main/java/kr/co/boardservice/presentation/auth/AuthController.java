package kr.co.boardservice.presentation.auth;

import kr.co.boardservice.application.member.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final MemberService memberService;

    public AuthController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/signup")
    public String signupForm() {
        return "auth/signup";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam String username,
                         @RequestParam String password) {
        memberService.register(username, password);
        return "redirect:/auth/login";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "auth/login"; // Security가 이 페이지를 로그인 페이지로 사용
    }
}
