package com.example.studywithchathu.Controller;

import com.example.studywithchathu.Dto.PaymentDTO;
import com.example.studywithchathu.Service.PaymentService;
import com.example.studywithchathu.Util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/save")
    public ResponseUtil addPayment(@RequestBody PaymentDTO paymentDTO) {
        System.out.println(paymentDTO);
        paymentService.savePayment(paymentDTO);
        return new ResponseUtil(201, "Payment saved successfully", null);
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseUtil getAllPayments() {
        List<PaymentDTO> payments = paymentService.getAllPayments();
        return new ResponseUtil(200, "All courses retrieved", payments);
    }
}
