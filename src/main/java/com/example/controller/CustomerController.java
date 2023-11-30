package com.example.controller;

import com.example.dto.Customer;
import com.example.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @GetMapping
    public List<Customer> getAllCustomer(){
        return service.loadAllCustomers();
    }

    @GetMapping("/stream")
    public Flux<Customer> getAllCustomerStream(){
        return service.loadAllCustomersStream();
    }
}
