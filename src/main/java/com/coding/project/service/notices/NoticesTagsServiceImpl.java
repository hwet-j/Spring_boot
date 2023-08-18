package com.coding.project.service.notices;


import com.coding.project.domain.entitiy.notices.NoticesTags;
import com.coding.project.dto.notices.NoticesTagsDTO;
import com.coding.project.repository.notices.NoticesTagsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticesTagsServiceImpl implements NoticesTagsService {

    private final NoticesTagsRepository noticesTagsRepository;

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
