package com.financial.reporting.demo.viewmodel;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TransactionListDTO {

    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate fromDate;
    @JsonFormat(pattern = "yyyy/MM/dd")
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
