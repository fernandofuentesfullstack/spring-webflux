package operator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import person.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Error {

    private static final Logger log = LoggerFactory.getLogger(Error.class);

    public void retry() {
        List<Person> personList1 = new ArrayList<>();
        personList1.add(Person.builder().id(1).name("Fernando-1").age(29).build());
        personList1.add(Person.builder().id(2).name("Fernando-2").age(30).build());
        personList1.add(Person.builder().id(3).name("Fernando-3").age(31).build());

        Flux.fromIterable(personList1)
                .concatWith(Flux.error(new RuntimeException("An Error")))
                .retry(1)
                .doOnNext(x -> log.info(x.toString()))
                .subscribe();
    }

    public void errorReturn() {
        List<Person> personList1 = new ArrayList<>();
        personList1.add(Person.builder().id(1).name("Fernando-1").age(29).build());
        personList1.add(Person.builder().id(2).name("Fernando-2").age(30).build());
        personList1.add(Person.builder().id(3).name("Fernando-3").age(31).build());

        Flux.fromIterable(personList1)
                .concatWith(Flux.error(new RuntimeException("An Error")))
                .onErrorReturn(new Person(0, "Person error", 99))
                .subscribe(x -> log.info(x.toString()));
    }

    public void errorResume() {
        List<Person> personList1 = new ArrayList<>();
        personList1.add(Person.builder().id(1).name("Fernando-1").age(29).build());
        personList1.add(Person.builder().id(2).name("Fernando-2").age(30).build());
        personList1.add(Person.builder().id(3).name("Fernando-3").age(31).build());

        Flux.fromIterable(personList1)
                .concatWith(Flux.error(new RuntimeException("An Error")))
                .onErrorResume( e -> Mono.just(new Person(0, "Person error", 99)))
                .subscribe(x -> log.info(x.toString()));
    }

    public void errorMap() {
        List<Person> personList1 = new ArrayList<>();
        personList1.add(Person.builder().id(1).name("Fernando-1").age(29).build());
        personList1.add(Person.builder().id(2).name("Fernando-2").age(30).build());
        personList1.add(Person.builder().id(3).name("Fernando-3").age(31).build());

        Flux.fromIterable(personList1)
                .concatWith(Flux.error(new RuntimeException("An Error")))
                .onErrorMap( e -> new InterruptedException(e.getMessage()))
                .subscribe(x -> log.info(x.toString()));
    }

}
