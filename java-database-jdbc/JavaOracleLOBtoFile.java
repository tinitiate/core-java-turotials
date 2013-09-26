package JavaDatabaseProgramming;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import oracle.jdbc.internal.OraclePreparedStatement;

//
// * @author TINITIATE.COM
//
// * @topic :  JAVA Oracle LOB Types (CLOB and BLOB)
// *
// * @notes : 1) This Class provides examples to work with Oracle CLOB and BLOB Types.
// *          2) Inserting a CLOB and BLOB type into a table.  
// *          3) Reading a CLOB and BLOB field from a Table
// *          4) Writing a CLOB and BLOB into a file.
// *
// *        TO RUN THIS PROGRAM PLEASE SETUP THE CONNECTION PARAMETERS, BELOW      
// *         +----------------------------------------+
// *         | CONNECTION [SETUP - INSTRUCTIONS]      |
// *         +----------------------------------------+
// *
// *         *# THIS PROGRAM CREATES ORACLE TABLE with CLOB and BLOB types #*   
// *
public class JavaOracleLOBtoFile {

    // *   +----------------------------------------+
    // *   | CONNECTION [SETUP - INSTRUCTIONS]      |
    // *   +----------------------------------------+
    // The Name of the Server/PC, on which the Oracle DB resides
    static String serverName = "db.tinitiate.com";
    // The PORT Number of the Oracle DB
    static String portNumber = "1521";
    // The Instance Name of the Oracle DB
    static String sid = "TintiateDB";
    static String schema = "tinitiate";
    static String password = "tinitiate";

    // *  The URL to specify the driver.(Generated using the above parameters
    static String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;
    // ---X---

    // * +--------------------------+ 
    // * | Oracle Create Table      |    
    // * | with CLOB and BLOB types |
    // * +--------------------------+

    // * Valid Create Table DDL syntax
    static String OraDDLCreate =  " create table TinitiateLOBtestTab " +
                                  "   (  tID      integer "            +
                                  "     ,tName    varchar2(100) "      +
                                  "     ,colCLOB  clob "               +
                                  "     ,colBLOB  blob )";

    // * Valid Drop Table DDL syntax
    static String OraDDLDrop = "drop table TinitiateLOBtestTab";

    // * Insert Statement Template for the table: TinitiateLOBtestTab
    static String insLOBtestTab = "insert into TinitiateLOBtestTab values (?,?,?,?)";


    public static void main(String[] args) {
        
        try {
            // Create the DB Connection Object
            Connection conn = DriverManager.getConnection(url, schema, password);
            
            // Create a Statement Object
            // Use the Statement Object to execute SQL statements
            // where in the Statements which will be executed only once
            // Like create a specific table or alters or drops
            Statement Stmt = conn.createStatement();
            
            System.out.println("Creating the Table TinitiateLOBtestTab..");
            // Execute the Statement, To Create Table, Variable value declared above. 
            try {
                Stmt.execute(OraDDLCreate);
            } // If the Table Exists.
            catch (SQLException ExpTableExists) {
                System.out.println("Table Already Exists..");
                System.out.println("Dropping Table TinitiateLOBtestTab..");
                Stmt.execute(OraDDLDrop);
                System.out.println("ReCreating Table TinitiateLOBtestTab..");
                Stmt.execute(OraDDLCreate);
            }
            //Stmt.executeQuery(select * from TinitiateLOBtestTab);

            // * --[ Create CLOB data to insert into Table ]--
            // Create CLOB Data for the INSERT
            // Create a String with characters > than 32K
            String s1 = "a";

            // s1: Creating a String Greater than 32K Characters (oracle Varchar2 Limit)
            for (int i=1; i<50000; i++)
                s1 = s1 + "a";

            // Concat some other character other than "a" to Denote end of String s1
            s1 = s1 + "X";

            // * --| Create BLOB Data for the INSERT |--
            // * Create a Byte Array of data
            byte[] blobData1 = { 1,2,3,4,5,6,7,8,9,10 };
            byte[] blobData2 = { 66,33,44,11,22,88 };
            
            // * Create InputStream for the setBlob() 
            InputStream insBlob1 = new ByteArrayInputStream(blobData1);
            InputStream insBlob2 = new ByteArrayInputStream(blobData2);

            PreparedStatement PStmt = conn.prepareStatement(insLOBtestTab);
            // Insert Row1
            // Create the OraclePreparedStatement object
            OraclePreparedStatement oraPStmt = (OraclePreparedStatement)conn.prepareStatement(insLOBtestTab);
            oraPStmt.setInt(1,1);
            oraPStmt.setString(2,"Row-1");
            oraPStmt.setStringForClob(3,s1);
            oraPStmt.setBlob(4, insBlob1);
            // Execute the Prepared Insert Statement
            oraPStmt.executeUpdate();
            // Insert Row2            
            oraPStmt.setInt(1,2);
            oraPStmt.setString(2,"Row-2");
            oraPStmt.setStringForClob(3,s1);
            oraPStmt.setBlob(4, insBlob2);
            // Execute the Prepared Insert Statement
            oraPStmt.executeUpdate();


            OutputStream OSClobData1 = new BufferedOutputStream
            ( new FileOutputStream("c:\\tinitiate\\ClobData1.txt"));

            OutputStream OSClobData2 = new BufferedOutputStream
            ( new FileOutputStream("c:\\tinitiate\\ClobData2.txt"));

            OutputStream OSBlobData1 = new BufferedOutputStream
            ( new FileOutputStream("c:\\tinitiate\\BlobData1.txt"));

            OutputStream OSBlobData2 = new BufferedOutputStream
            ( new FileOutputStream("c:\\tinitiate\\BlobData2.txt"));

            // Create a byte array 
            byte OutData[] = new byte[300];

            // Print and Get the results
            oraPStmt = (OraclePreparedStatement)conn.prepareStatement("select * from TinitiateLOBtestTab");
            ResultSet rSet = oraPStmt.executeQuery();
            System.out.println("tID" + "\t\t" + "tName" + "\t\t" + "colCLOB-Length");
            while (rSet.next()) {
                System.out.println(rSet.getInt(1) + "\t\t" + rSet.getString(2) + "\t\t" + rSet.getClob(3).length());
                System.out.println("Writing Clob to File...");

                // Data to write 
                String SomeData = rSet.getString(3); 

                // Convert String to ByteArray 
                OutData = SomeData.getBytes();

                // Write CLOBs to File
                if (rSet.getInt(1) == 1) {
                    // Write data using the write(byte array) method. 
                    OSClobData1.write(OutData);
                    OSClobData1.flush();
                }
                if (rSet.getInt(1) == 2) {
                    // Write data using the write(byte array) method. 
                    OSClobData2.write(OutData);
                    OSClobData2.flush();
                }

                // Write BLOBs to File
                if (rSet.getInt(1) == 1) {
                    // Write data using the write(byte array) method. 
                    OSBlobData1.write(rSet.getBytes(4));
                    OSBlobData1.flush();
                }
                if (rSet.getInt(1) == 2) {
                    // Write data using the write(byte array) method. 
                    OSBlobData2.write(rSet.getBytes(4));
                    OSBlobData2.flush();
                }
            }

            System.out.println("");
            System.out.println("Dropping table TinitiateLOBtestTab...");
            PStmt = conn.prepareStatement(OraDDLDrop);
            PStmt.execute();
            System.out.println("");
            System.out.println("X---Program Execution Completed---X");
        }
        catch (Exception E) { E.printStackTrace(); }
    }
}
