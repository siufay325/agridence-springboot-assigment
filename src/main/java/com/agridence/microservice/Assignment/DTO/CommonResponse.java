package com.agridence.microservice.Assignment.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommonResponse<T> {

    private boolean success;
    private String message;
    private T data;

    public static <T> CommonResponse<T> fail(String message) {
        CommonResponse<T> response = new CommonResponse<>();
        response.setSuccess(false);
        response.setMessage(message);
        return response;
    }

    public static <T> CommonResponse<T> success(T data) {
        CommonResponse<T> response = new CommonResponse<>();
        response.setSuccess(true);
        response.setData(data);
        return response;
    }

    public static <T> CommonResponse<T> success() {
        return success(null);
    }

}
