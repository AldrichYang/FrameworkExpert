package junit5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by yh on 9/5/18.
 */
public class ParameterTest {

    //    使用@ValueSource注解指定String数组作为参数源的参数化测试
    @ParameterizedTest
    @ValueSource(strings = {"racecar", "radar", "able was I ere I saw elba"})
    void palindromes(String candidate) {
        assertTrue((candidate.length() > 0));
    }
}
