package com.example.studywithchathu.Service;

import com.example.studywithchathu.Dto.StudentCourseDTO;

import java.util.List;
import java.util.UUID;

public interface StudentCourseService {

    void addStudentCourse(StudentCourseDTO studentCourseDTO);
    List<StudentCourseDTO> getAllStudentCoursesByStudentId(UUID studentId);
}
