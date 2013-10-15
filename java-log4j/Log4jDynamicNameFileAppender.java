package JavaLog4J;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;

// * @PROGRAM Log4jDynamicNameFileAppender.Java  
// * @AUTHOR  TINITIATE.COM / Venkata Bhattaram

// * PREREQUISITES:
// * Get the latest Log4J from URL: http://logging.apache.org/log4j/
// * Add it to the JAVA program CLASS_PATH 
// * Make Sure the log4jCustomAppenderFile.properties is created in the "c:\app\" folder.

//*****************************************************************************
// * @CLASS Log4jDynamicNameFileAppender
// * @NOTES 1) This Program explains a basic Log4J implementation for a File Appender.
// *           Output is written to a file.
// *        2) Dynamic FileName created.
// *        3) All Configuration settings are in the log4jFile.properties file
//****************************************************************************
public class Log4jDynamicNameFileAppender {

    static final Logger logger = Logger.getLogger(Log4jDynamicNameFileAppender.class);

    public static void main(String[] args) {

        // Read the log4jFile.properties file to get the Appender, Layout.. Config
        PropertyConfigurator.configure("c:/app/log4jCustomAppenderFile.properties");

        // Message Precedence DEBUG < INFO < WARN < ERROR < FATAL
        logger.debug("Sample debug message");
        logger.info("Sample info message");
        logger.warn("Sample warn message");
        logger.error("Sample error message");
        logger.fatal("Sample fatal message");
    }
}
