package com.coding.project.controller.auth;

import com.coding.project.dto.auth.MemberDTO;
import com.coding.project.service.auth.AuthService;
import com.coding.project.service.auth.KakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.LocalDate;


@RequiredArgsConstructor
@Controller
public class AuthController {
    private final KakaoService kakaoService;
    private final AuthService authService;

    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("kakaoUrl", kakaoService.getKakaoLogin());

        return "socialLogin";
    }

    @RequestMapping(value="/join", method= RequestMethod.GET)
    public String joinForm(Model model, MemberDTO memberDTO) {

        return "join";
    }

    @RequestMapping(value="/join", method= RequestMethod.POST)
    public String join(@Valid MemberDTO memberDTO,
                       BindingResult bindingResult,
                       Model model) {

        model.addAttribute("kakaoEmail",memberDTO.getEmail());

        if(bindingResult.hasErrors()){
            return "join";
        }

        authService.saveMember(memberDTO);

        return "redirect:/";
    }
}
