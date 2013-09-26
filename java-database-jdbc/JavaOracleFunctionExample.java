package JavaDatabaseProgramming;

import java.sql.*;

//
// * @author TINITIATE.COM
//
// * @topic :  JAVA Oracle FUNCTION Examples
//
// * @notes : 1) This Class demonstrates examples to perform various Oracle Operations, Through Java.
// *          2) Calling Oracle Function with return type from Java.
// *          2) Calling Oracle Function with IN, OUT, IN-OUT Parameters from Java.
// *          3) Calling Oracle Pipelined Function, from Java.
// *
// *        TO RUN THIS PROGRAM PLEASE SETUP THE CONNECTION PARAMETERS, BELOW      
// *         +----------------------------------------+
// *         | CONNECTION [SETUP - INSTRUCTIONS]      |
// *         +----------------------------------------+
// *
// *         *# THIS PROGRAM CREATES ORACLE FUNCTIONS #*   
// *
public class JavaOracleFunctionExample {

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

    // * ---- CREATE ORACLE FUNCTIONS ----
    
    // * +------------------------------------------------------+ 
    // * | Oracle FUNCTION with IN, OUT and IN - OUT Parameters |
    // * +------------------------------------------------------+
    static String OraFuncInOutParams =
        "  create or replace function tinitiateIOPFunc "                          +
        "\n     (pINnumber IN int, pInOutnumber In OUT int, pOUTnumber OUT int) " +
        "\n return int "                                                          +
        "\n as "                                                                  +
        "\n begin "                                                               +
        "\n     -- Add 10 to the pINnumber as pOUTnumber "                        +
        "\n     pOUTnumber := pINnumber + 10; "                                   +
        "\n     -- Add pINnumber and pInOutnumber as pInOutnumber; "              +
        "\n     pInOutnumber := pINnumber + pInOutnumber; "                       +
        "\n     return pOUTnumber+pInOutnumber+pINnumber; "                       +
        "\n end; ";

    // * +---------------------------+ 
    // * | Oracle PIPELINED FUNCTION |
    // * +---------------------------+
    static String OraObjectType =
        " create or replace type tinitiate_obj as object( " +
        "\n     tid    number, "                            +
        "\n     tdate  date)";

    static String OraPLTABType =
        " create or replace type tinitiate_tab is table of tinitiate_obj";

    static String OraPipeLinedFunction =
        " create or replace function tinitiate_pipe_fn (pRows in number) " + 
        "\n    return tinitiate_tab "                                      +
        "\n    pipelined as "                                              +
        "\n begin "                                                        +
        "\n   for i in 1 .. pRows loop "                                   +
        "\n     pipe row(tinitiate_obj(i, sysdate-i)); "                   +   
        "\n   end loop; "                                                  +
        "\n   return; "                                                    +
        "\n end; ";

    public static void main(String[] args) {
        try {
            // Create the DB Connection Object
            Connection conn = DriverManager.getConnection(url, schema, password);
            // Create a Statement Object to Create all the StoredProcs
            Statement Stmt = conn.createStatement();
            // Create a CallableStatement Object
            // This can be used to Run the Procs and pass and retrieve parameters
            CallableStatement CStmt;

            // ------------------------------------------------------------------
            // --[ Oracle Function with IN, OUT and IN - OUT Parameters ]
            // * Execute the Function: , It Has 1 IN, 1 IN-OUT and 1 OUT Parameter.
            // ------------------------------------------------------------------
            // String to Call the Function
            // Index 1 (First ?) is return Value, 2,3,4 are IN, IN-OUT and OUT Parameters respectfully
            String CallOraFuncInOutParams = "{ ? = call tinitiateiopfunc(?,?,?)}";
            // Create the Oracle Stored Procedure with IN, OUT and IN - OUT Parameters
            Stmt.execute(OraFuncInOutParams);
            System.out.println("Function tinitiateIOPFunc() Created in "+ schema + " Schema..");
            // Assign the Connection to the Statement
            CStmt = conn.prepareCall(CallOraFuncInOutParams);
            // Register the Return Type of the Function
            CStmt.registerOutParameter(1, Types.INTEGER);
            // Set the value for the InputParameter (Index 2 is the IN Param)
            CStmt.setInt(2, 99); // (Parameter Index, value)
            // The IN-OUT param:
                // Setting the IN aspect as Integer
                CStmt.setInt(3, 99); // (Parameter Index, value)
                // Setting the OUT aspect as Integer
                CStmt.registerOutParameter(3, Types.INTEGER); // (Parameter Index, value)
            // The Out-param is an Integer
            CStmt.registerOutParameter(4, Types.INTEGER); // (Parameter Index, value)
            // Execute the Oracle Stored Procedure with IN, OUT and IN - OUT Parameters
            CStmt.execute();
            System.out.println("Executing Function tinitiateIOPFunc()...");
            System.out.println("IN-OUT Param Value " + CStmt.getInt(3));
            System.out.println("OUT Param Value " + CStmt.getInt(4));
            System.out.println("Return Value is: " + CStmt.getInt(1));

            // -------------------------------------------------------------------+
            // --[ Oracle Pipelined Function With 1 IN Parameter ]                |  
            // * Pipelined Function: , It Has 1 IN and returns a Pipelined result |
            // -------------------------------------------------------------------+
            // String to Call the Function
            // Index 1 (First ?) is Input Param Value
            int lTestVar = 10;
            String CallOraPipeLinedFunction = "select * from table(tinitiate_pipe_fn(" + lTestVar + "))";
            // Create the Oracle Types and the PipeLined Function
            Stmt.execute(OraObjectType);
            Stmt.execute(OraPLTABType);
            Stmt.execute(OraPipeLinedFunction);
            System.out.println("Function tinitiate_pipe_fn() Created in "+ schema + " Schema..");
            // Assign the Connection to the Statement
            //CStmt = conn.prepareCall(CallOraPipeLinedFunction);
            // Set the value for the InputParameter (Index 1 is the IN Param)
            //CStmt.setInt(1, 10); // (Parameter Index, value)
            // Execute the Oracle Stored Procedure with IN, OUT and IN - OUT Parameters
            ResultSet rSet = Stmt.executeQuery(CallOraPipeLinedFunction);
            System.out.println("tID \t\t tDate");
            while (rSet.next()) {
                System.out.println(rSet.getInt(1)+ "\t\t" + rSet.getString(2)); 
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
            System.out.println("Dropping tinitiateIOPFunc...");
            Stmt.execute("drop function tinitiateIOPFunc");
            
            System.out.println("Dropping tinitiate_pipe_fn...");
            Stmt.execute("drop function tinitiate_pipe_fn");
            System.out.println("Dropping tinitiate_tab...");
            Stmt.execute("drop type tinitiate_tab");
            System.out.println("Dropping tinitiate_obj...");
            Stmt.execute("drop type tinitiate_obj");
            
        }
        catch (Exception ed) { ed.printStackTrace(); }

    }
}
