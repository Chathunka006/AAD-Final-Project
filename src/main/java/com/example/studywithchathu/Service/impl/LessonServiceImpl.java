package com.example.studywithchathu.Service.impl;

import com.example.studywithchathu.Dto.LessonDTO;
import com.example.studywithchathu.Entity.Lesson;
import com.example.studywithchathu.Repo.LessonRepository;
import com.example.studywithchathu.Service.LessonService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonRepository lessonRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    @Override
    public void saveLesson(LessonDTO lessonDTO) {
        if (lessonRepo.existsById(lessonDTO.getLessonId())) {
            throw new RuntimeException("Lesson already exists!");
        }
        lessonRepo.save(modelMapper.map(lessonDTO, Lesson.class));
    }

    @Override
    public List<String> getAllLessonNames() {
        return lessonRepo.findAllLessonNames();
    }

    @Override
    public Integer getLessonIdByName(String name) {
        return lessonRepo.findLessonByName(name);
    }

    @Override
    public List<LessonDTO> getAllLessons() {
        return modelMapper.map(lessonRepo.findByIsDeletedFalse(),
                new TypeToken<List<LessonDTO>>() {}.getType());
    }

    @Override
    public void updateLesson(LessonDTO lessonDTO) {
        if (!lessonRepo.existsById(lessonDTO.getLessonId())) {
            throw new RuntimeException("Lesson does not exist!");
        }

        Lesson lesson = modelMapper.map(lessonDTO, Lesson.class);
        lessonRepo.save(lesson);
    }

    @Override
    public void deleteLesson(int id) {
        Lesson lesson = lessonRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));

        lesson.setDeleted(true); // Soft delete
        lessonRepo.save(lesson);
    }
}
