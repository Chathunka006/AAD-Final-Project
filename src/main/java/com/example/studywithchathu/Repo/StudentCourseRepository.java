package com.example.studywithchathu.Repo;

import com.example.studywithchathu.Entity.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Integer> {

    @Query("SELECT sc.userId,sc.courseId from StudentCourse sc WHERE sc.courseId=:courseId AND sc.userId =:studentId")
    StudentCourse findStudentCourseByCourseIdAndStudentId(int courseId, UUID studentId);

    @Query("SELECT sc FROM StudentCourse sc WHERE sc.userId =:studentId")
    List<StudentCourse> findStudentCourseByStudentId(UUID studentId);
}
