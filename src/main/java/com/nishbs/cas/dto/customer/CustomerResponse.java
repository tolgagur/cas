package com.nishbs.cas.dto.customer;

import com.nishbs.cas.model.file.File;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {
    private Long id;
    private String customerName;
    private Long userId;
    private String info;
    private Instant createdDate;
    private List<File> files;
}
