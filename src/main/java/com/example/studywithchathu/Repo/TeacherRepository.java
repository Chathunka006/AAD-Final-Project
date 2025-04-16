package com.example.studywithchathu.Repo;

import com.example.studywithchathu.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher ,Integer> {
    List<Teacher> findByIsDeletedFalse();

    Teacher findByNameAndIsDeletedFalse(String name);
}
