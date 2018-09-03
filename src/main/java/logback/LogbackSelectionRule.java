package logback;

import ch.qos.logback.classic.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yh on 17/3/23.
 */
public class LogbackSelectionRule {
    public static void main(String[] args){
        ch.qos.logback.classic.Logger logger = (ch.qos.logback.classic.Logger)LoggerFactory.getLogger("com.foo");
        //set its Level to INFO. The setLevel() method requires a logback logger
        logger.setLevel(Level.INFO);
        Logger barlogger = LoggerFactory.getLogger("com.foo.Bar");
        // This request is enabled, because WARN >= INFO
        logger.warn("Low fuel level.");
        // This request is disabled, because DEBUG < INFO.
        logger.debug("Starting search for nearest gas station.");


    }
}
