package otus.homework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return "firstName = " + firstName+
                ", lastName = " + lastName;
    }
}
