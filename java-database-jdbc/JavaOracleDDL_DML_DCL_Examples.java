package JavaDatabaseProgramming;

import java.sql.*;

//
// * @author TINITIATE.COM
//
// * @topic :  JAVA Oracle DDL Examples
//
// * @notes : 1) This Class demonstrates examples to perform various Oracle Operations, Through Java.
// *          2) Executing DDL from Java, [DDL Data Definition Language; (Create, Alter, Drop).
// *          3) Executing DCL from Java  [DCL Data Control Language. (Grant, Revoke)]. 
// *          4) Executing DML from Java, [DML Data Manipulation Language. (Insert, Update, Delete, Merge)].
// *             *  Also example to use Bind Variables (PreparedStatement Object).
// *             ** EXAMPLES for Inserting Oracle TimeStamp Oracle Date from Java JDBC **
// *          5) Running Oracle SQL Query / Queries from Java and reading the output.
// *          TO RUN THIS PROGRAM PLEASE SETUP THE CONNECTION PARAMETERS, BELOW      
// *         +----------------------------------------+
// *         | CONNECTION [SETUP - INSTRUCTIONS]      |
// *         +----------------------------------------+
// *
// *         *# THIS PROGRAM CREATES ORACLE TABLES AND DATA #*   
// *

public class JavaOracleDDL_DML_DCL_Examples {

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
    // * | Oracle DDL Syntax Strings|
    // * | * Create Table           |
    // * | * Alter  Table           |
    // * | * Drop   Table           |
    // * +--------------------------+

    // * Create a Table (A String with a valid Create Table syntax
    static String OraDDLCreate =  " create table worldCountry "           +
                                  "    ( wcID             integer "       +
                                  "    , cName            varchar2(100) " +
                                  "    , cDirection       varchar2(10) "  +
                                  "    , internetDomain   char(2) "       +
                                  "    , TabDate          date"           +
                                  "    , dataInsertTime   timestamp)";

    // * alter a Table (A String with a valid Alter Table syntax
    static String OraDDLAlter  = "Alter table worldCountry add averageIncome number(10,4)";

    // * Drop a Table (A String with a valid Drop Table syntax
    static String OraDDLDrop  = "drop table worldCountry";
    

    // * +--------------------------+ 
    // * | Oracle DCL Syntax Strings|
    // * | * Grant on Table         |
    // * +--------------------------+
    
    // Grant Statement to simulate DCL (Data Control Language).
    static String OraTableGrant = "grant all on worldCountry to public";  

    
    // * +--------------------------+ 
    // * | Oracle DML Syntax Strings|
    // * | * Insert Statement       |
    // * | * Update Statement       |
    // * | * Delete Statement       |
    // * +--------------------------+

    // String Variables with VALID Oracle Insert statement syntax
    static String OraInsertStatement1 = "insert into worldCountry values " +
    		                            "(1,'US','WEST','US',sysdate,systimestamp,35765.356)";

    // String Variables with VALID Oracle Insert statement syntax
    static String OraInsertStatement2 = "insert into worldCountry values " +
                                        "(99,'DUMMY','WEST','DD',sysdate,systimestamp,1000.001)";

    // String Variables with VALID Oracle Insert statement syntax, to use with BIND variables
    static String OraInsertStatementTemplate = "insert into worldCountry values " +
                                               "(?,?,?,?,?,?,?)";

    static String OraUpdateStatement1 = " update worldCountry  " +
                                        " set    cName = 'USA' " +
                                        " where  cname = 'US'  ";

    static String OraDeleteStatement1 = " delete from worldCountry where cName = 'DUMMY'";

    // * This Method Accepts a ResultSet object and prints the elements in the ResultSet
    // * This is SPECFIC to the Table "WorldCountry"
    // * as the Column Names and Types are Hard coded
    public static void printResultsofWorldCountryTable(Connection c) {

        try { // Block-1
            ResultSet rSet = c.createStatement().executeQuery("Select * from WorldCountry");

            System.out.println("Current Data in the Table WorldCountry:");
            System.out.print("wcID        " + "cName      " + "cDirection       " +"internetDomain      " );
            System.out.println("TabDate        " + "dataInsertTime      ");
    
            try { //Block-2
                while(rSet.next()) {
                    System.out.print(rSet.getInt(1) + "\t\t" + rSet.getString(2) + "\t\t" + rSet.getString(3) + "\t\t" + rSet.getString(4));
                    System.out.println("\t\t" + rSet.getDate(5) + "\t\t" + rSet.getTimestamp(6));
                }
            //Block-2
            } catch (Exception Epr) { Epr.printStackTrace(); }
        // Block-1   
        } catch (Exception Ep) { Ep.printStackTrace(); }    
    }

