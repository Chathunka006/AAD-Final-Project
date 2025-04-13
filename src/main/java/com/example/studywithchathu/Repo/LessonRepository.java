package com.example.studywithchathu.Repo;

import com.example.studywithchathu.Entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
    @Query("SELECT l.title FROM Lesson l")
    List<String> findAllLessonNames();

    @Query("SELECT l.lessonId FROM Lesson l WHERE l.title =:name")
    Integer findLessonByName(String name);

    List<Lesson> findByIsDeletedFalse();
}


