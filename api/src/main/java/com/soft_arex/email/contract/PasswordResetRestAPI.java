package com.soft_arex.email.contract;

import com.soft_arex.email.model.CodeVerifyRequest;
import com.soft_arex.email.model.PasswordCodeRequest;
import com.soft_arex.email.model.SetNewPasswordRequest;
import com.soft_arex.email.model.VerifyEmailRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Password reset and send message management",description = "смена пароля и отправка сообщений на почту")
@RequestMapping("/password")
public interface PasswordResetRestAPI {
    @Operation(summary = "send message to a registered user ", description = "отправка ссобщения для уже зарегистрированного пользователя")
    @PostMapping("/send-code")
    ResponseEntity<?> sendCode(@RequestBody PasswordCodeRequest req, Authentication auth);

    @Operation(summary = "email confirmation",description = "подтверждение высланного на почту")
    @PostMapping("/verify-code")
    ResponseEntity<?> verify(@RequestBody CodeVerifyRequest req, Authentication auth);

    @Operation(summary = "password change",description = "смена пароля")
    @PostMapping("/set-password")
    ResponseEntity<?> setPassword(@RequestBody SetNewPasswordRequest req, Authentication auth);

    @Operation(summary = "sending a message to an unregistered user",description = "отправка сообщения незарегистрированному пользователю")
    @PostMapping("/verify-email")
    ResponseEntity<?> verifyEmail(@RequestBody VerifyEmailRequest request);
}
