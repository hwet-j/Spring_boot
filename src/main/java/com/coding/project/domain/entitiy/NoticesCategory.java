package com.coding.project.domain.entitiy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "notices_categories")
@Getter
@Setter
public class NoticesCategory {
    @Id
    @Column(length = 50)
    private String name;
}