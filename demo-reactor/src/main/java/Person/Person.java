package Person;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @Builder
public class Person {

    private Integer id;
    private String name;
    private Integer age;
}
