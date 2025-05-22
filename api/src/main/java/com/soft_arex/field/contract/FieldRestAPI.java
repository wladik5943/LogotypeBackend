package com.soft_arex.field.contract;

import com.soft_arex.field.model.FieldRequestDTO;
import com.soft_arex.field.model.FieldResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Field management",description = "взаимодействие с полями")
@RequestMapping("/fields")
public interface FieldRestAPI {

    @Operation(
            summary = "Get all fields by user id",
            description = "Получает список всех существующих полей определенного пользователя."
    )

    @GetMapping
    Page<FieldResponseDTO> getAllFields(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size);

    @Operation(
            summary = "Create a new field",
            description = "Создаёт новое поле с заданными параметрами."
    )
    @PostMapping
    FieldResponseDTO createField(@RequestBody @Valid FieldRequestDTO dto);

    @Operation(
            summary = "Update field by ID",
            description = "Обновляет поле по его идентификатору."
    )
    @PutMapping("/{id}")
    FieldResponseDTO updateField(@PathVariable Long id, @RequestBody @Valid FieldRequestDTO dto);

    @Operation(
            summary = "Delete field by ID",
            description = "Удаляет поле по его идентификатору."
    )
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteField(@PathVariable Long id);
}
