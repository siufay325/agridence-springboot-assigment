package com.agridence.microservice.Assignment.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginResponse {

    private String accessToken;

    public LoginResponse(String accessToken) {
        this.accessToken = accessToken;
    }

}
