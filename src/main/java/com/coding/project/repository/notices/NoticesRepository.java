package com.coding.project.repository.notices;

import com.coding.project.domain.entitiy.notices.Notices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticesRepository extends JpaRepository<Notices, String> {
}
