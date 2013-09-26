package JavaDatabaseProgramming;

import java.sql.*;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleTypes;

//
// * @author TINITIATE.COM
//
// * @topic :  JAVA Oracle PROCEDURE Examples
//
// * @notes : 1) This Class demonstrates examples to perform various Oracle Operations, Through Java.
// *          2) Executing Oracle Stored Procedure from Java
// *          3) Calling Oracle Stored Procedure with IN Parameters from Java
// *          4) Calling Oracle Stored Procedure with IN and OUT Parameters from Java
// *          5) Calling Oracle Stored Procedure with IN - OUT Parameters from Java
// *          6) Calling Oracle Package.Procedure with IN, OUT, IN-OUT Parameters from Java
// *          7) Calling Oracle Procedure, with RefCursors / OUT REF Cursors, from Java
// *          8) Calling Oracle procedure with "Oracle Custom Types" Params
// *        TO RUN THIS PROGRAM PLEASE SETUP THE CONNECTION PARAMETERS, BELOW      
// *         +----------------------------------------+
// *         | CONNECTION [SETUP - INSTRUCTIONS]      |
// *         +----------------------------------------+
// *
// *         *# THIS PROGRAM CREATES ORACLE PROCEDURES #*   
// *

public class JavaOracleProcedureExample {

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

    // * ---- CREATE STORED PROCS ----
    
    // * +-------------------------------------------+ 
    // * | Oracle Stored Procedure with IN Parameters|
    // * +-------------------------------------------+
    
    static String OraProcINParams =  
        " create or replace procedure tinitiateIPProc (pDate IN date) "   +
        "\n as "                                                          +   
        "\n    l_date date; "                                             +
        "\n begin "                                                       +
        "\n    l_date := pDate; "                                         +
        "\n    -- Do Something with l_date "                              +
        "\n end;";

    // * +---------------------------------------------------+ 
    // * | Oracle Stored Procedure with IN and OUT Parameters|
    // * +---------------------------------------------------+
    static String OraProcInOutParams =
        " create or replace procedure tinitiateIOPProc"                               +
        "\n                                  (pINnumber IN int, pOUTnumber OUT int) " +
        "\n as "                                                                      +
        "\n begin "                                                                   +
        "\n     -- Add 10 to the pINnumber "                                          +
        "\n    pOUTnumber := pINnumber + 10;"                                         +
        "\n end;";  

    // * +-------------------------------------------------------------+ 
    // * | Oracle Stored Procedure with IN, OUT and IN - OUT Parameters|
    // * +-------------------------------------------------------------+
    static String OraProcIOInOutParams =
        "  create or replace procedure tinitiateIOIOPProc "                       +
        "\n     (pINnumber IN int, pInOutnumber In OUT int, pOUTnumber OUT int) " +
        "\n as "                                                                  +
        "\n begin "                                                               +
        "\n     -- Add 10 to the pINnumber as pOUTnumber "                        +
        "\n     pOUTnumber := pINnumber + 10; "                                   +
        "\n     -- Add pINnumber and pInOutnumber as pInOutnumber; "              +
        "\n     pInOutnumber := pINnumber + pInOutnumber; "                       +
        "\n end; ";  

    // * +---------------------------------------------------+ 
    // * | Oracle Stored Procedure with RefCursors Parameters|
    // * +---------------------------------------------------+
    // Code for the Spec of the Package
    static String OraProcRefCursorPkgSpec =  
        " create or replace package tinitiatePKG "                       +    
        "\n as "                                                         +
        "\n    type t_refcursor          is  ref cursor; "               +
        "\n    procedure tinitiateRFProc (pRefCursor OUT t_refcursor); " +
        "\n end; ";

    // Code for the Body of the Package
    static String OraProcRefCursorPkgBody =
        " create or replace package body tinitiatePKG "                +
        "\n as "                                                       +
        "\n   procedure tinitiateRFProc (pRefCursor OUT t_refcursor) " +
        "\n   as "                                                     +
        "\n   begin "                                                  +
        "\n       -- Random SQL Statement, With Various DataTypes "    +
        "\n       open pRefCursor "                                    +
        "\n       for "                                                +    
        "\n       select 1                as aNumber, "                +
        "\n              'Row-1'          as astring, "                + 
        "\n              sysdate-1        as aDate, "                  + 
        "\n              systimestamp-100 as aTimeStamp "              + 
        "\n       from dual "                                          + 
        "\n       union all "                                          + 
        "\n       select 2                as aNumber, "                + 
        "\n              'Row-2'          as astring, "                + 
        "\n              sysdate-2        as aDate, "                  + 
        "\n              systimestamp-200 as aTimeStamp "              +
        "\n       from dual; "                                         +
        "\n   end; "                                                   +
        "\n end; "; 

