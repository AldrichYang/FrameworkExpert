package junit5.conditionTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

/**
 * Created by yh on 9/3/18.
 */
public class SystemPropertyConditionDemo {

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    void onlyOn64BitArchitectures() {
        System.out.println("64位os才可以运行");
    }

    @Test
    @DisabledIfSystemProperty(named = "ci-server", matches = "true")
    void notOnCiServer() {
        // ...
    }
}
