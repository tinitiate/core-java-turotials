package JavaLog4J;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;

// * @PROGRAM Log4JMultiAppender.Java
// * @AUTHOR  TINITIATE.COM / Venkata Bhattaram

// * PREREQUISITES:
// * Get the latest Log4J from URL: http://logging.apache.org/log4j/
// * Add it to the JAVA program CLASS_PATH 
// * Make Sure the log4jMultiAppenders.properties is created in the "c:\app\" folder.

//*****************************************************************************
// * @CLASS Log4JMultiAppender
// * @NOTES 1) This Program explains an Log4J implementation 
// *           for a File Appender and a console appender.
// *        2) All Configuration settings are in the log4jMultiAppenders.properties file
// *        3) DEBUG message will not be shown in the File as, it has a threshold as INFO
// *           Message Precedence DEBUG < INFO < WARN < ERROR < FATAL
//****************************************************************************
public class Log4jMULTIPLEappenders {

    static final Logger logger = Logger.getLogger(Log4jMULTIPLEappenders.class);
    public static void main(String[] args) {

        // Writing Messages to Console and File
        // Read the log4jMultiAppenders.properties file to get the Appender, Layout.. Config
        PropertyConfigurator.configure("c:/app/log4jMultiAppenders.properties");

        // Message Precedence DEBUG < INFO < WARN < ERROR < FATAL
        logger.debug("Sample debug message");
        logger.info("Sample info message");
        logger.warn("Sample warn message");
        logger.error("Sample error message");
        logger.fatal("Sample fatal message");
    }
}
