package operator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import person.Person;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    private static final Logger log = LoggerFactory.getLogger(Combination.class);

    public void merge() {
        List<Person> personList1 = new ArrayList<>();
        personList1.add(Person.builder().id(1).name("Fernando-1").age(29).build());
        personList1.add(Person.builder().id(2).name("Fernando-2").age(30).build());
        personList1.add(Person.builder().id(3).name("Fernando-3").age(31).build());

        List<Person> personList2 = new ArrayList<>();
        personList2.add(Person.builder().id(1).name("Fernando-4").age(35).build());
        personList2.add(Person.builder().id(2).name("Fernando-5").age(52).build());
        personList2.add(Person.builder().id(3).name("Fernando-6").age(29).build());

        Flux<Person> personFlux1 = Flux.fromIterable(personList1);
        Flux<Person> personFlux2 = Flux.fromIterable(personList2);

        Flux.merge(personFlux1, personFlux2)
                .filter( p -> p.getAge() > 29)
                .subscribe( p -> log.info(p.toString()));
    }

    public void zip() {
        List<Person> personList1 = new ArrayList<>();
        personList1.add(Person.builder().id(1).name("Fernando-1").age(29).build());
        personList1.add(Person.builder().id(2).name("Fernando-2").age(30).build());
        personList1.add(Person.builder().id(3).name("Fernando-3").age(31).build());

        List<Person> personList2 = new ArrayList<>();
        personList2.add(Person.builder().id(1).name("Fernando-4").age(35).build());
        personList2.add(Person.builder().id(2).name("Fernando-5").age(52).build());
        personList2.add(Person.builder().id(3).name("Fernando-6").age(29).build());

        Flux<Person> personFlux1 = Flux.fromIterable(personList1);
        Flux<Person> personFlux2 = Flux.fromIterable(personList2);

        Flux.zip(personFlux1, personFlux2, (p1, p2) -> String.format("Flux1: %s, Flux2 %s", p1, p2))
                .subscribe( p -> log.info(p.toString()));
    }

    public void zipWith() {
        List<Person> personList1 = new ArrayList<>();
        personList1.add(Person.builder().id(1).name("Fernando-1").age(29).build());
        personList1.add(Person.builder().id(2).name("Fernando-2").age(30).build());
        personList1.add(Person.builder().id(3).name("Fernando-3").age(31).build());

        List<Person> personList2 = new ArrayList<>();
        personList2.add(Person.builder().id(1).name("Fernando-4").age(35).build());
        personList2.add(Person.builder().id(2).name("Fernando-5").age(52).build());
        personList2.add(Person.builder().id(3).name("Fernando-6").age(29).build());

        Flux<Person> personFlux1 = Flux.fromIterable(personList1);
        Flux<Person> personFlux2 = Flux.fromIterable(personList2);

        personFlux1.zipWith(personFlux2, (p1, p2) -> String.format("Flux1: %s, Flux2 %s", p1, p2))
                .subscribe( p -> log.info(p.toString()));
    }
}
