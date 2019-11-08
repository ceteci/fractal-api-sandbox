package com.hus.ironbank.controller;

import com.hus.ironbank.model.Category;
import com.hus.ironbank.model.Transaction;
import com.hus.ironbank.client.CategorisationApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CategoryController {

    @Autowired
    CategorisationApiClient categorisationApiClient;

    @GetMapping("/categories")
    public List<Category> getCategories() {
        return categorisationApiClient.getCategories().getResults();
    }

    @GetMapping("/categories/{categoryId}")
    public List<Category> getCategoriesById(@PathVariable String categoryId) {
        return categorisationApiClient.getCategories().getResults().stream()
                .filter(category -> category.getId().equals(categoryId)).collect(Collectors.toList());
    }

    @GetMapping("/categories/transactions")
    public List<Transaction> getAllCategorisedTransactions() {
        return categorisationApiClient.getCategorisedTransaction().getResults();
    }

    @GetMapping("/categories/transactions/{categoryId}")
    public List<Transaction> getCategorisedTransactionsByCategory(@PathVariable String categoryId) {
        List<Category> category = categorisationApiClient.getCategories().getResults()
                .stream().filter(category1 -> category1.getId().equals(categoryId)).collect(Collectors.toList());

        String categoryName = CollectionUtils.isEmpty(category) ? "" : category.get(0).getName();
        List<Transaction> results = categorisationApiClient.getCategorisedTransaction().getResults();
        return results.stream().filter(transaction -> transaction.getCategory().equals(categoryName)).collect(Collectors.toList());
    }

    @PutMapping("/transactions/{transactionId}")
    public ResponseEntity updateTransactionCategory(@PathVariable String transactionId,
                                                    @Valid @RequestBody String requestBody) {
        return categorisationApiClient.updateTransactionCategory(requestBody);
    }

}
