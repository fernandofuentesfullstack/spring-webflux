package operator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import person.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Conditional {

    private static final Logger log = LoggerFactory.getLogger(Conditional.class);

    public void defaultIfEmpty() {
        // Flux.empty()
        Mono.justOrEmpty(null)
                .defaultIfEmpty(new Person(0, "DEFAULT", 99))
                .subscribe(( x -> log.info(x.toString())));
    }

    public void takeUntil() {
        List<Person> personList1 = new ArrayList<>();
        personList1.add(Person.builder().id(1).name("Fernando-1").age(27).build());
        personList1.add(Person.builder().id(2).name("Fernando-2").age(28).build());
        personList1.add(Person.builder().id(3).name("Fernando-3").age(29).build());

        Flux.fromIterable(personList1)
                .takeUntil( p -> p.getAge() > 26)
                .subscribe(x -> log.info(x.toString()));
    }

    public void timeout() throws InterruptedException {
        List<Person> personList1 = new ArrayList<>();
        personList1.add(Person.builder().id(1).name("Fernando-1").age(27).build());
        personList1.add(Person.builder().id(2).name("Fernando-2").age(28).build());
        personList1.add(Person.builder().id(3).name("Fernando-3").age(29).build());

        Flux.fromIterable(personList1)
                .delayElements(Duration.ofSeconds(1))
                .timeout(Duration.ofSeconds(2))
                .subscribe(x -> log.info(x.toString()));

        Thread.sleep(10000);
    }

}
