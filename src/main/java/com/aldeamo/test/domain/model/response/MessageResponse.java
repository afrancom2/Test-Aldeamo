package com.aldeamo.test.domain.model.response;

import com.aldeamo.test.domain.entity.OriginLine;
import com.aldeamo.test.util.enums.MessageType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponse {
    private Long id;
    private Integer destination;
    private MessageType messageType;
    private String content;
    private OriginLineResponse origin;
}
