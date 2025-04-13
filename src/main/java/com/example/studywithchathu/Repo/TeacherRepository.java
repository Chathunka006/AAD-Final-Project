package com.example.studywithchathu.Repo;

import com.example.studywithchathu.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    @Query("SELECT t.name FROM Teacher t")
    List<String> findAllTeacherNames();

    @Query("SELECT t.teacherId FROM Teacher t WHERE t.name =:name")
    Integer findTeacherByName(String name);

    List<Teacher> findByIsDeletedFalse();
}
