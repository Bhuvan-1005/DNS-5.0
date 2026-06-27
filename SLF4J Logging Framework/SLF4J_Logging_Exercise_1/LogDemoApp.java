import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogDemoApp {
    private static final Logger logger = LoggerFactory.getLogger(LogDemoApp.class);

    public static void logAllLevels() {
        logger.trace("This is a TRACE level log message.");
        logger.debug("This is a DEBUG level log message.");
        logger.info("This is an INFO level log message.");
        logger.warn("This is a WARN level log message.");
        logger.error("This is an ERROR level log message.");
    }

    public static void main(String[] args) {
        logAllLevels();
    }
}
