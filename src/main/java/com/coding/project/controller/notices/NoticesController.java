package com.coding.project.controller.notices;


import com.coding.project.domain.entitiy.notices.Notices;
import com.coding.project.dto.notices.NoticesDTO;
import com.coding.project.dto.notices.NoticesTagsDTO;
import com.coding.project.service.notices.NoticesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RequestMapping("/notices")
@Controller
@RequiredArgsConstructor
public class NoticesController {

    private final NoticesService noticesService;

    @PostMapping("/insert")
    public String saveNotices(@ModelAttribute NoticesDTO noticesDTO) {
        return "redirect:/m";
    }

    @GetMapping("/form")
    public String tagForm(Model model) {
        return "tags/tagForm";
    }


    @GetMapping("/list")
    public String getAllNotices(Model model,
                                @RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Notices> noticesPage = noticesService.getAllNotices(pageable);
        System.out.println(noticesPage.getSize());

        model.addAttribute("notices", noticesPage);
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
