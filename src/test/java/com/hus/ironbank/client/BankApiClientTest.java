package com.hus.ironbank.client;

import com.hus.ironbank.TestInitializer;
import com.hus.ironbank.model.AccountResult;
import com.hus.ironbank.model.BankResult;
import com.hus.ironbank.model.BankTransactionResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BankApiClientTest extends TestInitializer {

    @Autowired private BankApiClient bankApiClient;

    @Test
    void getBanks() {
        BankResult banks = bankApiClient.getBanks();
        assertTrue(banks.getResults().size() > 0);
    }

    @Test
    void getAccounts() {
        AccountResult accounts = bankApiClient.getBankAccounts(5);
        assertTrue(accounts.getResults().size() > 0);
    }
/*
    @Test
    void getBankTransactions() {
        BankTransactionResult bankTransactions = bankApiClient.getBankTransactions(5, "fakeAcc38");
        System.out.println(bankTransactions.results.size());
    }*/


}