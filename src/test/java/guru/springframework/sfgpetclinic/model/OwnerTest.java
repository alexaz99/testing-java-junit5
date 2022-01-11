package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.CustomArgsProvider;
import guru.springframework.sfgpetclinic.ModelTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    @ValueSource(strings = {"Alex", "Bob", "John"})
    void testValueSource_Simple(String val) {
        // output parameters passed from @ValueSource annotation settings
        System.out.println(val);
    }

    @DisplayName("Value Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Spring", "Framework", "Guru"})
    void testValueSource(String val) {
        // output parameters passed from @ValueSource annotation settings

        // Running Test - [1] output is coming from ModelTest interface
        // Alex ModelTest
        System.out.println(val);
    }

    @DisplayName("Enum Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType ownerType) {
        System.out.println(ownerType);
    }

    /**
     * Pass CSV input list.
     * Each row csv value is a string.
     * Define 3 string.
     * @param stateName
     * @param val1
     * @param val2
     */
    @DisplayName("CSV Input Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvSource({
            "FL, 1, 1",
            "OH, 2, 2",
            "MI, 3, 3"
    })
    void csvInputTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " = " + val1 + ":" + val2);
    }

    @DisplayName("CSV From File Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    void csvFromFileTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " = " + val1 + ":" + val2);
    }

    @DisplayName("Method Provider Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @MethodSource("getArgs") // the name of the method
    void fromMethodTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " = " + val1 + ":" + val2);
    }

    // Use this method as an example
    static Stream<Arguments> getArgs() {
        return Stream.of(
                Arguments.of("CA", 11, 11),
                Arguments.of("NJ", 21, 21),
                Arguments.of(null, Integer.MAX_VALUE, Integer.MIN_VALUE),
                Arguments.of("NY", 31, 31));
    }

    // This is a very similar to a method provider static Stream<Arguments> getArgs(),
    // but we are going to extract it to the class
    @DisplayName("Custom Provider Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ArgumentsSource(CustomArgsProvider.class)
    void fromCustomProviderTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " = " + val1 + ":" + val2);
    }

}