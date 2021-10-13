package com.financial.reporting;

import com.financial.reporting.demo.viewmodel.*;
import org.junit.jupiter.api.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDate;
import java.util.Arrays;

public class FinancalAppTest {

    private static String mainUrl = "https://sandbox-reporting.rpdpymnt.com/api/v3";

    @Test
    @Order(1)
    void loginTest() {
        RestTemplate restTemplate = new RestTemplate();
        String loginUri = mainUrl+"/merchant/user/login";

        UserDTO userDto = UserDTO.builder()
                .email("demo@financialhouse.io")
                .password("cjaiU8CV")
                .build();

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<UserDTO> httpEntity = new HttpEntity<>(userDto,headers);
        ResponseEntity responseEntity = restTemplate.postForEntity(loginUri, httpEntity, String.class);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    void checkReportTest(){
        RestTemplate restTemplate = new RestTemplate();
        String reportUrl = mainUrl+"/transactions/report";
        HttpHeaders httpHeaders = new HttpHeaders();
        //Written for testing
        /*headers.set("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtZXJjaGFudFVzZXJJZCI6NTMsInJvbGUiOiJ1c2VyIiwibWVyY2" +
                "hhbnRJZCI6Mywic3ViTWVyY2hhbnRJZHMiOlszLDc0LDkzLDExOTEsMTI5NSwxMTEsMTM3LDEzOCwxNDIsMTQ1LDE0NiwxNTMsMzM0LDE3NSwxODQ" +
                "sMjIwLDIyMSwyMjIsMjIzLDI5NCwzMjIsMzIzLDMyNywzMjksMzMwLDM0OSwzOTAsMzkxLDQ1NSw0NTYsNDc5LDQ4OCw1NjMsMTE0OSw1NzAsMTEzOC" +
                "wxMTU2LDExNTcsMTE1OCwxMTc5LDEyOTMsMTI5NCwxMzA2LDEzMDcsMTMyNF0sInRpbWVzdGFtcCI6MTYzNDA4MDkzNH0.x5QbuRUf09yCBCAsIUqWWN9" +
                "6vL6XMcdP_855WybIl6Y");
                */

        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        ReportDTO reportDto = ReportDTO.builder()
                .fromDate(LocalDate.parse("2015-07-01"))
                .toDate(LocalDate.parse("2015-10-01"))
                .merchant(1)
                .acquirer(1).build();
        HttpEntity<ReportDTO> httpEntity = new HttpEntity<>(reportDto, httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(reportUrl, httpEntity, String.class);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    void checkTransaction() {
        RestTemplate restTemplate = new RestTemplate();
        String transactionUrl = mainUrl+"/transaction";

        HttpHeaders httpHeaders = new HttpHeaders();
        //Written for testing
        /*httpHeaders.set("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtZXJjaGFudFVzZXJJZCI6NTMsInJvbGUiOiJ1c2VyIiwibWVyY2" +
                "hhbnRJZCI6Mywic3ViTWVyY2hhbnRJZHMiOlszLDc0LDkzLDExOTEsMTI5NSwxMTEsMTM3LDEzOCwxNDIsMTQ1LDE0NiwxNTMsMzM0LDE3NSwxODQ" +
                "sMjIwLDIyMSwyMjIsMjIzLDI5NCwzMjIsMzIzLDMyNywzMjksMzMwLDM0OSwzOTAsMzkxLDQ1NSw0NTYsNDc5LDQ4OCw1NjMsMTE0OSw1NzAsMTEzOC" +
                "wxMTU2LDExNTcsMTE1OCwxMTc5LDEyOTMsMTI5NCwxMzA2LDEzMDcsMTMyNF0sInRpbWVzdGFtcCI6MTYzNDA4MDkzNH0.x5QbuRUf09yCBCAsIUqWWN9" +
                "6vL6XMcdP_855WybIl6Y");
                */
        TransactionDTO transactionDto = TransactionDTO.builder()
                .transactionId("1-1444392550-1")
                .build();
        HttpEntity<TransactionDTO> httpEntity = new HttpEntity<>(transactionDto, httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(transactionUrl, httpEntity, String.class);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }
    @Test
    void checkTransactionList(){
        RestTemplate restTemplate = new RestTemplate();

        String transactionListUrl = mainUrl+"/transaction/list";

        HttpHeaders httpHeaders = new HttpHeaders();
        //Written for testing
        /*httpHeaders.set("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtZXJjaGFudFVzZXJJZCI6NTMsInJvbGUiOiJ1c2VyIiwibWVyY2" +
                "hhbnRJZCI6Mywic3ViTWVyY2hhbnRJZHMiOlszLDc0LDkzLDExOTEsMTI5NSwxMTEsMTM3LDEzOCwxNDIsMTQ1LDE0NiwxNTMsMzM0LDE3NSwxODQ" +
                "sMjIwLDIyMSwyMjIsMjIzLDI5NCwzMjIsMzIzLDMyNywzMjksMzMwLDM0OSwzOTAsMzkxLDQ1NSw0NTYsNDc5LDQ4OCw1NjMsMTE0OSw1NzAsMTEzOC" +
                "wxMTU2LDExNTcsMTE1OCwxMTc5LDEyOTMsMTI5NCwxMzA2LDEzMDcsMTMyNF0sInRpbWVzdGFtcCI6MTYzNDA4MDkzNH0.x5QbuRUf09yCBCAsIUqWWN9" +
                "6vL6XMcdP_855WybIl6Y");
                */

        TransactionListDTO transactionListDTO = TransactionListDTO.builder()
                .fromDate(LocalDate.parse("2015-07-01"))
                .toDate(LocalDate.parse("2015-10-01"))
                .build();
        HttpEntity<TransactionListDTO> httpEntity = new HttpEntity<>(transactionListDTO, httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(transactionListUrl, httpEntity, String.class);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    void checkClient(){
        RestTemplate restTemplate = new RestTemplate();
        String clientUrl = mainUrl+"/client";

        HttpHeaders httpHeaders = new HttpHeaders();
        //Written for testing
        /*httpHeaders.set("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtZXJjaGFudFVzZXJJZCI6NTMsInJvbGUiOiJ1c2VyIiwibWVyY2" +
                "hhbnRJZCI6Mywic3ViTWVyY2hhbnRJZHMiOlszLDc0LDkzLDExOTEsMTI5NSwxMTEsMTM3LDEzOCwxNDIsMTQ1LDE0NiwxNTMsMzM0LDE3NSwxODQ" +
                "sMjIwLDIyMSwyMjIsMjIzLDI5NCwzMjIsMzIzLDMyNywzMjksMzMwLDM0OSwzOTAsMzkxLDQ1NSw0NTYsNDc5LDQ4OCw1NjMsMTE0OSw1NzAsMTEzOC" +
                "wxMTU2LDExNTcsMTE1OCwxMTc5LDEyOTMsMTI5NCwxMzA2LDEzMDcsMTMyNF0sInRpbWVzdGFtcCI6MTYzNDA4MDkzNH0.x5QbuRUf09yCBCAsIUqWWN9" +
                "6vL6XMcdP_855WybIl6Y");
                */

        ClientDTO clientDTO = ClientDTO.builder()
                .transactionId("1-1444392550-1")
                .build();
        HttpEntity<ClientDTO> httpEntity = new HttpEntity<>(clientDTO, httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(clientUrl, httpEntity, String.class);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

}
