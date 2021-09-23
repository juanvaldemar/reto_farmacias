package com.valdemar.demo;

import com.valdemar.demo.model.services.MateService;
import io.r2dbc.spi.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.connectionfactory.init.DatabasePopulatorUtils;
import org.springframework.data.r2dbc.connectionfactory.init.ResourceDatabasePopulator;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@SpringBootApplication
public class Reto01Application implements CommandLineRunner{
	@Autowired
	private MateService mateService;

	@Autowired
	ConnectionFactory connectionFactory;

	//@Autowired
	//private ReactiveMongoTemplate mongoTemplate;
	private static final Logger log = LoggerFactory.getLogger(Reto01Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Reto01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		int a = 10;
		int b = 37;
		int z = 0;
		int w = 0;
		if (a == b) {
			z = 3;
		} else if (a > b) {
			z = 6;
		}
		w = 10 * z;

		System.out.println(w);


		//mongoTemplate.dropCollection("prostituta").subscribe();
/*
 		Flux.just(new Mate("Vanessa",true,130.00),
				new Mate("Miluska",true,230.00),
				new Mate("Sofia",true,500.00),
				new Mate("Katherine",true,90.00))
		.flatMap(mateService::save)
		.subscribe(prostituta -> log.info("insert: "+prostituta.getPseudoNombre()));
		*/

		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(new ClassPathResource("schema.sql"));
		DatabasePopulatorUtils.execute(databasePopulator, connectionFactory).block();

	}

	@Bean
	public WebFluxConfigurer corsConfigurer() {
		return new WebFluxConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}


}
