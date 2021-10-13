package com.financial.reporting.demo.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;

@Data
@ApiModel(description = "User Model")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @NotEmpty(message = "email can not be empty")
    private String email;

    @NotEmpty(message = "password can not be empty")
    private String password;
}
