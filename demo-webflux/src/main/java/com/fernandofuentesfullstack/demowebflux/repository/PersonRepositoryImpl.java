package com.fernandofuentesfullstack.demowebflux.repository;

import com.fernandofuentesfullstack.demowebflux.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private static final Logger log = LoggerFactory.getLogger(PersonRepositoryImpl.class);

    @Override
    public Flux<Person> list() {
        List<Person> personList = new ArrayList<>();
        personList.add(Person.builder().personId(1).name("Fernando-1").build());
        personList.add(Person.builder().personId(2).name("Fernando-2").build());
        personList.add(Person.builder().personId(3).name("Fernando-3").build());
        return Flux.fromIterable(personList);
    }

    @Override
    public Mono<Person> listById(Integer id) {
        return Mono.just(Person.builder().personId(5).name("Fernando-5").build());
    }

    @Override
    public Mono<Person> checkIn(Person p) {
        log.info(p.toString());
        return Mono.just(p);
    }

    @Override
    public Mono<Person> update(Person p) {
        log.info(p.toString());
        return Mono.just(p);
    }

    @Override
    public Mono<Person> remove(Integer personId) {
        return Mono.empty();
    }
}
