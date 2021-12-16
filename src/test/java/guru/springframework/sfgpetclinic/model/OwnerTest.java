package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import static org.junit.jupiter.api.Assertions.*;

//@Tag("model")
class OwnerTest implements ModelTest {

    /**
     * Assertion agains parent and decendent object
     * Complex test
     */
    @Test
    void dependentAssertions() {
        Owner owner = new Owner(1l, "Joe", "Tester");
        owner.setCity("Key West");
        owner.setTelephone("2124569067");

        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Joe", owner.getFirstName(), "First Name Did not Match"),
                        () -> assertEquals("Tester", owner.getLastName())),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Key West", owner.getCity(), "City Did Not Match"),
                        () -> assertEquals("2124569067", owner.getTelephone())
                ));

        // Hamcrest
        assertThat(owner.getCity(), is("Key West"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Spring", "Framework", "Guru"})
    void testValueSource(String val) {
        System.out.println(val);
    }

}