package com.coding.project.service.auth;


import com.coding.project.domain.entitiy.auth.Member;
import com.coding.project.domain.enums.UserRole;
import com.coding.project.repository.notices.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService {

    private final MemberRepository memberRepository;

    //사용자이름으로 (비밀번호)조회
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Member> optionalMember = memberRepository.findByEmail(email);

        if(!optionalMember.isPresent()){
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }
        Member user = optionalMember.get();
        List<GrantedAuthority> authorities = new ArrayList<>();

        //nickname "admin"을 포함하면 관리자
        if (user.getNickname().contains("admin")) {
            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
        }

        return new User(email, user.getPassword(), authorities);
    }



}