package com.example.studywithchathu.Repo;

import com.example.studywithchathu.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
