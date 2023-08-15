package com.coding.project.domain.entitiy;

import javax.persistence.*;

@Entity
@Table(name = "notices_categories")
public class NoticesCategory {
    @Id
    @Column(length = 50)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}