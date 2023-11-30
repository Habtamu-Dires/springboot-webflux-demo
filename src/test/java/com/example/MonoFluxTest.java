package com.example;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.IntStream;

public class MonoFluxTest {

    @Test
    public void testMono() {
        Mono<?> monoString = Mono.just("javaHab")
                .then(Mono.error(new RuntimeException("Error has occured")))
                .log();

        monoString.subscribe(
                System.out::println,
                e -> System.out.println(e.getMessage()));
    }
    @Test
    public void testFlux(){
        Flux<String> fluxString = Flux.just("spring", "spring boot", "Hibernate", "Microservices")
                .concatWithValues("AWS")
                .concatWith(Flux.error(new RuntimeException("Exception occur in Flux")))
                .log();

        fluxString.subscribe(System.out::println, e -> System.out.println(e));
    }

}
