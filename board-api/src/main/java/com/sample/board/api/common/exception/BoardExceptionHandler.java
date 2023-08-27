package com.sample.board.api.common.exception;

import com.sample.board.api.common.BaseResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class BoardExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public BaseResponse<ErrorMessage> handleResponseStatusException(ResponseStatusException e) {
        return BaseResponse.fail(e);
    }


    @ExceptionHandler(Exception.class)
    public BaseResponse<ErrorMessage> handleException(Exception e) {
        return BaseResponse.fail(e);
    }

}
