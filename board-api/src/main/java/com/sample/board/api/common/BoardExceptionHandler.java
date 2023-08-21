package com.sample.board.api.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BoardExceptionHandler {

    @ExceptionHandler(Exception.class)
    public BaseResponse<ErrorMessage> handleException(Exception e) {
        return BaseResponse.fail(e);
    }

}
