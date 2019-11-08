package com.hus.ironbank.client;

import com.hus.ironbank.model.CategoryResult;
import com.hus.ironbank.model.TransactionResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="categorizationApiClient", url="${fractal.api.categorisationUrl}")
public interface CategorisationApiClient {

    @GetMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    CategoryResult getCategories();

    @GetMapping(value = "/transactions", consumes = MediaType.APPLICATION_JSON_VALUE)
    TransactionResult getCategorisedTransaction();

    @PutMapping(value = "/transactions", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity updateTransactionCategory(@RequestBody String requestBody);

}
