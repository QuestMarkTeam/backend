package com.example.cluvrapi.global.exception;

import com.example.cluvrapi.global.response.ResponseCode;
import lombok.Getter;

public class BusinessException extends RuntimeException {

    @Getter
    private final ResponseCode responseCode;

    public BusinessException(ResponseCode responseCode) {
        super(responseCode.getDefaultMessage());
        this.responseCode = responseCode;
    }

    public BusinessException(ResponseCode responseCode, String message) {
        super(message);
        this.responseCode = responseCode;
    }

}