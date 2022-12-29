package com.example.reactiveSpringSQLService.payload;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsersResponse<T> {

    private Boolean success;
    private T data;
    private Boolean failed;
    private String message;
    private Integer statusCode;

    private UsersResponse(Boolean success, T data, Boolean failed, String message, Integer statusCode) {
        this.success = success;
        this.data = data;
        this.failed = failed;
        this.message = message;
        this.statusCode = statusCode;
    }

    public static <T> UsersResponse<T> success(T data, String message, Integer statusCode) {
        return new UsersResponse<T>(true, data, false, message, statusCode);
    }

}

