package com.financial.reporting.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@ApiModel(description = "Report Model")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Report implements Serializable {

    @NotEmpty(message = "fromDate can not be empty")
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate fromDate;

    @NotEmpty(message = "toDate can not be empty")
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate toDate;

    private Integer merchant;

    private Integer acquirer;
}
