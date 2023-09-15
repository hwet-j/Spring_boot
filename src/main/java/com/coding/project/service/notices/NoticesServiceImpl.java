package com.coding.project.service.notices;


import com.coding.project.domain.entitiy.notices.Notices;
import com.coding.project.dto.notices.NoticesDTO;
import com.coding.project.mapper.NoticesMapper;
import com.coding.project.repository.notices.NoticesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticesServiceImpl implements NoticesService {

    private final NoticesRepository noticesRepository;
    private final NoticesMapper noticesMapper;

    @Override
    public void createNotices(NoticesDTO noticesDTO) {

        noticesRepository.save(noticesMapper.noticesDTOToNotices(noticesDTO));
    }

    @Override
    public Page<Notices> getAllNotices(Pageable pageable) {
        return noticesRepository.findAll(pageable);
    }

    @Override
    public void deleteById(String id) {
        noticesRepository.deleteById(id);
    }

}
