package com.financial.reporting.demo.model;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@ApiModel(description = "User Model")
@Builder
public class User implements Serializable {

    @NotEmpty(message = "email can not be empty")
    private String email;

    @NotEmpty(message = "password can not be empty")
    private String password;
}
