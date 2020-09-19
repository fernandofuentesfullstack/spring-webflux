package com.fernandofuentesfullstack.demowebflux.repository;

import com.fernandofuentesfullstack.demowebflux.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonRepository {

    Flux<Person> list();

    Mono<Person> listById(Integer id);

    Mono<Person> checkIn(Person p);

    Mono<Person> update(Person p);

    Mono<Person> remove(Integer personId);
}
