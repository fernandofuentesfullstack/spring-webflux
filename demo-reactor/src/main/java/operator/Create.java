package operator;

import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import person.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Create {

    private static final Logger log = LoggerFactory.getLogger(Create.class);

    public void justFrom() {
        Mono.just(new Person(1, "Fernando", 30));
        // Flux.fromIterable(collection);
        // Observable.just(item);
    }
    public void empty() {
        Mono.empty();
        Flux.empty();
        Observable.empty();
    }
    public void range() {
        Flux.range(0, 3)
                .doOnNext(i -> log.info("i : " + i))
                .subscribe();
    }
    public void repeat() {
        List<Person> personList = new ArrayList<>();
        personList.add(Person.builder().id(1).name("HELLO WORLD - Fernando-1").age(29).build());
        personList.add(Person.builder().id(2).name("Fernando-2").age(30).build());
        personList.add(Person.builder().id(3).name("Fernando-3").age(31).build());

        Flux.fromIterable(personList)
                .repeat(3)
                .subscribe( person -> log.info(person.toString()) );

        Mono.just(Person.builder().id(5).name("Fernando One Person").age(50))
                .repeat(2)
                .subscribe( p -> log.info(p.toString()));
    }

}
