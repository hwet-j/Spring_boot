package com.coding.project.controller.auth;

import com.coding.project.dto.auth.KakaoDTO;
import com.coding.project.dto.auth.MemberDTO;
import com.coding.project.global.MsgEntity;
import com.coding.project.service.auth.AuthService;
import com.coding.project.service.auth.KakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("kakao")
public class KakaoController {

    private final KakaoService kakaoService;
    private final AuthService authService;

    /*@GetMapping("/callback")
    public ResponseEntity<MsgEntity> callback(HttpServletRequest request, ModelAndView mv, MemberDTO memberDTO) throws Exception {
        KakaoDTO kakaoInfo = kakaoService.getKakaoInfo(request.getParameter("code"));
        *//* 카카오 API로 부터 전달 받은 객체에서 Email값으로 DB를 조회 *//*
        if (authService.findByEmail(kakaoInfo.getEmail()) != null){ //
            mv.setViewName("/");
        } else {
            mv.setViewName("join");
        }


        return ResponseEntity.ok()
                .body(new MsgEntity("Success", kakaoInfo));
    }*/


    @GetMapping("/callback")
    public ModelAndView callback(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, MemberDTO memberDTO) throws Exception {
        KakaoDTO kakaoInfo = kakaoService.getKakaoInfo(request.getParameter("code"));
        /* 카카오 API로 부터 전달 받은 객체에서 Email값으로 DB를 조회 */
        if (authService.findByEmail(kakaoInfo.getEmail()) != null){ //
            mv.setViewName("redirect:/");
        } else {
            // DB에 정보가 없으면 회원가입 진행 (로그아웃 진행 후) --> 회원가입 완료되면 재 로그인
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth != null) {
                new SecurityContextLogoutHandler().logout(request, response, auth);
            }
            mv.addObject("kakaoEmail", kakaoInfo.getEmail());
            mv.addObject("kakaoNickname", kakaoInfo.getNickname());
            mv.setViewName("join");
        }

        return mv;


    }


}