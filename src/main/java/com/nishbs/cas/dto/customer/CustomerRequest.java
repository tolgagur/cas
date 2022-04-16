package com.nishbs.cas.dto.customer;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
    private Long id;
    private String customerName;
    private String info;
}
