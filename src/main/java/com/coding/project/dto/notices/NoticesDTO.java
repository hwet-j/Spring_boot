package com.coding.project.dto.notices;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NoticesDTO {
    private Integer id;
    private String title;
    private String content;
    private String imagePath;
    private String author;
    private Integer category;
    private String status;
    private String tags;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDate endDate;
    private boolean visible;
    private NoticesCategoryDTO noticesCategory;
}