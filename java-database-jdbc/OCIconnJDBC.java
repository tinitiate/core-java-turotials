package JavaDatabaseProgramming;

import java.sql.*;
/**
 * 
 * Test to connect to Database using the OCI Driver
 *
 */
class OCIconnJDBC {
  public static void main (String args []) throws Exception
  {
        Class.forName ("oracle.jdbc.OracleDriver");

        Connection conn = DriverManager.getConnection
             ("jdbc:oracle:oci8:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(PORT=1531)(HOST=xzur0536dor.zur.swissbank.com)))(CONNECT_DATA=(SERVICE_NAME=ARISKDEV)))", "limitp_tso", "limitp_tso");
                     // or oci7 @TNSNames_Entry,    userid,  password
        try { 
        Statement stmt = conn.createStatement();
        try {
        ResultSet rset = stmt.executeQuery("select BANNER from SYS.V_$VERSION");
        try {
        while (rset.next())
              System.out.println (rset.getString(1));   // Print col 1
        } finally {
            try { rset.close(); } catch (Exception ignore) {}
        }
        } finally {
            try { stmt.close(); } catch (Exception ignore) {}
        }
        } finally {
            try { conn.close(); } catch (Exception ignore) {}
        }
  }
}
