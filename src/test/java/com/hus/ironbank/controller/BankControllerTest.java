package com.hus.ironbank.controller;

import com.hus.ironbank.TestInitializer;
import com.hus.ironbank.model.Account;
import com.hus.ironbank.model.AccountResult;
import com.hus.ironbank.model.Bank;
import com.hus.ironbank.model.BankTransaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BankControllerTest extends TestInitializer {

    @Autowired private BankController bankController;

    @Test
    void getAllBanks() {
        List<Bank> banks = bankController.banks();
        assertAll(() -> assertNotNull(banks),
                  () -> assertTrue(banks.size() > 0));
    }

    @Test
    void getAllBankAccounts() {
        List<Account> accounts = bankController.bankAccounts(1);
        assertAll(() -> assertNotNull(accounts),
                  () -> assertTrue(accounts.size() > 0));
    }

    @Test
    void allBankTransactions() {
        List<BankTransaction> transactions = bankController.allBankTransactions();
        assertAll(() -> assertNotNull(transactions),
                  () -> assertTrue(transactions.size() > 0));
    }

}