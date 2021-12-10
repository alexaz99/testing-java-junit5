package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

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
        //Assertions.ass
    }
}