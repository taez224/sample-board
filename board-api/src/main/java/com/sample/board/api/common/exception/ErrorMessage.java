package com.sample.board.api.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage implements Serializable {

    private String exceptionCode;
    private String exceptionName;
    private String exceptionMessage;

    public static ErrorMessage fromException(Exception e) {
        String exceptionName = e.getClass().getSimpleName();
        String exceptionMessage = e.getMessage();
        return new ErrorMessage("", exceptionName, exceptionMessage);
    }
}
