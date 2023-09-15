package com.coding.project.service.auth;

import com.coding.project.domain.entitiy.auth.Member;
import com.coding.project.dto.auth.MemberDTO;
import com.coding.project.mapper.MemberMapper;
import com.coding.project.repository.notices.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Override
    public Member findByEmail(String email) {
        Optional<Member> optionalMember = memberRepository.findByEmail(email);
        if (optionalMember.isPresent()){
            return optionalMember.get();
        } else {
            return null;
        }

    }


    public void saveMember(MemberDTO memberDTO){
        memberRepository.save(memberMapper.memberDTOToMember(memberDTO));
    }
}
