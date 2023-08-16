package com.coding.project.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class MainController {
    @RequestMapping("/index")
    @ResponseBody       // HTML의 Body요소에 입력 (리턴값을 그대로 표시해줌 - 문자열화 해서 응답함)
    public String index_test(){
        return "Body에 출력?되고ㄴㅁ있습니다 자동으로ㅇㅇasdㅁㄴㅇㄴㅇㅁㄹf";
    }


    @GetMapping("/gugudan")
    @ResponseBody       // HTML의 Body요소에 입력 (리턴값을 그대로 표시해줌 - 문자열화 해서 응답함)
    public String showGugudan(Integer dan, Integer limit){
        // IntStream.rangeClosed(1,limit) // for문 1부터 limit까지 반복
        // .mapToObj(i -> "%d * %d = %d".formatted(dan, i, dan * i))    // 반복할 내용
        // .collect(Collectors.joining("<br>")) // 반복되는 문장 사이에 입력될 내용

        return IntStream.rangeClosed(1,limit)
                .mapToObj(i -> "%d * %d = %d".formatted(dan, i, dan * i))
                .collect(Collectors.joining("<br>"));
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }

}
