package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@Tag("model")
public interface ModelTest {

    /**
     * Uses interface to output test information (name and iteration
     */
    @BeforeEach
    default void beforeEachOutputer(TestInfo testInfo) {
        System.out.println("Running Test - " + testInfo.getDisplayName() );
    }
}
