package com.coding.project.repository;

import com.coding.project.domain.entitiy.Notices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticesRepository extends JpaRepository<Notices, String> {
}
