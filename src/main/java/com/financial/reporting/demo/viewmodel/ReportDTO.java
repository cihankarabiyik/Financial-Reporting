package com.financial.reporting.demo.viewmodel;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ApiModel(description = "Report DTO")
public class ReportDTO {

    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate fromDate;

    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate toDate;

    private Integer merchant;

    private Integer acquirer;
}
