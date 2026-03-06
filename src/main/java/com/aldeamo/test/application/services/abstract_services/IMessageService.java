package com.aldeamo.test.application.services.abstract_services;

import com.aldeamo.test.domain.model.response.MessageResponse;

import java.util.Set;

public interface IMessageService {
    Set<MessageResponse> findAllMessages();
}
