package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @AfterEach
    void tearDown() {
    }

    @DisplayName("Test Proper View name is return")
    @Test
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), " Wrong View Returned");
        assertEquals("index", controller.index(), () -> "Another expensive method");
    }

    /**
     * Use message as a lambda expression. It will be evaluated only in a failure condition.
     * Those messages are not picked up at run time at all, unless the test fails.
     * This is a performance tip.
     */
    @Test
    void oopsHandler() {
        assertThrows(ValueNotFoundException.class, () -> {
            controller.oopsHandler();
        });
/*        assertTrue("notimplemented".equals(controller.oopsHandler()), () -> "This is some expensive" +
                " Message to build " +
                "for my test");*/
    }

    @Disabled("Demo of timeout")
    @Test
    void testTimeOut() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);
            System.out.println("I got here");
        });
    }

    @Disabled("Demo of TimeoutPreemptively")
    @Test
    void testTimeOutPrempt() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("I got here Preemptively");
        });
    }

    @Test
    void testAssumptionTrue() {
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void testAssumptionTrueAssumtionIsTrue() {
        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }

    @Test
    void testOnlyOnCiServer() {
        assumeTrue("CI".equals(System.getenv("ENV")));
        // remainder of test
    }

    @Test
    void testOnlyOnDeveloperWorkstation() {
        assumeTrue("DEV".equals(System.getenv("ENV")),
                () -> "Aborting test: not on developer workstation");
        // remainder of test
    }

    @Test
    void testInAllEnvironments() {
        assumingThat("CI".equals(System.getenv("ENV")),
                () -> {
                    // perform these assertions only on the CI server
                    //assertEquals(2, calculator.divide(4, 2));
                });

        // perform these assertions in all environments
        //assertEquals(42, calculator.multiply(6, 7));
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMacOS() {
        System.out.println("Running on Windows OS");
    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnWindows() {
        System.out.println("Running on Windows OS");
    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testMeOnJava8() {

    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testMeOnJava11() {
    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "jt")
    @Test
    void testIfUserJT() {
    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "fred")
    @Test
    void testIfUserFred() {
    }

    @EnabledIfEnvironmentVariable(named = "ALEX_VAR", matches = "alex")
    @Test
    void testIfAlexVar() {
    }

    @Test // Static JavaScript expression.
    @EnabledIf("2 * 3 == 6")
    void willBeExecuted() {
        // ...
    }

    @Test // Static JavaScript expression.
    @EnabledIf("2 * 3 == 7")
    void willBeNotExecuted() {
        // ...
    }

    @RepeatedTest(10) // Dynamic JavaScript expression.
    @DisabledIf("Math.random() < 0.314159")
    void mightNotBeExecuted() {
        // ...
    }

}