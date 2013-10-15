package JavaLog4J;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;

// * @PROGRAM Log4jConsoleAppender.Java  
// * @AUTHOR  TINITIATE.COM / Venkata Bhattaram

// * PREREQUISITES:
// * Get the latest Log4J from URL: http://logging.apache.org/log4j/
// * Add it to the JAVA program CLASS_PATH 
// * Make Sure the log4jConsole.properties is created in c:/app folder.

//*****************************************************************************
// * @CLASS Log4jConsoleAppender
// * @NOTES 1) This Program explains a basic Log4J implementation for a Console Display Appender
// *        2) It is Configurable and Provides methods to log to File or a Database Table.
//****************************************************************************
public class Log4jConsoleAppender {

    static final Logger logger = Logger.getLogger(Log4jConsoleAppender.class);
    public static void main(String[] args) {

        // Writing Messages to Console
        // Read the log4jConsole.properties file to get the Appender, Layout.. Config
        PropertyConfigurator.configure("c:/app/log4jConsole.properties");

        // Message Precedence DEBUG < INFO < WARN < ERROR < FATAL
        logger.debug("Sample debug message");
        logger.info("Sample info message");
        logger.warn("Sample warn message");
        logger.error("Sample error message");
        logger.fatal("Sample fatal message");
    }
}