    // * +--------------------------------------------------------+ 
    // * | Oracle Stored Procedure with CUSTOM Types as Parameters|
    // * +--------------------------------------------------------+

    public static void main(String[] args) {
        
        try {
            // Create the DB Connection Object
            Connection conn = DriverManager.getConnection(url, schema, password);
    
            // Create a Statement Object to Create all the StoredProcs
            Statement Stmt = conn.createStatement();
            
            // Create a CallableStatement Object
            // This can be used to Run the Procs and pass and retrieve parameters
            CallableStatement CStmt;

            // ------------------------------------------------------------
            // --[ Oracle Stored Procedure with IN Parameters ]
            // * Execute the PROC: , It Has 1 input Param and does nothing.
            // ------------------------------------------------------------
            // String to Call the Proc
            String CallOraProcINParams = "call tinitiateIPProc(?)";
            // Create the Oracle Stored Procedure with IN Parameters
            Stmt.execute(OraProcINParams);
            System.out.println("Procedure tinitiateIPProc() Created in "+ schema + "Schema..");
            // Assign the Connection to the Statement
            CStmt = conn.prepareCall(CallOraProcINParams);
            // Set the value for the InputParameter
            CStmt.setDate(1, new java.sql.Date(new java.util.Date().getDate()));
            // Execute the Oracle Stored Procedure with IN Parameters
            CStmt.execute();
            System.out.println("Executing Procedure tinitiateIPProc(), Returns nothing..");
            System.out.println("");

            // ------------------------------------------------------------
            // --[ Oracle Stored Procedure with IN and OUT Parameters ]
            // * Execute the PROC: , It Has 1 input Param and Gives out a Param
            // ------------------------------------------------------------
            // String to Call the Proc
            String CallOraProcInOutParams = "call tinitiateIOPProc(?,?)";
            // Create the Oracle Stored Procedure with IN Parameters
            Stmt.execute(OraProcInOutParams);
            System.out.println("Procedure tinitiateIOPProc() Created in "+ schema + "Schema..");
            // Assign the Connection to the Statement
            CStmt = conn.prepareCall(CallOraProcInOutParams);
            // The Out-param is an Integer
            CStmt.registerOutParameter(2, Types.INTEGER);
            // Set the Value for the Input Param
            CStmt.setInt(1, 9);
            // Execute the Oracle Stored Procedure with IN Parameters
            CStmt.execute();
            System.out.println("Executing Proceudre tinitiateIOPProc(), OUT Param Value: " + CStmt.getInt(2));
            System.out.println("");

            // ------------------------------------------------------------------
            // --[ Oracle Stored Procedure with IN, OUT and IN - OUT Parameters ]
            // * Execute the PROC: , It Has 1 IN, 1 IN-OUT and 1 OUT Parameter.
            // ------------------------------------------------------------------
            // String to Call the Proc
            String CallOraProcIOInOutParams = "call tinitiateIOIOPProc(?,?,?)";
            // Create the Oracle Stored Procedure with IN, OUT and IN - OUT Parameters
            Stmt.execute(OraProcIOInOutParams);
            System.out.println("Procedure tinitiateIOIOPProc() Created in "+ schema + "Schema..");
            // Assign the Connection to the Statement
            CStmt = conn.prepareCall(CallOraProcIOInOutParams);
            // Set the value for the InputParameter
            CStmt.setInt(1, 99);
            // The IN-OUT param:
                // Setting the IN aspect as Integer
                CStmt.setInt(2, 99);
                // Setting the OUT aspect as Integer
                CStmt.registerOutParameter(2, Types.INTEGER);
            // The Out-param is an Integer
            CStmt.registerOutParameter(3, Types.INTEGER);
            // Execute the Oracle Stored Procedure with IN, OUT and IN - OUT Parameters
            CStmt.execute();
            System.out.println("Executing Proceudre tinitiateIOIOPProc(), IN-OUT Param Value " + CStmt.getInt(2));
            System.out.println("Executing Proceudre tinitiateIOIOPProc(), OUT Param Value " + CStmt.getInt(3));
            System.out.println("");

            // -----------------------------------------------
            // --[ Oracle Stored Procedure with RefCursor ]
            // * Execute the PROC: , This Returns a RefCursor
            // -----------------------------------------------
            // String to Call the Proc (This is a Pacakge.Procedure call
            String CallOraProcRefCursor = "call tinitiatePKG.tinitiateRFProc(?)";
            // Create the Oracle Package with the RefCursor PROC
            Stmt.execute(OraProcRefCursorPkgSpec);
            Stmt.execute(OraProcRefCursorPkgBody);
            System.out.println("Package tinitiatePKG Created in "+ schema + "Schema..");
            System.out.println("");

            // +-----------------------------------------------------+
            // | METHOD - I (Oracle Procedure with RefCursor)        |
            // | USING : OracleCallableStatement and OracleResultSet |
            // +-----------------------------------------------------+

                
            // Create Objects for OracleCallableStatement and OracleResultSet Classes
            // This is to Handle Oracle Specific RefCursor
            OracleCallableStatement oraCStmt = null;
            OracleResultSet         oraRSet  = null;
            System.out.println("Method-I Working with Oracle RefCursor, "+
                               " Using Classes OracleCallableStatement and OracleResultSet.");
            // Cast the connection ObjectprepareCall as OracleCallableStatement
            oraCStmt = (OracleCallableStatement)conn.prepareCall(CallOraProcRefCursor);
            // Register variable to Capture the RefCursor, Using OracleTypes.CURSOR
            oraCStmt.registerOutParameter(1, OracleTypes.CURSOR);
            // Execute the  Oracle Stored Procedure with RefCursor
            oraCStmt.execute();
            System.out.println("Executing Package tinitiatepkg...");
            // Capture the Results into the OracleResultSet
            // Cast the OracleCallableStatement.getCursor to OracleResultSet return type.
            oraRSet = (OracleResultSet)oraCStmt.getCursor(1);
            System.out.println("Printing Results..");
            System.out.println("aNumber\t\tastring\t\taDate\t\taTimeStamp");
            // Loop Through the OracleResultSet to print values
            while (oraRSet.next()) {
                System.out.println(oraRSet.getInt(1) + "\t\t" + oraRSet.getString(2) + "\t\t" +
                                   oraRSet.getDate(3) + "\t" + oraRSet.getTimestamp(4));
            }
            System.out.println("");

            // +-----------------------------------------------+
            // | METHOD - II (Oracle Procedure with RefCursor) |
            // | USING : CallableStatement and ResultSet       |
            // +-----------------------------------------------+
            // Create Objects for CallableStatement and ResultSet Classes
            // This is to Handle Oracle Specific RefCursor
            CallableStatement CSt = null;
            ResultSet RSt         = null;
            System.out.println("Method-II Working with Oracle RefCursor, "+
                               " Using Classes CallableStatement and ResultSet.");
            // Assign the Connection to the Statement and the RefCursor Proc
            CSt = conn.prepareCall(CallOraProcRefCursor);
            // Assign parameter to capture the RefCursor 
            CSt.registerOutParameter(1, OracleTypes.CURSOR);
            // Execute the Proc that has the RefCursor
            CSt.execute();
            // Capture the Results into the ResultSet Object by casting the getObject's result
            RSt = (ResultSet)CSt.getObject(1);
            System.out.println("Printing Results..");
            System.out.println("aNumber\t\tastring\t\taDate\t\taTimeStamp");
            // Loop Through the OracleResultSet to print values
            while (RSt.next()) {
                System.out.println(RSt.getInt(1) + "\t\t" + RSt.getString(2) + "\t\t" +
                                   RSt.getDate(3) + "\t" + RSt.getTimestamp(4));
            }
        }
        catch (Exception e) { e.printStackTrace(); }

        // Drop all Objects
        try {
            // Create the DB Connection Object
            Connection conn = DriverManager.getConnection(url, schema, password);
            // Create a Statement Object to Create all the StoredProcs
            Statement Stmt = conn.createStatement();
            System.out.println("");
            System.out.println("Dropping tinitiateioiopproc...");
            Stmt.execute("drop procedure tinitiateioiopproc");
            System.out.println("Dropping tinitiateipproc...");
            Stmt.execute("drop procedure tinitiateipproc");
            System.out.println("Dropping tinitiateiopproc...");
    		Stmt.execute("drop procedure tinitiateiopproc");
    		System.out.println("Dropping tinitiatepkg...");
            Stmt.execute("drop package tinitiatepkg");
        } catch (Exception ed) { ed.printStackTrace(); }
    }
}
