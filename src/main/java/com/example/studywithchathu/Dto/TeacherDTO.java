package com.example.studywithchathu.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeacherDTO {
    private String teacherId;
    private String email;
    private Date joinDate;
    private String name;
    private String phoneNumber;
    private int courseId;

}
