package com.soft_arex.exeption;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Data
public class ExceptionResponse {
    private HttpStatus status;
    private Integer statusInt;
    private String message;
    private int code;

    public ExceptionResponse(int i, String unauthorized, String message) {
    }
}
