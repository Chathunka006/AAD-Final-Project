package com.example.studywithchathu.Service;

import com.example.studywithchathu.Dto.TeacherDTO;
import java.util.List;

public interface TeacherService {
    void saveTeacher(TeacherDTO teacherDTO);
    List<String> getAllTeacherNames();
    Integer getTeacherIdByName(String name);
    List<TeacherDTO> getAllTeachers();
    void updateTeacher(TeacherDTO teacherDTO);
    void deleteTeacher(int id);
}
