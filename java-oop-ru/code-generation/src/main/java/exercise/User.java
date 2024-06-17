package exercise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@AllArgsConstructor
@Getter
@Setter
@Value
class User {
    int id;
    String firstName;
    String lastName;
    int age;
}
