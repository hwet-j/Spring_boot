package com.coding.project.controller;


import com.coding.project.domain.entitiy.Notices;
import com.coding.project.dto.NoticesDTO;
import com.coding.project.dto.NoticesTagsDTO;
import com.coding.project.service.NoticesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RequestMapping("/notices")
@Controller
public class NoticesController {

    private final NoticesService noticesService;

    @Autowired
    public NoticesController(NoticesService noticesService) {
        this.noticesService = noticesService;
    }

    @PostMapping("/insert")
    public String saveNotices(@ModelAttribute NoticesDTO noticesDTO) {
        return "redirect:/m";
    }

    @GetMapping("/form")
    public String tagForm(Model model) {
        return "tags/tagForm";
    }

    // 리스트
    @GetMapping("/list")
    public String getAllNotices(Model model) {
        List<Notices> notices = noticesService.getAllNotices();
        model.addAttribute("notices", notices);
        return "notices/noticesList";
    }

    // 수정 폼으로 이동
    @GetMapping("/update")
    public String showUpdateForm(@RequestParam("name") String nameEng, Model model) {
        return "tags/tagUpdate";
    }

    // 수정 처리
    @PostMapping("/update")
    public String updateTag(@RequestParam String originalEngName,
                            @RequestParam String originalKorName,
                            @ModelAttribute NoticesTagsDTO tagDTO) {

        return "redirect:/tags/list"; // 수정 후 목록 페이지로 리다이렉트
    }
    
    // 삭제 처리
    @GetMapping("/delete")
    public String deleteTag(@RequestParam String name) {
        return "redirect:/tags/list";
    }


}
