package com.example.studywithchathu.Repo;

import com.example.studywithchathu.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher ,Integer> {
    @Query("SELECT l.name FROM Teacher l")
    List<String> findAllTeacherNames();

    @Query("SELECT l.teacherId FROM Teacher l WHERE l.name =:name")
    Integer findTeacherByName(String name);

    List<Teacher> findByIsDeletedFalse();
}
