package com.finbank.service;

import com.finbank.domain.Transaction;
import com.finbank.domain.Wallet;
import com.finbank.repository.TransactionRepository;
import com.finbank.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final WalletRepository walletRepository;
    private final TransactionRepository transactionRepository;


    @Transactional
    public void deposit(String userId, BigDecimal amount) {
        Wallet wallet = walletRepository.findByUserId(Long.parseLong(userId));
        wallet.deposit(amount);
        transactionRepository.save(new Transaction(wallet, amount, Transaction.Type.DEPOSIT));
    }

    @Transactional
    public void pay(String userId, BigDecimal amount) {
        Wallet wallet = walletRepository.findByUserId(Long.parseLong(userId));
        wallet.withdraw(amount);
        transactionRepository.save(new Transaction(wallet, amount, Transaction.Type.PAYMENT));
    }
}
