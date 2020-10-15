package com.example.shopdemo.service;

import com.example.shopdemo.repository.CustomerRepository;
import com.example.shopdemo.entity.Customer;

import javax.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Customer create(Customer customer, String rawPassword) {
        String encodedPassword = passwordEncoder.encode(rawPassword);
        customer.setPassword(encodedPassword);
        return customerRepository.save(customer);
    }
}