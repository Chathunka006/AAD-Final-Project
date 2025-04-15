package com.example.studywithchathu.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherId;

    private String email;
    private Date joinDate;
    private String name;
    private String phoneNumber;
    private boolean isDeleted = false;


    @ManyToOne
    @JoinColumn(name = "courseId", nullable = false)
    private Course course;
}
