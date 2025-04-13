package com.example.studywithchathu.Repo;

import com.example.studywithchathu.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Integer> {

    @Query("SELECT c.title FROM Course c WHERE c.isDeleted = false")
    List<String> findAllCourseNames();

    @Query("SELECT c.courseId FROM Course c WHERE c.title =:name")
    Integer findCourseByName(String name);

    List<Course> findByIsDeletedFalse();
}
