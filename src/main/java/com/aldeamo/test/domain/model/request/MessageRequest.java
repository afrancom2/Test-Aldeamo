package com.aldeamo.test.domain.model.request;

import com.aldeamo.test.domain.entity.OriginLine;
import com.aldeamo.test.util.enums.MessageType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MessageRequest implements Serializable {
    @NotBlank(message = "Content is required")
    @Size(min = 10, max = 100, message = "Content must be between 10 and 100 characters")
    private String content;

    @NotBlank(message = "Destination is required")
    @Size(max = 100, message = "Destination must not exceed 100 characters")
    @Positive(message = "Price must be greater than 0")
    private Integer destination;

    @NotNull(message = "MessageType is required")
    private MessageType messageType;

    @NotNull(message = "Origin Line ID is required")
    private Long origin;

}
