package com.reuben.store.config;

import com.reuben.store.model.Customer;
import com.reuben.store.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.fetchCustomerByEmail(username);
        if(customer == null) {
            throw new UsernameNotFoundException("Invalid Email ID");
        }
        return new org.springframework.security.core.userdetails.User(customer.getEmail_id(), customer.getPassword(),customer.getAuthorities());
    }
}
