package junit5;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Created by yh on 8/30/18.
 */
public class DisableTestsDemo {

    @Disabled
    @Test
    void testWillBeSkipped() {

        System.out.println("method be skipped");
    }

    @Test
    void testWillBeExecuted() {

    }
}
