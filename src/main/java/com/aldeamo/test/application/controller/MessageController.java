package com.aldeamo.test.application.controller;


import com.aldeamo.test.application.services.abstract_services.IMessageService;
import com.aldeamo.test.domain.model.request.MessageRequest;
import com.aldeamo.test.domain.model.response.MessageResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/message")

public class MessageController {
    private final IMessageService messageService;

    @Operation(summary = "Get all messages")
    @GetMapping
    public Set<MessageResponse> getTypeMaterials() {
        return messageService.findAllMessages();
    }

    @Operation(summary = "Post message")
    @PostMapping
    public ResponseEntity<MessageResponse> saveMaterial(@RequestBody MessageRequest request) throws BadRequestException {
        return ResponseEntity.ok(messageService.saveMessage(request));
    }
}
