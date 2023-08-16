package com.coding.project.service;


import com.coding.project.domain.entitiy.NoticesTags;
import com.coding.project.dto.NoticesTagsDTO;
import com.coding.project.repository.NoticesTagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticesTagsService {

    private final NoticesTagsRepository noticesTagsRepository;

    @Autowired
    public NoticesTagsService(NoticesTagsRepository noticesTagsRepository) {
        this.noticesTagsRepository = noticesTagsRepository;
    }

    public void saveTags(NoticesTagsDTO noticesTagsDTO) {
        NoticesTags tag = new NoticesTags();
        tag.setNameEng(noticesTagsDTO.getNameEng());
        tag.setNameKor(noticesTagsDTO.getNameKor());

        noticesTagsRepository.save(tag);
    }

    public List<NoticesTags> getAllTags() {
        return noticesTagsRepository.findAll();
    }

    public NoticesTags findByEnglishName(String nameEng) {
        return noticesTagsRepository.findBynameEng(nameEng);
    }

    public void updateTag(String originalName, String newNameEng, String newNameKor) {
        NoticesTags tag = noticesTagsRepository.findBynameEng(originalName);
        if (tag != null) {
            tag.setNameEng(newNameEng);
            tag.setNameKor(newNameKor);
            noticesTagsRepository.save(tag);
        }
    }

    public void deleteTagByNameEng(String nameEng) {
        noticesTagsRepository.deleteById(nameEng);
    }

}
