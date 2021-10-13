package com.financial.reporting.demo.viewmodel;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ClientDTO implements Serializable {

    private String transactionId;
}
