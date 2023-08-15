package com.coding.project.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @RequestMapping("/index")
    @ResponseBody       // HTML의 Body요소에 입력 (리턴값을 그대로 표시해줌 - 문자열화 해서 응답함)
    public String index(){
        return "Body에 출력?되고있습니다 자동으로ㅇㅇasdf";
    }

}
