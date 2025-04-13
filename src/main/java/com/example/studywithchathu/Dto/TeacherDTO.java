package com.example.studywithchathu.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeacherDTO {
    private String teacherId;
    private String name;
    private String email;
    private String phoneNumber;
    private String joinDate;
    private int courseId;

}
