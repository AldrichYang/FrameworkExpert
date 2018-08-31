package junit5;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Created by yh on 8/30/18.
 */
@Disabled
class DisabledClassDemo {
    
    @Test
    void testWillBeSkipped() {
        System.out.println("execute test method");
    }


}
