package com.example.studywithchathu.Service;

import com.example.studywithchathu.Dto.LessonDTO;

import java.util.List;

public interface LessonService {
    void saveLesson(LessonDTO lessonDTO);
    List<String> getAllLessonNames();
    Integer getLessonIdByName(String name);
    List<LessonDTO> getAllLessons();
    void updateLesson(LessonDTO lessonDTO);
    void deleteLesson(int id);
}
