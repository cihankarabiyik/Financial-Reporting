package com.financial.reporting.demo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

@Data
@AllArgsConstructor
public class ResponseError {

    private String message;
    private String details;
    private Date errorDate;
}
