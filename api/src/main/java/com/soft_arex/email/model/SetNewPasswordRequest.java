package com.soft_arex.email.model;

import lombok.Data;

@Data
public class SetNewPasswordRequest {
    private String email;
    private String newPassword;
}





