package com.hus.ironbank.client;

import com.hus.ironbank.model.AccountResult;
import com.hus.ironbank.model.BankResult;
import com.hus.ironbank.model.BankTransactionResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="bankApiClient", url="${fractal.api.bankingUrl}")
public interface BankApiClient {

    @GetMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    BankResult getBanks();

    @GetMapping(value = "/{bankId}/accounts", consumes = MediaType.APPLICATION_JSON_VALUE)
    AccountResult getBankAccounts(@PathVariable int bankId);

    @GetMapping(value = "/{bankId}/accounts/{accountId}/transactions", consumes = MediaType.APPLICATION_JSON_VALUE)
    BankTransactionResult getBankTransactions(@PathVariable int bankId, @PathVariable String accountId);

}
