package JavaDatabaseProgramming;

import java.sql.*;
import oracle.jdbc.OracleDriver;

/**
 * @author TINITIATE.COM
 *
 * @TOPIC :  JAVA JDBC Introduction
 *
 * @NOTES :  1) JDBC is Java's API that provides an interface for accessing wide range of relational databases.
 *           2) JDBC is platform independent, But needs Java Virtual Machine and the appropriate JDBC driver.
 *           3) JDBC drivers are database-specific. Each Database need its own JDBC drivers
 *              Oracle needs its JDBC, Sybase JDBC drivers to access Sybase database...
 *              DEVELOPER NEEDS TO GET THE APPROPRIATE JDBC DRIVER and add it to the PROJECT JARs LIBRARY.
 *           4) JDBC drivers may be different for different versions of a database.
 *           5) There are FOUR types of JDBC Drivers :
 *              Type 1: JDBC-ODBC Bridge: Provides access through ODBC drivers (Uses ODBC, this adds additional overhead)
 *              Type 2: Native-API:       Provides access through native database API
 *              Type 3: Middle-tier:      Provides access through a middle-tier server (Needs a Appliation Server)
 *              Type 4: Native-protocol:  Provides access through a network protocol used by DBMS (Fast and Most commonly used)
 *           6) Example provided for Oracle-Thin Driver Type 4: Native-protocol.
 *              * Download the JDBC Oracle-Thin Driver from Oracle.com, Setup in IDE to use that JAR file.
 *
 *=====================================================================================================================
 *########### For the Program to compile FOLLOW the ==[S.P.E.C.I.A.L I.N.S.T.R.U.C.T.I.O.N.S]== (See Below) ########### 
 *=====================================================================================================================
 *
 *           7) DriverManager Class: [ Creates a Connection Object for the JDBC Driver]
 *              getConnection(url,username,password)
 *              url: The URL is specific for JDBC driver, This informs the DriverManager 
 *                   about the return type of JDBC connection
 *              username: The User Name to which the DB connection is to be made.
 *              password: THe User Names password.
 *           8) Connection Object:
 *                  It represents a connection to a data source in JDBC
 *                  SQL Statements are passed to the DB through Connection objects
 *                  A Program can have multiple connections to one or more Databases
 *           9) Statement Object:
 *                  9.1) This object is used to execute a SQL statement and 
 *                       returns the results from the DB server, in a ResultSet Object.
 *                  9.2) One Statement Object returns One ResultSet Object.
 *           10) ResultSet Object:
 *                  10.1) This Object, captures the result from a Statement Objects result.
 *                  10.2) Multiple rows can be read by iterating this object.
 *           11) Please FOLLOW the ==[S.P.E.C.I.A.L I.N.S.T.R.U.C.T.I.O.N.S]== (See Below)
 *
 */
/**
 *  @CLASS : JavaJDBC
 *  
 *  @NOTES : 1) Demonstrates the Use of Oracle Thin Driver. Which is a Type 4: Native-protocol, Driver
 *           +-------------------------------------------+
 *           |**[S.P.E.C.I.A.L I.N.S.T.R.U.C.T.I.O.N.S]**| 
 *           +-------------------------------------------+ 
 *           2) Program Setup:
 *           =========================================================================================
 *           Make sure the following Variables are changed according to your local setup:
 *           >    String serverName // The Name of the Server/PC, on which the Oracle DB resides.
 *           >    String portNumber // The PORT Number of the Oracle DB.
 *           >    String sid        // The Instance Name of the Oracle DB.
 *           =========================================================================================
 *
 */
public class JavaJDBC {

    /*************************************
     * S E T U P    I N S R U C T I O N S 
     *************************************/   
    /**===========================================================**/
    // The Name of the Server/PC, on which the Oracle DB resides
    // The Name of the Server/PC, on which the Oracle DB resides
    static String serverName = "db.tinitiate.com";
    // The PORT Number of the Oracle DB
    static String portNumber = "1521";
    // The Instance Name of the Oracle DB
    static String sid = "TintiateDB";
    static String schema = "Tintiate";
    static String password = "Tintiate";
    /**===========================================================**/

    // The URL to specify the driver.
    static String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;

    public static void OracleJDBCDriverInfo() {
        try {
            // Load the driver Type-4 JDBC Native-Protocol
            //String driverName = "oracle.jdbc.OracleDriver"; // Oracle JDBC driver TYPE-4 [Native-protocol] 
            //Class.forName(driverName);
            // Static url variable
            Driver driver = DriverManager.getDriver(url);

            // Get available properties
            DriverPropertyInfo[] info = driver.getPropertyInfo(url, null);
            for (int i=0; i<info.length; i++) {
                // Get name of property
                String name = info[i].name;

                // Is property value required?
                boolean isRequired = info[i].required;

                // Get current value
                String value = info[i].value;

                // Get description of property
                String desc = info[i].description;

                // Get possible choices for property; if null, value can be any string
                String[] choices = info[i].choices;

                System.out.println("+-------------------------------------------------+");
                System.out.println("| Property Name: " + name);
                System.out.println("| Property description: " + desc);
                System.out.println("| Is Property Required(True/False): " + isRequired);
                System.out.println("| Property Current Value: " + value);
                System.out.println("+-------------------------------------------------+");
            }
        } 
    catch (SQLException e) {
        }
    }

    // Method to Connect to a Oracle DB and execute a Query with One Column in the "Select"
    public static void OraConnectionUsingNativeAPI() {
        Connection connection = null;
        try {

            // Static url variable
            Connection conn = DriverManager.getConnection(url, schema, password);
            Statement stmt = conn.createStatement();
            // The SQL Statement to execute.
            ResultSet rset = stmt.executeQuery("select text from dba_views where rownum < 3");
            ResultSetMetaData rmd = rset.getMetaData();

            // Prints the Result Set
            while (rset.next()) {
                // (1): Prints The First Column in the "rset" [Result Set]
                System.out.println (rset.getString(1));
                System.out.println (rmd.getColumnTypeName(1));
            } 
            rset.close();
            stmt.close();
            conn.close();
        }    
        catch(SQLException e) {}
    }

    // Main entry into the Program
    public static void main(String[] args) {
        OraConnectionUsingNativeAPI();
        OracleJDBCDriverInfo();
    }
}

