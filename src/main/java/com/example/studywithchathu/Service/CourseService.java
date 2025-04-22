package com.example.studywithchathu.Service;

import com.example.studywithchathu.Dto.CourseDTO;
import jakarta.transaction.Transactional;

import java.util.List;

public interface CourseService {

    @Transactional
    void saveCourse(CourseDTO courseDTO);

    List<String> getAllCourseNames();

    CourseDTO getCourseById(int id);

    Integer getCourseIdByName(String name);

    List<CourseDTO> getAllCourses();

   void updateCourse(CourseDTO courseDTO);

    void deleteCourse(int id);
}
