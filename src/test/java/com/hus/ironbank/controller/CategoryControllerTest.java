package com.hus.ironbank.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hus.ironbank.TestInitializer;
import com.hus.ironbank.model.Category;
import com.hus.ironbank.model.Transaction;
import com.hus.ironbank.model.TransactionPutBody;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryControllerTest extends TestInitializer {

    @Autowired private CategoryController categoryController;

    @Test
    void getAllCategories(){
        List<Category> categories = categoryController.getCategories();
        assertAll(() -> assertNotNull(categories),
                  () -> assertTrue(categories.size() == 7));
    }

    @Test
    void getCategoriesById() {
        List<Category> categories = categoryController.getCategoriesById("a6hg1");
        assertAll(() -> assertNotNull(categories),
                  () -> assertTrue(categories.size() == 1));
    }

    @Test
    void getAllCategorisedTransactions(){
        List<Transaction> transactions = categoryController.getAllCategorisedTransactions();
        assertAll(() ->  assertNotNull(transactions),
                  () -> assertTrue(transactions.size() == 13));
    }

    @Test
    void getCategorisedTransactionsByCategory() {
        List<Transaction> transactions = categoryController.getCategorisedTransactionsByCategory("a6hg1");
        assertAll(() ->  assertNotNull(transactions),
                () -> assertTrue(transactions.size() == 2));
    }

    @Test
    void updateTransactionCategory() throws JSONException {
        ObjectMapper mapper = new ObjectMapper();
        TransactionPutBody transactionPutBody = new TransactionPutBody();
        transactionPutBody.setTransactionId("fakeTrx07");
        transactionPutBody.setCategoryId("gasd7");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String requestBody = "[" + gson.toJson(transactionPutBody) + "]";

        ResponseEntity responseEntity = categoryController.updateTransactionCategory("fakeTrx07", requestBody);
        assertAll(() -> assertNotNull(responseEntity),
                  () -> assertTrue(responseEntity.getStatusCodeValue() == 204));
    }

}