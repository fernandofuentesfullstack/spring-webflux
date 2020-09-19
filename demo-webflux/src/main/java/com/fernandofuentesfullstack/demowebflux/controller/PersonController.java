package com.fernandofuentesfullstack.demowebflux.controller;

import com.fernandofuentesfullstack.demowebflux.model.Person;
import com.fernandofuentesfullstack.demowebflux.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private static final Logger log = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonRepository repository;

    @GetMapping
    public Flux<Person> list() {
        return repository.list();
    }

    @GetMapping("/{personId}")
    public Mono<Person> listById(@PathVariable Integer personId) {
        return repository.listById(personId);
    }

    @PostMapping
    public Mono<Person> checkIn(@RequestBody Person person) {
        return repository.checkIn(person);
    }

    @PutMapping
    public Mono<Person> update(@RequestBody Person person) {
        return repository.update(person);
    }

    @DeleteMapping("/{personId}")
    public Mono<Person> remove(@PathVariable Integer personId) {
        return repository.listById(personId)
                .flatMap( p -> repository.remove(p.getPersonId()));
    }

}
