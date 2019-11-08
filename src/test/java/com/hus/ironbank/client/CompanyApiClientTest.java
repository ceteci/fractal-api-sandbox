package com.hus.ironbank.client;

import com.hus.ironbank.TestInitializer;
import com.hus.ironbank.model.Company;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CompanyApiClientTest extends TestInitializer {

    @Autowired private CompanyApiClient companyApiClient;

    @Test
    void createCompany() {
        String requestBody = "{\n    \"yEndMonth\": 3,\n    \"website\": \"https://www.hus.com\",\n    " +
                "\"address\": \"test adres\",\n    \"yEndDay\": 30,\n    \"name\": \"string\",\n    " +
                "\"industry\": \"fun\",\n    \"currency\": \"GBP\",\n    \"pitch\": \"Fruity code\"\n}";
        Company company = companyApiClient.createCompany(requestBody);
        assertTrue(company != null);
    }

}