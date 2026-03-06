package com.aldeamo.test.application.controller;


import com.aldeamo.test.application.services.abstract_services.IMessageService;
import com.aldeamo.test.domain.model.response.MessageResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/message")

public class MessageController {
    private final IMessageService messageService;

    @Operation(summary = "Get cities name")
    @GetMapping("/name")
    public Set<MessageResponse> getTypeMaterials() {
        return messageService.findAllMessages();
    }
}
