package com.aldeamo.test.application.services.abstract_services;

import com.aldeamo.test.domain.model.request.MessageRequest;
import com.aldeamo.test.domain.model.response.MessageResponse;
import org.apache.coyote.BadRequestException;

import java.util.Set;

public interface IMessageService {
    Set<MessageResponse> findAllMessages();
    MessageResponse saveMessage(MessageRequest messageRequest) throws BadRequestException;
}
