package com.coding.project.domain.entitiy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notices")
@Getter
@Setter
public class Notices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")        // 컬럼명이 필드명과 동일하면 지정하지 않아도 됨
    private Integer id;

    @Column(length = 255, nullable = false)     // 길이 설정과 NOT NULL조건
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")    // 데이터 타입 명시
    private String content;

    private String imagePath;

    @Column(length = 100)
    private String author;

    @Column(length = 50)
    private Integer category;

    @Column(length = 20)
    private String status;

    @Column(columnDefinition = "JSON")
    private String tags;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)      // 다대일 관계
    @JoinColumn(name = "category", referencedColumnName = "id", insertable = false, updatable = false)
    private NoticesCategory noticesCategory;
}