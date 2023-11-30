package com.example.handler;

import com.example.dao.CustomerDao;
import com.example.dto.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CustomerStreamHandler {

    private final CustomerDao dao;

    public Mono<ServerResponse> getCustomers(ServerRequest request){
        Flux<Customer> customerStream = dao.getCustomersStream();
        return ServerResponse.ok().body(customerStream, Customer.class);
    }
}
