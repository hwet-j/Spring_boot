package com.coding.project.dto.notices;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class NoticesTagsDTO {
    private Integer id;
    private String nameEng;
    private String nameKor;
}