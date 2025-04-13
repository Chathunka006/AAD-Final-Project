package com.example.studywithchathu.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDTO {
    private int courseId;
    private String title;
    private String category;
    private int price;
    private String language;
    private Date startDate;
}
