package operator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import person.Person;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Filter {

    private static final Logger log = LoggerFactory.getLogger(Filter.class);

    public void filter() {
        List<Person> personList = new ArrayList<>();
        personList.add(Person.builder().id(1).name("Fernando-1").age(29).build());
        personList.add(Person.builder().id(2).name("Fernando-2").age(30).build());
        personList.add(Person.builder().id(3).name("Fernando-3").age(31).build());

        Flux.fromIterable(personList)
                .filter( p -> p.getAge() > 29)
                .subscribe( p -> log.info(p.toString()));
    }

    public void distinct() {
        List<Person> personList = new ArrayList<>();
        personList.add(Person.builder().id(1).name("Fernando-1").age(29).build());
        personList.add(Person.builder().id(2).name("Fernando-2").age(30).build());
        personList.add(Person.builder().id(2).name("Fernando-2").age(30).build());
        personList.add(Person.builder().id(3).name("Fernando-3").age(31).build());
        personList.add(Person.builder().id(3).name("Fernando-4").age(30).build());

        Flux.fromIterable(personList)
                .distinct()
                .subscribe( p -> log.info(p.toString()));
    }

    public void take() {
        List<Person> personList = new ArrayList<>();
        personList.add(Person.builder().id(1).name("Fernando-1").age(29).build());
        personList.add(Person.builder().id(2).name("Fernando-2").age(30).build());
        personList.add(Person.builder().id(2).name("Fernando-2").age(30).build());
        personList.add(Person.builder().id(3).name("Fernando-3").age(31).build());
        personList.add(Person.builder().id(3).name("Fernando-4").age(30).build());

        Flux.fromIterable(personList)
                .take(3)
                .subscribe( p -> log.info(p.toString()));
    }

    public void takeLast() {
        List<Person> personList = new ArrayList<>();
        personList.add(Person.builder().id(1).name("Fernando-1").age(29).build());
        personList.add(Person.builder().id(2).name("Fernando-2").age(30).build());
        personList.add(Person.builder().id(2).name("Fernando-2").age(30).build());
        personList.add(Person.builder().id(3).name("Fernando-3").age(31).build());
        personList.add(Person.builder().id(3).name("Fernando-4").age(30).build());

        Flux.fromIterable(personList)
                .takeLast(3)
                .subscribe( p -> log.info(p.toString()));
    }

    public void skip() {
        List<Person> personList = new ArrayList<>();
        personList.add(Person.builder().id(1).name("Fernando-1").age(29).build());
        personList.add(Person.builder().id(2).name("Fernando-2").age(30).build());
        personList.add(Person.builder().id(2).name("Fernando-2").age(30).build());
        personList.add(Person.builder().id(3).name("Fernando-3").age(31).build());
        personList.add(Person.builder().id(3).name("Fernando-4").age(30).build());

        Flux.fromIterable(personList)
                .skip(2)
                .subscribe( p -> log.info(p.toString()));
    }

    public void skipLast() {
        List<Person> personList = new ArrayList<>();
        personList.add(Person.builder().id(1).name("Fernando-1").age(29).build());
        personList.add(Person.builder().id(2).name("Fernando-2").age(30).build());
        personList.add(Person.builder().id(2).name("Fernando-2").age(30).build());
        personList.add(Person.builder().id(3).name("Fernando-3").age(31).build());
        personList.add(Person.builder().id(3).name("Fernando-4").age(30).build());

        Flux.fromIterable(personList)
                .skipLast(2)
                .subscribe( p -> log.info(p.toString()));
    }

}
