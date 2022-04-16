package com.nishbs.cas.dto.file;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileResponse {
    private Long fileId;
    private String fileName;
    private Instant createdDate;
    private Long customerId;
}
