package com.financial.reporting.demo.controller;

import com.financial.reporting.demo.model.*;
import com.financial.reporting.demo.response.ResponseUser;
import com.financial.reporting.demo.viewmodel.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 *
 */
@RestController
@Api("Financial Controller Rest Api")
@RequestMapping("/v1/api")
@Validated
//@PropertySource("classpath:application.live.properties") //Live environment
@PropertySource("classpath:application.test.properties") //Test environment
public class FinancialAppController {

    private final Logger logger = LoggerFactory.getLogger(FinancialAppController.class);

    private final RestTemplate restTemplate;

    HttpHeaders headers = new HttpHeaders();

    private ModelMapper modelMapper;

    public FinancialAppController(RestTemplate restTemplate, ModelMapper modelMapper) {
        this.restTemplate = restTemplate;
        this.modelMapper = modelMapper;
    }

    //Url Values reading properties file.
    @Value("${financial.reporting.api.mainhost}")
    private String mainHost;

    @Value("${financial.reporting.api.login}")
    private String loginUrl;

    @Value("${financial.reporting.api.report}")
    private String reportUrl;

    @Value("${financial.reporting.api.transactionlist}")
    private String transactionListUrl;

    @Value("${financial.reporting.api.transaction}")
    private String transactionUrl;

    @Value("${financial.reporting.api.client}")
    private String clientUrl;

    @NonNull
    private String apiKey;


    /**
     * @param user model request
     * @return responseEntity return response data Json
     */
    @ApiOperation(value = "User Login Api", response = ResponseUser.class)//for the swagger report api info.
    @PostMapping(path ="/user/login",produces = "application/json")
    public ResponseEntity<ResponseUser> loginUser(@RequestBody User user){

        //modelTodto There is no difference between model and dto, but may be needed in the future.
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);

        String loginUserUrl = mainHost+loginUrl;

        HttpEntity<UserDTO> entity = new HttpEntity(userDTO);
        ResponseEntity<ResponseUser> responseEntity= restTemplate.exchange(loginUserUrl, HttpMethod.POST, entity, ResponseUser.class);

        apiKey = responseEntity.getBody().getToken();

        return responseEntity;
    }



    @ApiOperation(value = "Transactions Report Api")
    @PostMapping(path ="/transactions/report",produces = "application/json")
    public ResponseEntity getReport(@RequestBody Report report){

        String getReportUrl = mainHost+reportUrl;
        //modelTodto There is no difference between model and dto, but may be needed in the future.
        ReportDTO reportDTO = modelMapper.map(report, ReportDTO.class);

        headers.set("Authorization",apiKey);
        HttpEntity<ReportDTO> entity = new HttpEntity<>(reportDTO, headers);

        ResponseEntity responseEntity = restTemplate.postForEntity(getReportUrl, entity, String.class);

        return responseEntity;
    }


    @ApiOperation(value = "Transactions List Api")
    @PostMapping(path ="/transaction/list",produces = "application/json")
    private  ResponseEntity getTransactionList(@RequestBody TransactionList transactionList){

        String getTransactionListUrl = mainHost+reportUrl;
        //modelTodto There is no difference between model and dto, but may be needed in the future.
        TransactionListDTO transactionListDTO = modelMapper.map(transactionList, TransactionListDTO.class);

        headers.set("Authorization",apiKey);
        HttpEntity<TransactionListDTO> entity = new HttpEntity<>(transactionListDTO, headers);

        ResponseEntity responseEntity = restTemplate.postForEntity(getTransactionListUrl, entity, String.class);

        return responseEntity;
    }

    @PostMapping(value="/transaction", produces = "application/json")
    public ResponseEntity getTransaction(@RequestBody Transaction transaction) {

        String getTransactionUrl = mainHost+transactionUrl;
        //modelTodto There is no difference between model and dto, but may be needed in the future.
        TransactionDTO transactionDto = modelMapper.map(transaction, TransactionDTO.class);

        headers.set("Authorization",apiKey);
        HttpEntity<TransactionDTO> entity = new HttpEntity<>(transactionDto, headers);

        ResponseEntity responseEntity = restTemplate.postForEntity(getTransactionUrl, entity, String.class);

        return responseEntity;
    }

    @PostMapping(value="/client", produces = "application/json")
    public ResponseEntity getClient(@RequestBody Client client) {

        String getClientUrl = mainHost+clientUrl;
        //modelTodto There is no difference between model and dto, but may be needed in the future.
        ClientDTO clientDTO = modelMapper.map(client, ClientDTO.class);

        headers.set("Authorization",apiKey);
        HttpEntity<ClientDTO> entity = new HttpEntity<>(clientDTO, headers);

        ResponseEntity responseEntity = restTemplate.postForEntity(getClientUrl, entity, String.class);

        return responseEntity;
    }


}
