package com.aldeamo.test.application.services.services;

import com.aldeamo.test.application.repository.MessageRepository;
import com.aldeamo.test.application.repository.OriginLineRepository;
import com.aldeamo.test.application.services.abstract_services.IMessageService;
import com.aldeamo.test.domain.entity.Message;
import com.aldeamo.test.domain.entity.OriginLine;
import com.aldeamo.test.domain.model.request.MessageRequest;
import com.aldeamo.test.domain.model.response.MessageResponse;
import com.aldeamo.test.domain.model.response.OriginLineResponse;
import com.aldeamo.test.util.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageService implements IMessageService {

    private final MessageRepository messageRepository;
    private final OriginLineRepository originLineRepository;

    @Override
    public Set<MessageResponse> findAllMessages() {
        log.info("Find all messages Init Service");
        Set<MessageResponse> messageResponses = messageRepository.findAll()
                .stream()
                .map(this::entityToResponse)
                .collect(Collectors.toSet());
        log.info("Find all messages: {}", messageResponses);
        log.info("Find all messages Finish Service");
        return messageResponses;
    }

    @Override
    @Transactional
    public MessageResponse saveMessage(MessageRequest messageRequest) throws BadRequestException {
        log.info("Save Message Init Service");
        Long originLineId = messageRequest.getOrigin();
        OriginLine originLine = originLineRepository.findById(originLineId)
                .orElseThrow(() -> new NotFoundException("Origin line with id " + originLineId + " not found"));

        Message message = Message.builder()
                .destination(messageRequest.getDestination())
                .messageType(messageRequest.getMessageType())
                .content(messageRequest.getContent())
                .createdAt(LocalDateTime.now())
                .origin(originLine)
                .build();
        log.info("Save material DB Service");
        messageRepository.saveAndFlush(message);
        log.info("Save material Finish Service");
        return entityToResponse(message);
    }

    private MessageResponse entityToResponse(Message message) {
        MessageResponse response = new MessageResponse();
        log.info("Entity to response message={}", message);
        BeanUtils.copyProperties(message, response);
        if (message.getOrigin() != null) {
            OriginLineResponse originLineResponse = new OriginLineResponse();
            BeanUtils.copyProperties(message.getOrigin(), originLineResponse);
            response.setOrigin(originLineResponse);
            log.info("Entity to response originLineResponse={}", originLineResponse);
        }
        log.info("Entity to response MessageResponse={}", response);
        return response;
    }
}
