package com.coding.project.service.notices;

import com.coding.project.domain.entitiy.notices.NoticesTags;
import com.coding.project.dto.notices.NoticesTagsDTO;

import java.util.List;

public interface NoticesTagsService {
    void saveTags(NoticesTagsDTO noticesTagsDTO);
    List<NoticesTags> getAllTags();
    NoticesTags findByEnglishName(String nameEng);
    void updateTag(String originalName, String newNameEng, String newNameKor);
    void deleteTagByNameEng(String nameEng);
}





