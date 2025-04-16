package com.example.studywithchathu.Service;

import com.example.studywithchathu.Dto.TeacherDTO;

import java.util.List;

public interface TeacherService {
    void saveTeacher(TeacherDTO teacherDTO);

    void updateTeacher(TeacherDTO teacherDTO);

    void deleteTeacher(int id);

    List<TeacherDTO> getAllTeachers();

    List<String> getAllTeacherNames();

    Integer getTeacherIdByName(String name);
}
