package com.financial.reporting.demo.viewmodel;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@ApiModel(description = "Report DTO")
public class ReportDTO {

    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate fromDate;

    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate toDate;

    private Integer merchant;

    private Integer acquirer;
}
