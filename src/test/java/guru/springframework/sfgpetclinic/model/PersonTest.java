package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTest;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

//@Tag("model")
class PersonTest implements ModelTest {

    @Test
    void groupAssertions() {
        // given
        Person person = new Person(1l, "Joe", "Tester");

        // then
        assertAll("Test Props Set",
                () -> assertEquals("Joe", person.getFirstName()),
                () -> assertEquals("Tester", person.getLastName()));
    }

    @Test
    void groupAssertionMsgs() {
        // given
        Person person = new Person(1l, "Joe", "Tester");

        // then
        assertAll("Test Props Set",
                () -> assertEquals("Joe", person.getFirstName(),  "First Name Failed"),
                () -> assertEquals("Tester", person.getLastName(),  "Last Name Failed"));
    }


}