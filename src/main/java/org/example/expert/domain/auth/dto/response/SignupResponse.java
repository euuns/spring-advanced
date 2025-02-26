package org.example.expert.domain.auth.dto.response;

import lombok.Getter;

@Getter
public class SignupResponse {

    private final String message;

    public SignupResponse(String message) {
        this.message = message;
    }
}
