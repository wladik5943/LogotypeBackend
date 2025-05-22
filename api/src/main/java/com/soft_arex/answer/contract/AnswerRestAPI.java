package com.soft_arex.answer.contract;

import com.soft_arex.answer.model.AnswerResponse;
import com.soft_arex.answer.model.SubmitAnswerRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Tag(name = "answer management system",description = "взаимодействие с ответами на анкету")
@RequestMapping("/answer")
public interface AnswerRestAPI {

    @Operation(summary = "add answer in db", description = "добавление отвена на анкету")
    @PostMapping
    void saveAnswer(@RequestBody SubmitAnswerRequest request);
    @Operation(summary = "get list answers", description = "получение всех ответов на определенный тест")
    @GetMapping("get/{testId}")
    Page<AnswerResponse> getAnswersForTest(
            @PathVariable Long testId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    );
}
