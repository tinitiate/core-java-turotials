package JavaDatabaseProgramming;

import java.sql.*;

//
// * @author TINITIATE.COM
//
// * @topic :  JAVA JDBC Statement Class and ResultSet Class Explained
//
// * @notes : For the Program to compile FOLLOW the == CONNECTION [SETUP - INSTRUCTIONS]== (See Below)
// *          1) Upon Creating and Connecting to an RDBMS using JDBC, SQL and PL/SQL (T-SQL) Code
// *             can be executed using the Statement Class.
// *          2) A Statement object can be created from the Connection object
// *             by using the createStatement() method.
// *          3) There are 3 types of STATEMENTS when using JDBC  
// *             3.1) Statement Object: Execute SQL queries without parameters.
// *                  Usage  Statement.createStatement()
// *             3.2) Prepared Statement: Execute PreCompiled SQL queries with / without parameters.
// *                  This object enables execution of the same SQL statement multiple times, efficiently. 
// *                  PreparedStatement prepareStatement(String sql)
// *             3.3) Callable Statement: Execute a call to a database T-SQL or PL/SQL 
// *                  Code (Stored procedures, PL/SQL Anonymous Blocks..)
// *                  CallableStatement prepareCall(String sql); returns new CallableStatement object.
// *             3.4) Methods:
// *                      executeQuery():  Executes a SQL string [Must be a Query] and returns a ResultSet, 
// *                      executeUpdate(): Executes a SQL string [Any SQL: Select Query,DML,DDL..] 
// *                                       and returns a ResultSet.
// *
// *
// *
// *

public class JDBCStatementResultset {

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

    // Main entry into the Program
    public static void main(String[] args) {

        try {
            // Variable to Store the SQL.
            String l_SQL = null;

            // Create the DB Connection
            Connection conn = DriverManager.getConnection(url, schema, password);
            
            // *   +----------------------------------------+
            // *   | [Using the  Statement Object]          |
            // *   +----------------------------------------+

            System.out.println("-----------------------");
            System.out.println("Statement Object usage.");
            System.out.println("-----------------------");


            // *   Executing and Reading results from a SQL Select Statement  >>

            // Create a Statement Object
            Statement Stmt = conn.createStatement();
            // Create a valid SQL Command [Showing Multiple DataTypes]
            
            //      Value                  Column-Name
            l_SQL=" select 1            as AnInteger,  " +
                  "        2.33         as aDouble,    " +
                  "        sysdate      as aDate,      " +
                  "        systimestamp as aTimeStamp, " +
                  "        'SomeText'   as aVarchar2   " +
                  " from   dual";

            // Create a ResultSet Object, Execute the SQL String, using executeQuery(). Returns  
            ResultSet rset1 = Stmt.executeQuery(l_SQL);

            // Prints the Result Set by looping over the ResultSet
            while (rset1.next()) {

                // ResultSet Class, Supports the methods, with the Column position as Index in the SQL Statement. 
                // method: getInt(1) for Integer from SQL Statement
                // method: getDouble(2) for Double from SQL Statement
                // method: getDate(3) for Date from SQL Statement
                // method: getTimestamp(4) for Timestamp from SQL Statement
                // method: getString(5) for String from SQL Statement

                // !! Column Index starts from 1, NOT ZERO
                System.out.print(" Field [AnInteger]: "     + rset1.getInt(1));
                System.out.print(" | Field [aDouble]: "     + rset1.getDouble(2));
                System.out.print(" | Field [aDate]: "       + rset1.getDate(3)); 
                System.out.print(" | Field [aTimeStamp]: "  + rset1.getTimestamp(4));
                System.out.println(" | Field [aVarchar2]: " + rset1.getString(5));

            }

            // Close the Statement and ResultSet Object.
            Stmt.close();
            rset1.close();

            System.out.println("");
            System.out.println("");

            // *   +----------------------------------------+
            // *   | [Using the PreparedStatement Object]   |
            // *   +----------------------------------------+

            System.out.println("-------------------------------");
            System.out.println("PreparedStatement Object usage.");
            System.out.println("-------------------------------");
            // Create a SQL statement.
            // The Question Marks (?) are the parameters that are supplied to the SQL statement
            l_SQL = "SELECT object_name "     +
                    "  FROM dba_objects "     +
                    " WHERE object_type = ? " +  // Parameter(1) String "TABLE"
                    "   AND rownum      < ? ";   // Parameter(2) Int    <SomeValue>

            PreparedStatement PStmt = conn.prepareStatement(l_SQL);

            PStmt.setString(1, "TABLE");  // Set Parameter 1 (First ?) in the l_SQL query
            PStmt.setInt   (2, 6);        // Set Parameter 2 (Second ?) in the l_SQL query

            // ResultSet Object
            ResultSet rset2 = PStmt.executeQuery(); // !! DON'T, use executeQuery(l_SQL) !! 
            // Prints the Result Set
            System.out.println("Printing any Five TableNames in the Database:");
            while (rset2.next()) {
                // (1): Prints The First Column in the "rset1" [Result Set]
                System.out.println(rset2.getString(1));
            }
            System.out.println("");
            
            // Re-Using the Prepared Statement
            // Only set new values to the Parameters
            PStmt.setString(1, "VIEW");   // Set Parameter 1 (First ?) in the l_SQL query
            PStmt.setInt   (2, 11);       // Set Parameter 2 (Second ?) in the l_SQL query

            // reUse the ResultSet Object
            rset2 = PStmt.executeQuery(); // !! DON'T, use executeQuery(l_SQL) !! 
            // Prints the Result Set
            System.out.println("Printing any TEN ViewNames in the Database:");
            while (rset2.next()) {
                // (1): Prints The First Column in the "rset1" [Result Set]
                System.out.println(rset2.getString(1));
            }

            // Close the PreparedStatement and Resultset Object.
            PStmt.close();
            rset2.close();

            System.out.println("");
            System.out.println("");

            // *   +----------------------------------------+
            // *   | [Using the CallableStatement Object]   |
            // *   +----------------------------------------+

            System.out.println("-------------------------------");
            System.out.println("CallableStatement Object usage.");
            System.out.println("-------------------------------");

            // Call an Oracle Built-in Function [to_date], accepting 2 Parameters
            String l_Proc = "{? = call to_date(?,?)}";

            CallableStatement CStmt = conn.prepareCall(l_Proc);

            // Use Method registerOutParameter(), To capture the return (Index 1 in Parameter) 
            // parameter from the Oracle Function.
            CStmt.registerOutParameter(1, Types.DATE);

            // NOTE For a Function,in the "Sting l_Proc"
            // the FIRST(?) [Parameter] is the Return value
            // hence we set the Second[?] and Third[?] 
            // parameters as index 2 and 3 respectively
            CStmt.setString(2, "20121231");
            CStmt.setString(3, "YYYYMMDD");

            // Execute the Function
            CStmt.execute();
            // Print the Result
            System.out.println("Function OutPut: " + CStmt.getDate(1));

            // Close ResultSet and the Connection
            conn.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
