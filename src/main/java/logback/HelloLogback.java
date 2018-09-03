package logback;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yh on 17/3/22.
 */
public class HelloLogback {
    public static void main(String[] args){
        Logger logger = LoggerFactory.getLogger("introduction");
        logger.debug("hello world");
        // print logback internal state
        LoggerContext lc = (LoggerContext)LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);
        Logger rootLogger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
    }
}
