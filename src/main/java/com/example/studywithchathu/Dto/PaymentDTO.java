package com.example.studywithchathu.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDTO {
    private int paymentId;
    private UUID userId;
    private int courseId;
    private int amount;
    private Date paymentDate;
}
