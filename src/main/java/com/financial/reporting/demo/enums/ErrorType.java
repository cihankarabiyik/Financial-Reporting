package com.financial.reporting.demo.enums;

/**
 *
 */
public interface ErrorType {

        public String DO_NOT_HONOR = "Do not honor";
        public String INVALID_TRANSACTION = "Invalid Transaction";
        public String INVALID_CARD = "Invalid Card";
        public String NOT_SUFFICIENT_FUNDS = "Not sufficient funds";
        public String INCORRECT_PIN = "Incorrect PIN";
        public String INVALID_COUNTRY_ASSOCIATON = "Invalid country association";
        public String CURRENCY_NOT_ALLOWED = "Currency not allowed";
        public String D3_SECURE_TRANSPORT_ERROR = "3-D Secure Transport Error";
        public String TRANSACTION_NOT_PERMITTED_TO_CARDHOLDER = "Transaction not permitted to cardholder";

    }
