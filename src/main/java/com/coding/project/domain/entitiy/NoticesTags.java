package com.coding.project.domain.entitiy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "notices_tags")
@Getter
@Setter
public class NoticesTags {
    @Id
    private String nameEng;

    private String nameKor;
}