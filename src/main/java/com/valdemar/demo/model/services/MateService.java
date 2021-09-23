package com.valdemar.demo.model.services;

import com.valdemar.demo.model.entity.Mate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@Service
public interface MateService {
    Mono<Mate> save(Mate mate);
    Flux<Mate> saveAll(Flux<Mate>prostituta);

    Flux <Mate> findAll();

    Mono<Mate> findById(String request);



}
