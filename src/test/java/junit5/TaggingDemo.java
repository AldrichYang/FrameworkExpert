package junit5;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * Created by yh on 9/3/18.
 */
@Tag("fast")
@Tag("model")

public class TaggingDemo {

    @Test
    @Tag("taxes")
    void testingTaxCalc() {

    }


}
