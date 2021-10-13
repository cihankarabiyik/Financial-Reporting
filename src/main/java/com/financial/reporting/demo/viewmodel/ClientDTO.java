package com.financial.reporting.demo.viewmodel;

import lombok.*;

import java.io.Serializable;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO implements Serializable {

    private String transactionId;
}
