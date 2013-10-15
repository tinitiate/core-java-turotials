
package JavaLog4J;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;

// * @PROGRAM Log4jSMTPappender.Java
// * @AUTHOR  TINITIATE.COM / Venkata Bhattaram

// * PREREQUISITES:
// * Get the latest Log4J from URL: http://logging.apache.org/log4j/
// * Add it to the JAVA program CLASS_PATH 
// * Make Sure the Log4jSMTPappender.properties is created in the "c:\app\" folder.

//*****************************************************************************
// * @CLASS Log4jSMTPappender
// * @NOTES 1) This Program explains an Log4J implementation for a SMTP Appender
// *        2) Demo to send alerts as emails t specified recipients. 
// *        2) All Configuration settings are in the Log4jSMTPappender.properties file
// *        Message Precedence DEBUG < INFO < WARN < ERROR < FATAL
//****************************************************************************
public class Log4jSMTPappender {

    static final Logger logger = Logger.getLogger(Log4jSMTPappender.class);
    public static void main(String[] args) {

        // Writing Messages to Console and File
        // Read the log4jMultiAppenders.properties file to get the Appender, Layout.. Config
        PropertyConfigurator.configure("c:/app/Log4jSMTPappender.properties");
    
        // Message Precedence DEBUG < INFO < WARN < ERROR < FATAL
        logger.debug("Sample debug message");
        logger.info("Sample info message");
        logger.warn("Sample warn message");
        logger.error("Sample error message");
        logger.fatal("Sample fatal message");
    }
}
