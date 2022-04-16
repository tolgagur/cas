package com.nishbs.cas.repository.customer;

import com.nishbs.cas.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findByCustomerName(String name);

    void deleteCustomersByCustomerName(String name);
}
