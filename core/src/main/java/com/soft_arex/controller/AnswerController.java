package com.soft_arex.controller;

import com.soft_arex.answer.contract.AnswerRestAPI;
import com.soft_arex.answer.model.AnswerResponse;
import com.soft_arex.answer.model.SubmitAnswerRequest;
import com.soft_arex.service.answer.AnswerService;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
public class AnswerController implements AnswerRestAPI {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    private final AnswerService answerService;


    public void saveAnswer(@RequestBody SubmitAnswerRequest request) {
        answerService.submit(request);
    }


    public Page<AnswerResponse> getAnswersForTest(
            @PathVariable Long testId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        return answerService.getAnswersByTestId(testId, page, size);
    }
}
