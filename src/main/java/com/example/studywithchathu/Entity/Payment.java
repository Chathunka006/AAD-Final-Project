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
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;

    private String userId;

    @ManyToOne
    @JoinColumn(name = "courseId", nullable = false)
    private Course course;

    private int amount;
    private Date paymentDate;
}
