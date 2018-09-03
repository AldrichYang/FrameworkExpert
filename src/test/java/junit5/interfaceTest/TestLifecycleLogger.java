package junit5.interfaceTest;

import org.junit.jupiter.api.TestInstance;

import java.util.logging.Logger;

/**
 * Created by yh on 9/3/18.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface TestLifecycleLogger {
    static final Logger LOG = Logger.getLogger(TestLifecycleLogger.class.getName());


}
