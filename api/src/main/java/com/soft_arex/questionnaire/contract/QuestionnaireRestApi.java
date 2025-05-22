package com.soft_arex.questionnaire.contract;

import com.soft_arex.questionnaire.model.QuestionnaireRequestDTO;
import com.soft_arex.questionnaire.model.QuestionnaireResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "questionnaire management", description = "взаимодействие с анкетами")
@RequestMapping("/test")
public interface QuestionnaireRestApi {

    @Operation(
            summary = "Update questionnaire status",
            description = "Обновляет статус анкеты по её идентификатору (активна/неактивна)."
    )
    @PatchMapping("/{id}/status")
    QuestionnaireResponseDTO updateStatus(@PathVariable("id") Long id);

    @Operation(
            summary = "Get all questionnaires",
            description = "Возвращает список всех анкет в системе."
    )
    @GetMapping("/all")
    List<QuestionnaireResponseDTO> getAll();

    @Operation(
            summary = "Get my questionnaires",
            description = "Возвращает список анкет, созданных текущим пользователем."
    )
    @GetMapping("/mine")
    List<QuestionnaireResponseDTO> getMine();

    @Operation(
            summary = "Get questionnaire by ID",
            description = "Возвращает анкету по её идентификатору."
    )
    @GetMapping("/{id}")
    QuestionnaireResponseDTO getById(@PathVariable Long id);

    @Operation(
            summary = "Create new questionnaire",
            description = "Создаёт новую анкету на основе переданных данных."
    )
    @PostMapping
    QuestionnaireResponseDTO create(@RequestBody QuestionnaireRequestDTO dto);

    @Operation(
            summary = "Update questionnaire by ID",
            description = "Обновляет существующую анкету по идентификатору на основе переданных данных."
    )
    @PutMapping("/{id}")
    QuestionnaireResponseDTO update(@PathVariable Long id, @RequestBody QuestionnaireRequestDTO dto);

    @Operation(
            summary = "Delete questionnaire by ID",
            description = "Удаляет анкету по её идентификатору."
    )
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
