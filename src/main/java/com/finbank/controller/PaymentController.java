package com.finbank.controller;

import com.finbank.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/deposit")
    public String deposit(@RequestParam String userId, @RequestParam BigDecimal amount) {
        paymentService.deposit(userId, amount);
        return "충전 완료";
    }

    @PostMapping("/pay")
    public String pay(@RequestParam String userId, @RequestParam BigDecimal amount) {
        paymentService.pay(userId, amount);
        return "결제 완료";
    }
}
