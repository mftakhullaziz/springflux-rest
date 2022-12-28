package com.example.reactiveSpringSQLService.payload;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseDto<T> {

    private Boolean success;
    private T data;
    private Boolean failed;
    private String message;
    private Integer statusCode;

    private ResponseDto(Boolean success, T data, Boolean failed, String message, Integer statusCode) {
        this.success = success;
        this.data = data;
        this.failed = failed;
        this.message = message;
        this.statusCode = statusCode;
    }

    public static <T> ResponseDto<T> success(T data, String message, Integer statusCode) {
        return new ResponseDto<T>(true, data, false, message, statusCode);
    }

}

