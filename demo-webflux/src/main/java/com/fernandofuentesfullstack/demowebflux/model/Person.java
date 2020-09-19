package com.fernandofuentesfullstack.demowebflux.model;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @ToString
public class Person {

    private Integer personId;
    private String name;
}
