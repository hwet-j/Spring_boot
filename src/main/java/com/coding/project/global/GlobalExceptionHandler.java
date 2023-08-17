package com.coding.project.global;


import com.coding.project.global.exception.TagNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TagNotFoundException.class)
    public String handleCustomException(TagNotFoundException ex, Model model) {
        // 에러 발생 시 처리 로직을 작성
        model.addAttribute("errorMessage", ex.getMessage());
        return "errorPage"; // 에러 페이지 뷰 이름
    }

}
