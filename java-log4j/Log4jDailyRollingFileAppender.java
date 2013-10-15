package JavaLog4J;

import java.util.Date;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;

// * @PROGRAM Log4jDailyRollingFileAppender.Java  
// * @AUTHOR  TINITIATE.COM / Venkata Bhattaram

// * PREREQUISITES:
// * Get the latest Log4J from URL: http://logging.apache.org/log4j/
// * Add it to the JAVA program CLASS_PATH 
// * Make Sure the log4jRollingFile.properties is created in the "c:\app" folder.

//*****************************************************************************
// * @CLASS Log4jDailyRollingFileAppender
// * @NOTES 1) This Program explains a basic Log4J implementation for a File Appender.
// *           Output is written to a file. 
// *        2) Daily Rolling creates new log files, On a schedule
// *           2.1) Minutely   '.'yyyy-MM-dd-HH-mm
// *           2.2) Hourly     '.'yyyy-MM-dd-HH
// *           2.3) Half-daily '.'yyyy-MM-dd-a
// *           2.4) Daily      '.'yyyy-MM-dd
// *           2.5) Weekly     '.'yyyy-ww
// *           2.6) Monthly    '.'yyyy-MM
// *        3) All Configuration settings are in the log4jRollingFile.properties file
// *        4) This Creates "Minutely" Logs, Let this program run for more than 
// *           a minute to see Logs.
// *        5) Designed to create 2 Files, app.log and app.log+new Date();
//****************************************************************************
public class Log4jDailyRollingFileAppender {

    static final Logger logger = Logger.getLogger(Log4jDailyRollingFileAppender.class);
    public static void main(String[] args) {

        // Writing Messages to Console
        // Read the log4jFile.properties file to get the Appender, Layout.. Config
        PropertyConfigurator.configure("c:/app/log4jRollingFile.properties");

        System.out.println(new Date() + " Program Starting");
        System.out.println("This Program runs for 140 Seconds");
        System.out.println("Creating a  Log file in the specified location as mentioned in properties file");
        
        // Loop Counter
        int l_ctr = 1;
        while(l_ctr < 3 ) {
            // Message Precedence DEBUG < INFO < WARN < ERROR < FATAL
            logger.debug("Sample debug message");
            logger.info("Sample info message");
            logger.warn("Sample warn message");
            logger.error("Sample error message");
            logger.fatal("Sample fatal message");
            // Sleep for a Minute, To create a new log file
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) { e.printStackTrace(); }
            l_ctr++;
        }
        System.out.println(new Date() + " Program Complete");
    }
}
