package com.nishbs.cas.dto.file;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileRequest {
    private Long id;
    private String fileName;
    private Long customerId;
}
