package com.aldeamo.test.domain.model.response;

import com.aldeamo.test.domain.entity.OriginLine;
import com.aldeamo.test.util.enums.MessageType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OriginLineResponse {
    private Long id;
    private Integer lineNumber;
}
