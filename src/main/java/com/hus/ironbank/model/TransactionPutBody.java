package com.hus.ironbank.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TransactionPutBody {

    @NotNull
    private String transactionId;
    @NotNull
    private String categoryId;

}
