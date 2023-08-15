package com.coding.project.domain.entitiy;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "notice")
@Getter
public class Notices {
    @Id @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(length = 255)
    private String title;
    @Column()
    private String content;
    private String image_path;
    private String author;
    private String category;
    private String status;
    private String tags;
    private LocalDateTime created_at;  // "created_at"에 해당하는 필드 (시간 포함)
    private LocalDateTime updated_at;  // "updated_at"에 해당하는 필드 (시간 포함)
    private LocalDate end_date;  // "end_date"에 해당하는 필드 (시간 제외)

}
