package com.nishbs.cas.repository.file;


import com.nishbs.cas.model.customer.Customer;
import com.nishbs.cas.model.file.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<File,Long> {
    List<File> findByFileName(String name);

    void deleteCustomersByFileName(String name);

    List<File> findByCustomerId(Long customerId);
}
