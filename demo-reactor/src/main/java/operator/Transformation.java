package operator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import person.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Transformation {

    private static final Logger log = LoggerFactory.getLogger(Transformation.class);

    public void map() {
        List<Person> personList = new ArrayList<>();
        personList.add(Person.builder().id(1).name("Fernando-1").age(29).build());
        personList.add(Person.builder().id(2).name("Fernando-2").age(30).build());
        personList.add(Person.builder().id(3).name("Fernando-3").age(31).build());

        Flux.fromIterable(personList)
                .map( p -> {
                    p.setAge(p.getAge() + 100);
                    return p;
                })
                .subscribe( p -> log.info(p.toString()));

        Flux<Integer> flux = Flux.range(0,10);
        Flux<Integer> fluxMap = flux.map( n -> n + 10);
        fluxMap.subscribe( n -> log.info("N = " + n));
    }
    public void flatMap() {
        List<Person> personList = new ArrayList<>();
        personList.add(Person.builder().id(1).name("Fernando-1").age(29).build());
        personList.add(Person.builder().id(2).name("Fernando-2").age(30).build());
        personList.add(Person.builder().id(3).name("Fernando-3").age(31).build());

        Flux.fromIterable(personList)
                .flatMap( person -> {
                    person.setAge(person.getAge() + 100);
                    return Mono.just(person);
                })
                .subscribe( p -> log.info(p.toString()));
    }
    public void groupBy() {
        List<Person> personList = new ArrayList<>();
        personList.add(Person.builder().id(1).name("Fernando-1").age(31).build());
        personList.add(Person.builder().id(2).name("Fernando-2").age(30).build());
        personList.add(Person.builder().id(3).name("Fernando-3").age(29).build());
        personList.add(Person.builder().id(4).name("Fernando-4").age(30).build());

        Flux.fromIterable(personList)
                // .groupBy( person -> person.getId())
                .groupBy( Person::getAge)
                .flatMap( idFlux -> idFlux.collectList() )
                .subscribe( p -> log.info(p.toString()));
    }

}
