package com.aldeamo.test.domain.entity;

import com.aldeamo.test.util.enums.MessageType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer destination;

    @Enumerated(EnumType.STRING)
    private MessageType messageType;
    private String content;

    @ManyToOne
    @JoinColumn(name = "origin_id")
    private OriginLine origin;
}