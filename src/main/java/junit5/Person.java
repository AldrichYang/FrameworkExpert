package junit5;

import lombok.Data;

/**
 * Created by yh on 8/29/18.
 */

@Data
public class Person {

    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
