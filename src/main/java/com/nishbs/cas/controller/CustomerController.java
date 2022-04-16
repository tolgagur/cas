package com.nishbs.cas.controller;

import com.nishbs.cas.dto.customer.CustomerRequest;
import com.nishbs.cas.dto.customer.CustomerResponse;
import com.nishbs.cas.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerRequest customerRequest) {
        CustomerResponse response = customerService.save(customerRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(value = "all")
    public List<CustomerResponse> inquireAllCustomer() {
        return customerService.inquireAllCustomer();
    }

    @DeleteMapping(value = "deleteById/{id}")
    public ResponseEntity<Boolean> deleteCustomerById(@PathVariable Long id) {
        Boolean response = customerService.deleteCustomer(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "deleteByName/{name}")
    public ResponseEntity<Boolean> deleteCustomerByName(@PathVariable String name) {
        Boolean response = customerService.deleteCustomer(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(value = "update/{id}")
    public ResponseEntity<CustomerResponse> deleteCustomerByName(@RequestBody CustomerRequest request) {
        CustomerResponse response = customerService.updateCustomer(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
