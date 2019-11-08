package com.hus.ironbank.controller;

import com.hus.ironbank.client.BankApiClient;
import com.hus.ironbank.model.Account;
import com.hus.ironbank.model.Bank;
import com.hus.ironbank.model.BankTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BankController {

    @Autowired
    private BankApiClient bankApiClient;

    @GetMapping("/banks")
    public List<Bank> banks(){
        return bankApiClient.getBanks().getResults();
    }

    @GetMapping("/{bankId}/accounts")
    public List<Account> bankAccounts(@PathVariable int bankId){
        return bankApiClient.getBankAccounts(bankId).getResults();
    }

    @GetMapping("/{bankId}/accounts/{accountId}/transactions")
    public List<BankTransaction> bankTransactions(@PathVariable int bankId, @PathVariable String accountId){
        return bankApiClient.getBankTransactions(bankId, accountId).getResults();
    }

    @GetMapping("/{bankId}/accounts/{accountId}/transactions/{category}")
    public List<BankTransaction> bankTransactionsByCategory(@PathVariable int bankId,
                                                            @PathVariable String accountId,
                                                            @PathVariable String category) {
        return bankApiClient.getBankTransactions(bankId, accountId).getResults().stream()
                .filter(bankTransaction -> bankTransaction.getDescription().toLowerCase().contains(category.toLowerCase()))
                .collect(Collectors.toList());
    }

    @GetMapping("/banks/transactions")
    public List<BankTransaction> allBankTransactions() {
        List<BankTransaction> bankTransactions = bankApiClient.getBanks().getResults().stream()
                .map(bank -> bankApiClient.getBankAccounts(bank.getId()).getResults())
                .collect(Collectors.toList()).stream().flatMap(List::stream).collect(Collectors.toList()).stream()
                .map(account -> bankApiClient.getBankTransactions(account.getBankId(), account.getAccountId()).getResults())
                .collect(Collectors.toList()).stream().flatMap(List::stream).collect(Collectors.toList());

        /*
        List<BankTransaction> bankTransactions = new ArrayList<>();
        List<Bank> results = bankApiClient.getBanks().getResults();
        results.forEach(bank -> bankApiClient.getBankAccounts(bank.getId()).getResults()
                .forEach(account -> {
                    bankTransactions.addAll(bankApiClient.getBankTransactions(account.getBankId(), account.getAccountId()).getResults());
                }));
        */

        return  bankTransactions;
    }


}
