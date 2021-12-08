package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void oupsHandler() {
        assertTrue("notimplemented".equals(controller.oupsHandler()), () -> "This is some expensive" +
                " Message to build " +
                "for my test");
    }
}