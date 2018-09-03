package junit5.methodParamsInjectDemo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

import java.util.HashMap;

/**
 * Created by yh on 9/3/18.
 * 使用TestReporter来代替你在JUnit 4中打印信息到stdout或stderr的习惯。
 * 使用@RunWith(JUnitPlatform.class)会将报告的所有条目都输出到stdout中
 */
public class TestReporterDemo {

    @Test
    void reportSingleValue(TestReporter testReporter) {
        testReporter.publishEntry("a key", "a value");
    }

    @Test
    void reportSeveralValues(TestReporter testReporter) {
        HashMap<String, String> values = new HashMap<>();
        values.put("user name", "dk38");
        values.put("award year", "1974");

        testReporter.publishEntry(values);
    }
}
