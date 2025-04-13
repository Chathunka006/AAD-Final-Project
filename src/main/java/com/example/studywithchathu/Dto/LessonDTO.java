package com.example.studywithchathu.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LessonDTO {
    private int lessonId;
    private String title;
    private Date update_at;
    private int courseId;
}
