package com.coding.project.service;


import com.coding.project.domain.entitiy.Notices;
import com.coding.project.dto.NoticesDTO;
import com.coding.project.repository.NoticesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticesService {

    private final NoticesRepository noticesRepository;

    @Autowired
    public NoticesService(NoticesRepository noticesRepository) {
        this.noticesRepository = noticesRepository;
    }

    public void createNotices(NoticesDTO noticesDTO) {
        ModelMapper modelMapper = new ModelMapper();    // 라이브러리를 추가해줘야함 / implementation 'org.modelmapper:modelmapper:2.4.4' 의존성 주입
        Notices notices = modelMapper.map(noticesDTO, Notices.class);
        noticesRepository.save(notices);

        noticesRepository.save(notices);
    }

    public List<Notices> getAllNotices() {
        return noticesRepository.findAll();
    }


    public void deleteById(String id) {
        noticesRepository.deleteById(id);
    }

}
