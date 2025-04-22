package com.example.studywithchathu.Service.impl;

import com.example.studywithchathu.Dto.PaymentDTO;
import com.example.studywithchathu.Entity.Payment;
import com.example.studywithchathu.Repo.PaymentRepository;
import com.example.studywithchathu.Service.PaymentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void savePayment(PaymentDTO paymentDTO) {
        paymentRepository.save(modelMapper.map(paymentDTO, Payment.class));
    }

    @Override
    public List<PaymentDTO> getAllPayments() {
        return modelMapper.map(paymentRepository.findAll(),
                new TypeToken<List<PaymentDTO>>() {}.getType());
    }
}
