package com.example.studywithchathu.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentCourseDTO {
    private Long id;
    private int courseId;
    private UUID userId;
    private String title;
    private String category;
    private int price;
    private String language;
    private Date startDate;
}
