package com.financial.reporting.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@ApiModel(description = "TransactionList Model")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionList implements Serializable {

    private LocalDate fromDate;
    private LocalDate toDate;
    private String operation;
    private Integer merchantId;
    private Integer acquireId;
    private String paymentMethod;
    private String errorCode;
    private String filterField;
    private String filterValue;
    private Integer page;
}
