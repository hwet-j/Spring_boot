package com.coding.project.controller.auth;

import com.coding.project.service.auth.KakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RequiredArgsConstructor
@Controller
public class AuthController {
    private final KakaoService kakaoService;

    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("kakaoUrl", kakaoService.getKakaoLogin());

        return "socialLogin";
    }
}
