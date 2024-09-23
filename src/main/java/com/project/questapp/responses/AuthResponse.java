package com.project.questapp.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {

    String message;

    Long userId;

    String accessToken;

    String refreshToken;
}
