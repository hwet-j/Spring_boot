package com.coding.project.service.auth;


import com.coding.project.domain.entitiy.auth.Member;
import com.coding.project.dto.auth.MemberDTO;

import java.util.Optional;

public interface AuthService {

    Member findByEmail(String email);

    void saveMember(MemberDTO memberDTO);
}
