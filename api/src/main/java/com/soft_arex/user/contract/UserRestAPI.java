package com.soft_arex.user.contract;

import com.soft_arex.user.model.UserCreateRequest;
import com.soft_arex.user.model.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(
        name = "User profile",
        description = "Методы для редактирования профиля пользователя."
)
@RequestMapping("user")
public interface UserRestAPI {

    @Operation(
            summary = "Edit profile",
            description = "Изменяет данные профиля текущего пользователя."
    )
    @PostMapping("/edit-profile")
    UserResponse editProfile(@RequestBody UserCreateRequest request);
}
