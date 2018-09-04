package junit5.TestInterface;

import junit5.extension.TimingExtension;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * Created by yh on 9/4/18.
 */
@Tag("timed")
@ExtendWith(TimingExtension.class)
public interface TimeExecutionLogger {
}
