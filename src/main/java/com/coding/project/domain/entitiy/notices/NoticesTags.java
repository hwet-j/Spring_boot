package com.coding.project.domain.entitiy.notices;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notices_tags")
@Getter
@Setter
@Builder
public class NoticesTags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nameEng;

    private String nameKor;
}