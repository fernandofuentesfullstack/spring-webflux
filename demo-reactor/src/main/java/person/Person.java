package person;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @Builder @EqualsAndHashCode
public class Person {

    private Integer id;
    private String name;
    private Integer age;
}
