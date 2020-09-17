package com.fernandofuentesfullstack.demoreactor;

import operator.Create;
import person.Person;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

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

	public void fluxToMono() {
		List<Person> personList = new ArrayList<>();
		personList.add(Person.builder().id(1).name("Fernando-1").age(29).build());
		personList.add(Person.builder().id(2).name("Fernando-2").age(30).build());
		personList.add(Person.builder().id(3).name("Fernando-3").age(31).build());

		Flux<Person> fluxPerson = Flux.fromIterable(personList);
		fluxPerson.collectList().subscribe( list -> log.info(list.toString()) );
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoReactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// reactor();
		// rxjava2();
		// fluxToMono();
		Create app = new Create();
		// app.range();
		app.repeat();
	}
}
