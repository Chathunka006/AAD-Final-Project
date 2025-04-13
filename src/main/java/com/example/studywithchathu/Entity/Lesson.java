package com.example.studywithchathu.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "lesson")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lessonId;

    private String title;
    private LocalDateTime reloadDate = LocalDateTime.now();
    private boolean isDeleted = false;
    @ManyToOne
    @JoinColumn(name = "courseId", nullable = false)
    private Course course;
}

