package com.coding.project.repository.notices;

import com.coding.project.domain.entitiy.notices.NoticesTags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticesTagsRepository extends JpaRepository<NoticesTags, String> {
    NoticesTags findBynameEng(String nameEng);
}
