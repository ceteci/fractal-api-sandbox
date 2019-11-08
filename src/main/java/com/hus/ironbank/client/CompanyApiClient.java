package com.hus.ironbank.client;

import com.hus.ironbank.model.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="companyApiClient", url="${fractal.api.companiesUrl}")
public interface CompanyApiClient {

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    Company createCompany(@RequestBody String requestBody);
}
