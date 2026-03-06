package com.aldeamo.test.application.services.services;

import com.aldeamo.test.application.repository.MessageRepository;
import com.aldeamo.test.application.services.abstract_services.IMessageService;
import com.aldeamo.test.domain.entity.Message;
import com.aldeamo.test.domain.model.response.MessageResponse;
import com.aldeamo.test.domain.model.response.OriginLineResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageService implements IMessageService {

    private final MessageRepository messageRepository;

    @Override
    public Set<MessageResponse> findAllMessages() {
        log.info("Find all messages Init Service");
        Set<MessageResponse> messageResponses = messageRepository.findAll()
                .stream()
                .map(this::entityToResponse)
                .collect(Collectors.toSet());
        log.info("Find all messages Finish Service");
        return messageResponses;
    }

    private MessageResponse entityToResponse(Message message) {
        MessageResponse response = new MessageResponse();
        BeanUtils.copyProperties(message, response);
        if (message.getOrigin() != null) {
            OriginLineResponse originLineResponse = new OriginLineResponse();
            BeanUtils.copyProperties(message.getOrigin(), originLineResponse);
        }
        return response;
    }
}
