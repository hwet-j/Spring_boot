package com.coding.project.service.notices;


import com.coding.project.domain.entitiy.notices.Notices;
import com.coding.project.dto.notices.NoticesDTO;
import com.coding.project.repository.notices.NoticesRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticesServiceImpl implements NoticesService {

    private final NoticesRepository noticesRepository;

    @Override
    public void createNotices(NoticesDTO noticesDTO) {
        ModelMapper modelMapper = new ModelMapper();    // 라이브러리를 추가해줘야함 / implementation 'org.modelmapper:modelmapper:2.4.4' 의존성 주입
        // --> Entity 클래스에 DTO의 정보를 ModelMapper를 통해서 편리하게 적용
        Notices notices = modelMapper.map(noticesDTO, Notices.class);

        noticesRepository.save(notices);
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
