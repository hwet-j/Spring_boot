package com.coding.project.service.notices;

import com.coding.project.dto.notices.NoticesDTO;
import com.coding.project.domain.entitiy.notices.Notices;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoticesService {
    void createNotices(NoticesDTO noticesDTO);
    Page<Notices> getAllNotices(Pageable pageable);
    void deleteById(String id);
}