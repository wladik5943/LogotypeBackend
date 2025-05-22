package com.soft_arex.security.contract;

import com.soft_arex.security.model.JwtAuthenticationResponse;
import com.soft_arex.security.model.RefreshRequest;
import com.soft_arex.user.model.UserCreateRequest;
import com.soft_arex.user.model.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Authentication and Registration",
        description = "Методы для входа, регистрации, получения текущего пользователя и обновления токенов."
)
@RequestMapping("oauth")
public interface JwtRestAPI {

    @Operation(
            summary = "Sign in",
            description = "Аутентификация пользователя по логину и паролю. Возвращает JWT токен."
    )
    @PostMapping("/sign-in")
    JwtAuthenticationResponse signIn(@RequestBody UserCreateRequest userCreateRequest);

    @Operation(
            summary = "Sign up",
            description = "Создание нового пользователя и возвращение JWT токена для него."
    )
    @PostMapping("/sign-up")
    JwtAuthenticationResponse signUp(@RequestBody UserCreateRequest userCreateRequest);

    @Operation(
            summary = "Get current user",
            description = "Возвращает информацию о текущем авторизованном пользователе."
    )
    @GetMapping("/me")
    ResponseEntity<UserResponse> getCurrentUser();

    @Operation(
            summary = "Refresh token",
            description = "Позволяет обновить access токен по refresh токену."
    )
    @PostMapping("/refresh-token")
    JwtAuthenticationResponse refreshToken(@RequestBody RefreshRequest request);
}
