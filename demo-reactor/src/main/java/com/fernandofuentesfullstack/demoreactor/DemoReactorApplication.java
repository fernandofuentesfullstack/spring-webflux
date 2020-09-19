package com.fernandofuentesfullstack.demoreactor;

import operator.*;
import operator.Error;
import person.Person;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.management.PersistentMBean;
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

		// Create app = new Create();
		// app.range();
		// app.repeat();

		// Transformation app = new Transformation();
		// System.out.println("Map");
		// app.map();
		// System.out.println("FlatMap");
		// app.flatMap();
		// System.out.println("GroupBy");
		// app.groupBy();

		// Filter app = new Filter();
		// System.out.println("Filter");
		// app.filter();
		// System.out.println("Distinct");
		// app.distinct();
		// System.out.println("Take");
		// app.take();
		// System.out.println("TakeLast");
		// app.takeLast();
		// System.out.println("Skip");
		// app.skip();
		// System.out.println("SkipLast");
		// app.skipLast();

		// Combination app = new Combination();
		// System.out.println("Merge");
		// app.merge();
		// System.out.println("Zip");
		// app.zip();
		// System.out.println("ZipWith");
		// app.zipWith();

		// Error app = new Error();
		// System.out.println("Retry");
		// app.retry();
		// System.out.println("OnErrorReturn");
		// app.errorReturn();
		// System.out.println("OnErrorResume");
		// app.errorResume();
		// System.out.println("OnErrorMap");
		// app.errorMap();

		// Conditional app = new Conditional();
		// System.out.println("DefaultIfEmpty");
		// app.defaultIfEmpty();
		// System.out.println("TakeUntil");
		// app.takeUntil();
		// System.out.println("Timeout");
		// app.timeout();

		Mathematical app = new Mathematical();
		System.out.println("Average");
		app.average();
		System.out.println("Count");
		app.count();
		System.out.println("Min");
		app.min();
		System.out.println("Sum");
		app.sum();
		System.out.println("Summarizing");
		app.summarizingInt();

	}
}
