package com.financial.reporting.demo.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NonNull;


@ApiModel(description = "Transaction Model")
@Data
public class Transaction{

    public String transactionId;

}
