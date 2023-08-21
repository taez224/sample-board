package com.sample.board.api.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;

@Getter
@Setter
public class BaseResponse<T> extends ResponseEntity<T> {

    public BaseResponse(HttpStatusCode status) {
        super(status);
    }

    public BaseResponse(HttpStatusCode status, T body) {
        super(body, status);
    }


    public static BaseBodyBuilder success() {
        return new BaseBodyBuilder() {
            @Override
            public <T> BaseResponse<T> body(T body) {

                return new BaseResponse<>(HttpStatus.OK, body);
            }
        };
    }

    public static BaseResponse<ErrorMessage> fail(Exception e) {
        ErrorMessage errorMessage = ErrorMessage.fromException(e);
        return new BaseResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, errorMessage);
    }

    public interface BaseBodyBuilder {

        /**
         * Set the body of the response entity and returns it.
         * @param <T> the type of the body
         * @param body the body of the response entity
         * @return the built response entity
         */
        <T> BaseResponse<T> body(@Nullable T body);
    }
}
