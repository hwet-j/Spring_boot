package com.coding.project.dto.notices;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
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