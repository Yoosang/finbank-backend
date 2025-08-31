package com.finbank.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    public enum Type {
        DEPOSIT, PAYMENT
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Wallet wallet;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private Type type;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Transaction(Wallet wallet, BigDecimal amount, Type type) {
        this.wallet = wallet;
        this.amount = amount;
        this.type = type;
    }
}
