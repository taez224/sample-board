package com.sample.board.api.common;

import com.sample.board.api.common.exception.ErrorMessage;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.server.ResponseStatusException;

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

    public static BaseResponse<ErrorMessage> fail(ResponseStatusException e) {
        ErrorMessage errorMessage = ErrorMessage.fromException(e);
        return new BaseResponse<>(e.getStatusCode(), errorMessage);
    }

    public static BaseResponse<ErrorMessage> fail(Exception e) {
        ErrorMessage errorMessage = ErrorMessage.fromException(e);
        return new BaseResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, errorMessage);
    }

    public static <T> BaseResponse<T> of(T body) {
        return new BaseResponse<>(HttpStatus.OK, body);
    }

    public static <T> BaseResponse<T> created(T body) {
        return new BaseResponse<>(HttpStatus.CREATED, body);
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
