package com.hus.ironbank.client;

import com.hus.ironbank.TestInitializer;
import com.hus.ironbank.model.CategoryResult;
import com.hus.ironbank.model.TransactionResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CategorisationApiClientTest extends TestInitializer {

    @Autowired private CategorisationApiClient categorisationApiClient;

    @Test
    void getCategories() {
        CategoryResult categories = categorisationApiClient.getCategories();
        assertTrue(categories.getResults().size() > 0);
    }

    @Test
    void getCategorisedTransactions() {
        TransactionResult transactionResult = categorisationApiClient.getCategorisedTransaction();
        System.out.println(transactionResult.getResults().size());
        assertTrue(transactionResult.getResults().size() > 0);
    }

}