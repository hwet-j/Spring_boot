package com.coding.project.mapper;

import com.coding.project.domain.entitiy.notices.Notices;
import com.coding.project.domain.entitiy.notices.NoticesCategory;
import com.coding.project.dto.notices.NoticesCategoryDTO;
import com.coding.project.dto.notices.NoticesDTO;
import org.springframework.stereotype.Component;

@Component
public class NoticesMapper {

    public NoticesDTO noticesToNoticesDTO(Notices notices) {
        if (notices == null) {
            return null;
        }

        return NoticesDTO.builder()
                .id(notices.getId())
                .title(notices.getTitle())
                .content(notices.getContent())
                .imagePath(notices.getImagePath())
                .author(notices.getAuthor())
                .createdAt(notices.getCreatedAt())
                .updatedAt(notices.getUpdatedAt())
                .category(notices.getCategory())
                .status(notices.getStatus())
                .tags(notices.getTags())
                .endDate(notices.getEndDate())
                .visible(notices.isVisible())
                .noticesCategory(NoticesCategoryDTO.builder()
                        .id(notices.getNoticesCategory().getId())
                        .name(notices.getNoticesCategory().getName())
                        .build())
                .build();

    }

    public Notices noticesDTOToNotices(NoticesDTO noticesDTO) {
        if (noticesDTO == null) {
            return null;
        }

        return Notices.builder()
                .id(noticesDTO.getId())
                .title(noticesDTO.getTitle())
                .content(noticesDTO.getContent())
                .imagePath(noticesDTO.getImagePath())
                .author(noticesDTO.getAuthor())
                .createdAt(noticesDTO.getCreatedAt())
                .updatedAt(noticesDTO.getUpdatedAt())
                .category(noticesDTO.getCategory())
                .status(noticesDTO.getStatus())
                .tags(noticesDTO.getTags())
                .endDate(noticesDTO.getEndDate())
                .visible(noticesDTO.isVisible())
                .noticesCategory(NoticesCategory.builder()
                        .id(noticesDTO.getNoticesCategory().getId())
                        .name(noticesDTO.getNoticesCategory().getName())
                        .build())
                .build();
    }
}
