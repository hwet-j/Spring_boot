package com.coding.project.repository;

import com.coding.project.domain.entitiy.NoticesTags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticesTagsRepository extends JpaRepository<NoticesTags, String> {
    NoticesTags findBynameEng(String nameEng);

}
