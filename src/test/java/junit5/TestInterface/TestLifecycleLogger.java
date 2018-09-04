package junit5.TestInterface;

import org.junit.jupiter.api.*;

import java.util.logging.Logger;

/**
 * Created by yh on 9/3/18.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface TestLifecycleLogger {
    static final Logger LOG = Logger.getLogger(TestLifecycleLogger.class.getName());


    @BeforeAll
    default void beforeAllTests() {
        LOG.info("Before all tests");
    }

    @AfterAll
    default void afterAllTests() {
        LOG.info("After all tests");
    }

    @BeforeEach
    default void beforeEachTest(TestInfo testInfo) {
        LOG.info(() -> String.format("About to execute [%s]",
                testInfo.getDisplayName()));
    }

    @AfterEach
    default void afterEachTest(TestInfo testInfo) {
        LOG.info(() -> String.format("Finished executing [%s]",
                testInfo.getDisplayName()));
    }

}
