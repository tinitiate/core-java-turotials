package JavaDatabaseProgramming;

import java.sql.*;
import oracle.jdbc.driver.*;
import oracle.jdbc.pool.*;

/**
 * @author TINITIATE.COM
 *
 * @TOPIC :  JAVA JDBC With DataSource
 *
 * @NOTES :  For the Program to compile FOLLOW the ==[S.P.E.C.I.A.L I.N.S.T.R.U.C.T.I.O.N.S]== (See Below)
 *           1) Another method of Connecting to a RDBMS using JDBC is using the DataSource  
 *           2) Connecting to Oracle, using the package: ORACLE.JDBC
 *            
 *
 */
/**
 *  @CLASS : JDBCjavaExplained
 *
 *  @NOTES : 1) Demonstrates the Use of Oracle Thin Driver. Which is a Type 4: Native-protocol, Driver
 *           +-------------------------------------------+
 *           |**[S.P.E.C.I.A.L I.N.S.T.R.U.C.T.I.O.N.S]**|
 *           +-------------------------------------------+
 *           2) Program Setup:
 *           =========================================================================================
 *           Make sure the following Variables are changed according to your local setup:
 *           >    String serverName   // The Name of the Server/PC, on which the Oracle DB resides.
 *           >    Integer portNumber  // The PORT Number of the Oracle DB.
 *           >    String sid          // The Instance Name of the Oracle DB.
 *           =========================================================================================
 *
 */
public class DataSourceConnectionJDBC {

    // Main entry into the Program
    public static void main(String[] args) {
        /*************************************
         * S E T U P    I N S R U C T I O N S
         *************************************/   
        /**===========================================================**/
        // The Name of the Server/PC, on which the Oracle DB resides
        String serverName = "db.tinitiate.com";
        // The PORT Number of the Oracle DB
        Integer portNumber = 1521;
        // The Instance Name of the Oracle DB
        String sid = "TintiateDB";
        String schema = "tinitiate";
        String password = "tinitiate";        
        /**===========================================================**/

        try{
            OracleDataSource OraDS = new OracleDataSource();

            OraDS.setUser(schema);
            OraDS.setPassword(password);
            OraDS.setDriverType("thin");
            OraDS.setDatabaseName(sid);
            OraDS.setServerName(serverName);
            OraDS.setPortNumber(portNumber);

            Connection conn = OraDS.getConnection();
            Statement stmt = conn.createStatement();
            // The SQL Statement to execute.
            ResultSet rset = stmt.executeQuery("select 'ORACLE VERSION IS: '||version as OracleVersion from v$instance");

            // Prints the Result Set
            while (rset.next()) {
                // (1): Prints The First Column in the "rset" [Result Set]
                System.out.println (rset.getString(1));
            } 
            rset.close();
            stmt.close();
            conn.close();

        }
        catch(SQLException se){
            se.printStackTrace();
        }
    }
}
