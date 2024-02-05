package com.example.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.entity.Customers;
import com.example.ecommerce.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customers> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customers> getCustomerById(Long customerId) {
        return customerRepository.findById(customerId);
    }

    public Customers createCustomer(Customers customer) {
        return customerRepository.save(customer);
    }

    public Customers updateCustomer(Long customerId, Customers updatedCustomer) {
        Optional<Customers> existingCustomer = customerRepository.findById(customerId);
        existingCustomer.ifPresent(customer -> {
    
            customer.setFirstName(updatedCustomer.getFirstName());
            customer.setLastName(updatedCustomer.getLastName());
            customer.setEmail(updatedCustomer.getEmail());
            customer.setPhoneNumber(updatedCustomer.getPhoneNumber());
            customer.setAddress(updatedCustomer.getAddress());

            // Save the updated customer
            customerRepository.save(customer);
        });

        return existingCustomer.orElse(null);
    }

    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}

