package automation_test.test_logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class TestLog4J {
    private static final Logger LOGGER = LogManager.getLogger(TestLog4J.class);

    @Test
    public void run() {
        LOGGER.debug("This is a debug message");
        LOGGER.info("This is a info message");
        LOGGER.warn("This is a warning");
        LOGGER.error("This is a error");
        LOGGER.fatal("This is dangerous");
    }
}
