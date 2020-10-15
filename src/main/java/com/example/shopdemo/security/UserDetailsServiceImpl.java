package com.example.shopdemo.security;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CustomerDetailsRepository repository;

    @Override
    public UserDetails loadUserByUsername (String email)
        throws UsernameNotFoundException {
            if (StringUtils.isEmpty(email)) {
                throw new UsernameNotFoundException("email(ID) is empty");
            }
            CustomerDetails customerDetails = repository.findByEmail(email);
            if (customerDetails == null) {
                System.out.println(customerDetails);
                throw new UsernameNotFoundException("Not found email(ID) : " + email);
            }
            return customerDetails;
        }  
}