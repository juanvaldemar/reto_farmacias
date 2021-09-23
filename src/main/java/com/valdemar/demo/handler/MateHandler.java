package com.valdemar.demo.handler;

import com.valdemar.demo.model.entity.Mate;
import com.valdemar.demo.model.services.MateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class MateHandler {
    private static final Logger log = LoggerFactory.getLogger(MateHandler.class);

    @Autowired
    private MateService mateService;

    //Método para listar los números enviados para sumar
    public Mono<ServerResponse> listar(ServerRequest request){

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_PROBLEM_JSON_UTF8)
                .body(mateService.findAll(), Mate.class);
    }

    //Método para sumar 2 números
    public Mono<ServerResponse> sumar(ServerRequest request) {
        Mono<Mate> sumarFlux = request.bodyToMono(Mate.class);

        return sumarFlux
                .map(data->data)
                .flatMap(p->{
                    return mateService.save(p);
                })
                .flatMap(flat -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue("La suma es: "+flat.getPrimerNumero() + flat.getSegundoNumero())));

    }



}
