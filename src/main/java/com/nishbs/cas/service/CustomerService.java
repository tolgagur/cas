package com.nishbs.cas.service;

import com.nishbs.cas.dto.customer.CustomerRequest;
import com.nishbs.cas.dto.customer.CustomerResponse;
import com.nishbs.cas.model.Mapper;
import com.nishbs.cas.model.customer.Customer;
import com.nishbs.cas.model.user.User;
import com.nishbs.cas.repository.customer.CustomerRepository;
import com.nishbs.cas.repository.file.FileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class CustomerService {

    private AuthService authService;
    private CustomerRepository customerRepository;
    private FileRepository fileRepository;


    public CustomerResponse save(CustomerRequest customerRequest) {
        User user = authService.getCurrentUser();
        Customer customer = new Customer();
        customer.setCustomerName(customerRequest.getCustomerName());
        customer.setCreatedDate(Instant.now());
        customer.setInfo(customerRequest.getInfo());
        customer.setCreatedUser(user.getUserId());
        customer = customerRepository.save(customer);
        return Mapper.mapper.map(customer, CustomerResponse.class);
    }

    public List<CustomerResponse> inquireAllCustomer() {
        List<CustomerResponse> response = new ArrayList<>();
        for (Customer c : customerRepository.findAll()) {
            CustomerResponse r;
            r = Mapper.mapper.map(c, CustomerResponse.class);
            if (Objects.isNull(r))
                continue;
            r.setFiles(fileRepository.findByCustomerId(c.getId()));
            response.add(r);
        }

        return response;
    }

    public boolean deleteCustomer(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (!customer.isPresent())
            return false;

        customerRepository.deleteById(id);
        return true;
    }

    public boolean deleteCustomer(String name) {
        List<Customer> customer = customerRepository.findByCustomerName(name);
        if (customer.isEmpty())
            return false;

        customerRepository.deleteCustomersByCustomerName(name);
        return true;
    }

    public CustomerResponse updateCustomer(CustomerRequest request) {
        Optional<Customer> customerOpt = customerRepository.findById(request.getId());
        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            customer.setCustomerName(request.getCustomerName());
            customer.setInfo(request.getInfo());
            customer = customerRepository.save(customer);
            return Mapper.mapper.map(customer, CustomerResponse.class);
        }
        throw new IllegalStateException("Customer not found");
    }
}
