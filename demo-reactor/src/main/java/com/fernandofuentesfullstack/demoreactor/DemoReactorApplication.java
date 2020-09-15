package com.fernandofuentesfullstack.demoreactor;

import Person.Person;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class DemoReactorApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

	public void reactor() {
		Mono.just(new Person(1, "Fernando Fuentes", 30))
				.subscribe(p -> log.info("[Reactor] Person: " + p ));
	}

	public void rxjava2() {
		Observable.just(new Person(1, "Fernando Fuentes", 30))
				.subscribe(p -> log.info("[RxJava2] Person: " + p ));
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoReactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		reactor();
		rxjava2();
	}
}
