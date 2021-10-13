package com.financial.reporting.demo.model;

import io.swagger.annotations.ApiModel;
import lombok.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


@ApiModel(description = "Client Model")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {

    @NotEmpty(message = "transactionId can not be empty")
    private String transactionId;
}
