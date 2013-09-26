package JavaDatabaseProgramming;

import java.sql.*;
import java.util.Properties;
import oracle.jdbc.OracleDriver;
import oracle.jdbc.pool.*;

/**
 * @author TINITIATE.COM
 *
 * @TOPIC :  JAVA JDBC With DataSource
 *
 * @NOTES :  For the Program to compile FOLLOW the ==[S.P.E.C.I.A.L I.N.S.T.R.U.C.T.I.O.N.S]== (See Below)
 *           1) Another method of Connecting to a RDBMS using JDBC is using the DataSource  
 *           2) Connecting to Oracle, using the package: ORACLE.JDBC
 *           3) Creating a DBConnection POOL, ReUse a fixed number of OPEN connections (for Various DB operations from JAVA),
 *              without having to close and recreate newer connections.
 *           4) A connection pool is a cache of database connection objects.
 *              The objects represent physical database connections that can be used by 
 *              an application to connect to a database. 
 *              At run time, the application requests a connection from the pool.
 *              If the pool contains a connection that can satisfy the request,
 *              it returns the connection to the application. If no connections are found,
 *              a new connection is created and returned to the application.
 *              The application uses the connection to perform some work on the database and 
 *              then returns the object back to the pool. The connection is then available 
 *              for the next connection request.
 *              Connection pools promote the reuse of connection objects and reduce the 
 *              number of times that connection objects are created. Connection pools
 *              significantly improve performance for database-intensive applications 
 *              because creating connection objects is costly both in terms of time and resources
 *
 */

class ConnectionPool1 {

    /*************************************
     * S E T U P    I N S R U C T I O N S 
     *************************************/   
    /**===========================================================**/
    // The Name of the Server/PC, on which the Oracle DB resides
    static String serverName = "TinHost";
    // The PORT Number of the Oracle DB
    static String portNumber = "1521";
    // The Instance Name of the Oracle DB
    static String sid = "TinDB";
    static String schema = "tinitiate";
    static String password = "tinitiate";
    // The URL to specify the driver.
    static String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;
    /**===========================================================**/

    static String l_cache_name = "OraConn";
    static OracleOCIConnectionPool ConnPool = null;
    // Max. number of DB connections allowed, by the ConnectionManager() 
    static int l_Max_connections = 3;

    /**
     * @METHOD : GetConnection
     * @NOTES  : 1) This method creates a limited number of DB connections.
     *           2) All the connections created are reused by the consumer.
     */
    public static Connection GetConnection() {

        try {
            DriverManager.registerDriver(new OracleDriver());

            OracleOCIConnectionPool ConnPool = new OracleOCIConnectionPool(schema, password, url, null);
            //Set up the initial pool configuration
            Properties p1  = new Properties();
            p1.put(ConnPool.CONNPOOL_MIN_LIMIT, Integer.toString(1));
            p1.put(ConnPool.CONNPOOL_MAX_LIMIT, Integer.toString(l_Max_connections));
            p1.put(ConnPool.CONNPOOL_INCREMENT, Integer.toString(1));

            ConnPool.setUser("SCOTT");
            ConnPool.setPassword("TIGER");
            ConnPool.setURL("jdbc:oracle:oci:@" + "(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)" +
                            "(PORT=1521)(HOST=Tinhost)))" +
                            "(CONNECT_DATA=(SERVICE_NAME=TinDB)))");
            ConnPool.setPoolConfig(p1); 

            return ConnPool.getConnection();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
/**
 * Creates Threads of the Class ConnectionPool.
 */
class JDBCDataSourceConnectionPool extends Thread {

    
    //public String     vSQL;

    /**
     * @METHOD  runSQL, Runs a Given Query in a Given Connection
     * @param   p_SQL; The SQL that needs to be executed
     * @param   C;     The Connection where the p_SQL, will be executed.
     */
    public static void runSQL( String p_SQL, Connection C )
    {
        try {
            C.setAutoCommit(false);  // Make sure nothing Commits
            Statement stmt = C.createStatement();
            ResultSet rset = stmt.executeQuery(p_SQL);
            while (rset.next())
               System.out.println (rset.getString(1));
            stmt.close();
            C.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void runPLSQL( String p_PLSQL, Connection C )
    {
        try {
            C.setAutoCommit(false);  // Make sure nothing Commits
            Statement stmt = C.createStatement();
            stmt.executeUpdate(p_PLSQL);
            stmt.close();
            C.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Main Method, Read from Here
    public static void main(String[] args) {

        //Create a new ConnectionPool Object
        ConnectionPool1 conn = new ConnectionPool1();
        // Create a Connection and Set Session Name for that Connection
        Connection C1 = conn.GetConnection();
        String C1_SessionName = "begin dbms_application_info.set_module('Connection1',NULL); end;";
        runPLSQL(C1_SessionName,C1);
        String C1_Query = "select module from v$session where module='Connection1'";
        runSQL(C1_Query,C1);

        Connection C2 = conn.GetConnection();
        String C2_SessionName = "begin dbms_application_info.set_module('Connection2',NULL); end;";
        runPLSQL(C2_SessionName,C2);
        String C2_Query = "select module from v$session where module='Connection2'";
        runSQL(C2_Query,C2);

        Connection C3 = conn.GetConnection();
        String C3_SessionName = "begin dbms_application_info.set_module('Connection3',NULL); end;";
        runPLSQL(C3_SessionName,C3);
        String C3_Query = "select module from v$session where module='Connection3'";
        runSQL(C3_Query,C3);

        Connection C4 = conn.GetConnection();
        String C4_SessionName = "begin dbms_application_info.set_module('Connection4',NULL); end;";
        runPLSQL(C1_SessionName,C3);
        String C4_Query = "select module from v$session where module='Connection4'";
        runSQL(C4_Query,C4);
    }
}
