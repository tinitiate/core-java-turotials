package JavaLog4J;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

// * @PROGRAM Log4jBasics.java  
// * @AUTHOR  TINITIATE.COM / Venkata Bhattaram

// * PREREQUISITES:
// * Get the latest Log4J from URL: http://logging.apache.org/log4j/
// * Add it to the JAVA program CLASS_PATH 

//****************************************************************************
// * @CLASS Log4jBasics
// * @NOTES 1) This Program explains a basic implementation of the Log4J API.
// *        2) Log4j is a widely used Logging API written in Java by Apache (OpenSource).
// *        3) It is Configurable and Provides methods to log to File or a Database Table.
// *        4) It is thread-safe and provides multiple level logging (ALL,TRACE,DEBUG,INFO,WARN,ERROR,FATAL).
// *        5) Message Precedence DEBUG < INFO < WARN < ERROR < FATAL
// *        6) Create a Message Layout, Log output format can be managed by 
// *           extending the Layout class.
// *        7) Create an Appender, The appender is the "Output Location", 
// *            Could be Console, FIle, DataBase, Email, JMS ...
// *           7.1) Appender, can be assigned a Layout
// *        8) Create a Logger Class and add an Appender
// *
//****************************************************************************

public class Log4jBasics {

    // * @METHOD  main()
    // * @NOTES   1) The main method of the program 
    public static void main(String[] args) {

        // * Create a pattern layout
        // * Layout for the Message. conversionPattern.
        PatternLayout layout = new PatternLayout();
        // This is the Pattern in which the Message is written
        String conversionPattern = "[%p] %d %c %M - %m%n";
        layout.setConversionPattern(conversionPattern);

        // * Create a Appender, A "console Appender" to write to Console
        ConsoleAppender ca = new ConsoleAppender();
        // * Use the Layout
        ca.setLayout(layout);
        ca.activateOptions();

        // create an instance of Logger class
        Logger logger = Logger.getLogger(Log4jBasics.class);
        logger.setLevel(Level.DEBUG);
        logger.addAppender(ca);

        // Print Messages to console of varying Severity
        logger.debug("This ia a debug message");
        logger.info ("This ia a info  message");
        logger.warn ("This ia a warn  message");
        logger.error("This ia a error message");
        logger.fatal("This ia a fatal message");
    }
}