    // Main entry into the Program
    public static void main(String[] args) {

        try {
            // Create the DB Connection Object
            Connection conn = DriverManager.getConnection(url, schema, password);

            
            // Create a Statement Object
            // Use the Statement Object to execute SQL statements
            // where in the Statements which will be executed only once
            // Like create a specific table or alters or drops
            Statement Stmt = conn.createStatement();

            System.out.println("Creating the Table WorldCountry..");
            // Execute the Statement, To Create Table, Variable value declared above. 

            try {
                Stmt.execute(OraDDLCreate);
            } // If the Table Exists.
            catch (SQLException ExpTableExists) {
                System.out.println("Table Already Exists..");
                System.out.println("Dropping Table WorldCountry..");
                Stmt.execute(OraDDLDrop);
                System.out.println("ReCreating Table WorldCountry..");
                Stmt.execute(OraDDLCreate);
            }

            System.out.println("Altering the Table WorldCountry..");
            Stmt.execute(OraDDLAlter);

            System.out.println("Giving grants to Table WorldCountry..");
            // execute the Table Grants
            // Stmt.execute(OraTableGrant);

            System.out.println("\nPrint the Contents of the Table WorldCountry...");
            // Print Contents of the Table
            printResultsofWorldCountryTable(conn);

            System.out.println("\nInserting 2 Rows into Table WorldCountry...");
            // Execute the insert statements
            Stmt.executeUpdate(OraInsertStatement1);
            Stmt.executeUpdate(OraInsertStatement2);

            System.out.println("\nPrint the Contents of the Table WorldCountry...");
            // Print Contents of the Table
            printResultsofWorldCountryTable(conn);

            System.out.println("\nUpdating and Deleting Rows in Table WorldCountry...");
            // Execute the insert statements
            Stmt.executeUpdate(OraUpdateStatement1);
            Stmt.executeUpdate(OraDeleteStatement1);

            // Create a PreparedStatement Object
            // Use the Statement Object to execute SQL statements
            // where in the SAME Statement which will be executed often
            // Like specific insert into table or select
            PreparedStatement PStmt = conn.prepareStatement(OraInsertStatementTemplate);
            PStmt.setInt(1, 2);           // Set Parameter 1 (First ?) in the OraInsertStatementTemplate query
            PStmt.setString(2, "INDIA");  // Set Parameter 2 (Second ?) in the OraInsertStatementTemplate query
            PStmt.setString(3, "EAST");   // Set Parameter 3 (Third ?) in the OraInsertStatementTemplate query
            PStmt.setString(4, "IN");     // Set Parameter 4 (Fourth ?) in the OraInsertStatementTemplate query
            // Insert oracle date from Java JDBC
            PStmt.setDate(5, new java.sql.Date(new java.util.Date().getDate()));           // Set Parameter 5 (Fifth ?) in the OraInsertStatementTemplate query
            // Insert oracle timestamp fromJava JDBC
            PStmt.setTimestamp(6, new java.sql.Timestamp(new java.util.Date().getTime())); // Set Parameter 6 (Sixth ?) in the OraInsertStatementTemplate query
            PStmt.setDouble(7, 4444.444); // Set Parameter 7 (Seventh ?) in the OraInsertStatementTemplate query

            System.out.println("\nInserting in Table WorldCountry...");
            PStmt.execute();

            PStmt.setInt(1, 3);           // Set Parameter 1 (First ?) in the OraInsertStatementTemplate query
            PStmt.setString(2, "CHINA");  // Set Parameter 2 (Second ?) in the OraInsertStatementTemplate query
            PStmt.setString(3, "EAST");   // Set Parameter 3 (Third ?) in the OraInsertStatementTemplate query
            PStmt.setString(4, "CN");     // Set Parameter 4 (Fourth ?) in the OraInsertStatementTemplate query
            // Insert oracle date using Java JDBC
            PStmt.setDate(5, new java.sql.Date(new java.util.Date().getDate()));           // Set Parameter 5 (Fifth ?) in the OraInsertStatementTemplate query
            // Insert oracle timestamp using Java JDBC
            PStmt.setTimestamp(6, new java.sql.Timestamp(new java.util.Date().getTime())); // Set Parameter 6 (Sixth ?) in the OraInsertStatementTemplate query
            PStmt.setDouble(7, 4444.444); // Set Parameter 7 (Seventh ?) in the OraInsertStatementTemplate query

            System.out.println("\nInserting in Table WorldCountry...");
            PStmt.execute();

            // Commit the Transactions in the Given Connection
            conn.commit();

            System.out.println("\nPrint the Contents of the Table WorldCountry...");
            // Print Contents of the Table
            printResultsofWorldCountryTable(conn);

            System.out.println("\nDrop the Table WorldCountry...");
            // Run the Drop DDL Statement
            Stmt.executeUpdate(OraDDLDrop);

            Stmt.close();
            PStmt.close();
            conn.close();
        }
        catch (SQLException s) { s.printStackTrace();}
        catch (Exception e) { e.printStackTrace();}
    }
}
