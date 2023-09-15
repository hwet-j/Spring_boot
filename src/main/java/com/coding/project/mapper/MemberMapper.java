package com.coding.project.mapper;

import com.coding.project.domain.entitiy.auth.Member;
import com.coding.project.domain.entitiy.notices.Notices;
import com.coding.project.domain.entitiy.notices.NoticesCategory;
import com.coding.project.dto.auth.MemberDTO;
import com.coding.project.dto.notices.NoticesCategoryDTO;
import com.coding.project.dto.notices.NoticesDTO;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    /* 가입 시 사용되는 정보로 불필요한 id, joindate필드는 제외 */
    public MemberDTO memberToMemberDTO(Member member) {
        if (member == null) {
            return null;
        }

        return MemberDTO.builder()
                .name(member.getName())
                .nickname(member.getNickname())
                .password(member.getPassword())
                .email(member.getEmail())
                .birthDate(member.getBirthDate())
                .gender(member.getGender())
                .allowEmail(member.isAllowEmail())
                .build();
    }


    /* 마이페이지에 뿌려줄 정보로 다른 DTO를 생성해서 다시 맵핑하는게 좋아보임 */
    public Member memberDTOToMember(MemberDTO memberDTO) {
        if (memberDTO == null) {
            return null;
        }

        return Member.builder()
                .name(memberDTO.getName())
                .nickname(memberDTO.getNickname())
                .password(memberDTO.getPassword())
                .email(memberDTO.getEmail())
                .birthDate(memberDTO.getBirthDate())
                .gender(memberDTO.getGender())
                .allowEmail(memberDTO.isAllowEmail())
                .build();
    }

}
