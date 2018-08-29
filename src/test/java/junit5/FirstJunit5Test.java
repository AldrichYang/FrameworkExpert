package junit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by yh on 8/29/18.
 */
 class FirstJunit5Test {

    @Test
    void myFirstTest() {
        assertEquals(2, 1 + 1);
    }
}
