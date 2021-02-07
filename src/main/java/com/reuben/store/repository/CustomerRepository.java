package com.reuben.store.repository;

import com.reuben.store.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT C from Customer C WHERE C.email_id = ?1")
    Customer fetchCustomerByEmail(String username);

}
