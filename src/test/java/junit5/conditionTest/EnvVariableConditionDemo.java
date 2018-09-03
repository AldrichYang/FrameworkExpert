package junit5.conditionTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

/**
 * Created by yh on 9/3/18.
 */
public class EnvVariableConditionDemo {

    @Test
    @EnabledIfEnvironmentVariable(named = "ENV", matches = "staging-server")
    void onlyOnStagingServer() {


    }

    @Test
    @DisabledIfEnvironmentVariable(named = "ENV", matches = ".*development.*")
    void notOnDeveloperWorkstation() {
        // ...
    }
}
