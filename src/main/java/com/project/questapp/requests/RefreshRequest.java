package com.project.questapp.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefreshRequest {

    Long userId;

    String refreshToken;
}
