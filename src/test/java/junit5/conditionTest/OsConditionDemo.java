package junit5.conditionTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.junit.jupiter.api.condition.OS.*;

/**
 * Created by yh on 9/3/18.
 */
public class OsConditionDemo {

    @Test
    @EnabledOnOs(MAC)
    void onlyOnMacOs() {
        System.out.println("only on mac os");
    }

    @TestOnMac
    void testOnMac() {
        System.out.println("only on mac os");
    }

    @Test
    @EnabledOnOs({LINUX, MAC})
    void noMacOsOrLinux() {

    }

    @Test
    @DisabledOnOs(WINDOWS)
    void notOnWindows() {

    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Test
    @EnabledOnOs(MAC)
    @interface TestOnMac {
    }


}
