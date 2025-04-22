package com.example.studywithchathu.Service;

import com.example.studywithchathu.Dto.PaymentDTO;

import java.util.List;

public interface PaymentService {

    void savePayment(PaymentDTO paymentDTO);
    List<PaymentDTO> getAllPayments();
}
