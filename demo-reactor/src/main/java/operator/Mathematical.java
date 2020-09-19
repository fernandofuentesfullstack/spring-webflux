package operator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import person.Person;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Mathematical {

    private static final Logger log = LoggerFactory.getLogger(Mathematical.class);

    public void average() {
        List<Person> personList1 = new ArrayList<>();
        personList1.add(Person.builder().id(1).name("Fernando-1").age(20).build());
        personList1.add(Person.builder().id(2).name("Fernando-2").age(25).build());
        personList1.add(Person.builder().id(3).name("Fernando-3").age(30).build());

        Flux.fromIterable(personList1)
                .collect(Collectors.averagingInt(Person::getAge))
                .subscribe(x -> log.info("Average: " + x.toString()));
    }

    public void count() {
        List<Person> personList1 = new ArrayList<>();
        personList1.add(Person.builder().id(1).name("Fernando-1").age(20).build());
        personList1.add(Person.builder().id(2).name("Fernando-2").age(25).build());
        personList1.add(Person.builder().id(3).name("Fernando-3").age(30).build());

        Flux.fromIterable(personList1)
                .count()
                .subscribe(x -> log.info("Amount: " + x.toString()));
    }

    public void min() {
        List<Person> personList1 = new ArrayList<>();
        personList1.add(Person.builder().id(1).name("Fernando-1").age(20).build());
        personList1.add(Person.builder().id(2).name("Fernando-2").age(25).build());
        personList1.add(Person.builder().id(3).name("Fernando-3").age(30).build());

        Flux.fromIterable(personList1)
                .collect(Collectors.minBy(Comparator.comparing(Person::getAge)))
                .subscribe(x -> log.info("Min: " + x.get().toString()));
    }

    public void sum() {
        List<Person> personList1 = new ArrayList<>();
        personList1.add(Person.builder().id(1).name("Fernando-1").age(20).build());
        personList1.add(Person.builder().id(2).name("Fernando-2").age(25).build());
        personList1.add(Person.builder().id(3).name("Fernando-3").age(30).build());

        Flux.fromIterable(personList1)
                .collect(Collectors.summingInt(Person::getAge))
                .subscribe(x -> log.info("Sum: " + x.toString()));
    }

    public void summarizingInt() {
        List<Person> personList1 = new ArrayList<>();
        personList1.add(Person.builder().id(1).name("Fernando-1").age(20).build());
        personList1.add(Person.builder().id(2).name("Fernando-2").age(25).build());
        personList1.add(Person.builder().id(3).name("Fernando-3").age(30).build());

        Flux.fromIterable(personList1)
                .collect(Collectors.summarizingInt(Person::getAge))
                .subscribe(x -> log.info("Resume: " + x.toString()));
    }

}
