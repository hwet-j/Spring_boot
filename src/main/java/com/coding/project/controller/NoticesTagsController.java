package com.coding.project.controller;


import com.coding.project.domain.entitiy.NoticesTags;
import com.coding.project.dto.NoticesTagsDTO;
import com.coding.project.global.exception.TagNotFoundException;
import com.coding.project.service.NoticesTagsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RequestMapping("/tags")
@Controller
public class NoticesTagsController {

    private final NoticesTagsService noticesTagsService;

    @Autowired
    public NoticesTagsController(NoticesTagsService noticesTagsService) {
        this.noticesTagsService = noticesTagsService;
    }

    @PostMapping("/insert")
    public String saveTags(@ModelAttribute NoticesTagsDTO noticesTagsDTO) {
        System.out.println("Name (English): " + noticesTagsDTO.getNameEng());
        System.out.println("Name (Korean): " + noticesTagsDTO.getNameKor());
        noticesTagsService.saveTags(noticesTagsDTO);
        return "redirect:/tags/form";
    }

    // 입력 폼 (Insert)
    @GetMapping("/form")
    public String tagForm(Model model) {
        model.addAttribute("noticesTagsDTO", new NoticesTagsDTO());
        System.out.println("폼 실행");
        return "tags/tagForm";
    }

    // 리스트
    @GetMapping("/list")
    public String getAllTags(Model model) {
        List<NoticesTags> tags = noticesTagsService.getAllTags();
        // log.info("tags={}", tags);
        model.addAttribute("tags", tags);
        return "notices/tags/tagList";
    }

    // 수정 폼으로 이동
    @GetMapping("/update")
    public String showUpdateForm(@RequestParam("name") String nameEng, Model model) {
        NoticesTags tag = noticesTagsService.findByEnglishName(nameEng);
        if (tag == null) {
            // 예시일 뿐, 좀 더 보완해서 제대로 작동하도록 해야함
            throw new TagNotFoundException("태그를 찾지 못했습니다.");
        }
        model.addAttribute("tag", tag);
        return "notices/tags/tagUpdate";
    }

    // 수정 처리
    @PostMapping("/update")
    public String updateTag(@RequestParam String originalEngName,
                            @RequestParam String originalKorName,
                            @ModelAttribute NoticesTagsDTO tagDTO) {

        noticesTagsService.updateTag(originalEngName, tagDTO.getNameEng(), tagDTO.getNameKor());
        return "redirect:/tags/list"; // 수정 후 목록 페이지로 리다이렉트
    }
    
    // 삭제 처리
    @GetMapping("/delete")
    public String deleteTag(@RequestParam String name) {
        noticesTagsService.deleteTagByNameEng(name);
        return "redirect:/tags/list";
    }


}
