package JavaIO;
import java.io.Console;

/** 
 * @author TINITIATE.COM
 * 
 * TOPIC   : Java IO, Reading from Console using Console class
 * 
 * CLASS   : Console, Reading  user Input [Requires the Package "java.io"]
 * PURPOSE : 1) Reading from Console.
 *
 */

// Custom Exception class.
class Application_Exception extends Exception 
{
	public Application_Exception(String msg)
	{
		System.out.println("This is not a console call, Plese use command line, to call this class file.");
	}
}

public class JavaReadingUserInput2
{
	public static void main(String[] args)
	{

	    System.out.println("Example: Reading Chars from console.");
	    System.out.println("!! Must run this from Console.");
		System.out.println("");

		//-------
        try
        {
	        // Read Input and print it back, until "quit" is entered
     	    Console con = System.console();
 		    String i_String = "";
     	    if(con != null)
     	    {
     		    System.out.println("Enter text String:");
    	        System.out.println("Enter, 'quit' to exit the program.");
    	        do
    	        {
    	    	    i_String = con.readLine();
    	            System.out.println(i_String);
    	        }   while(!i_String.toUpperCase().equals("QUIT"));     		
     	    }
     	    else { throw new Application_Exception("Not Called From Console."); }
        }
        catch (Application_Exception e1)
        {
        	e1.printStackTrace();
        }
     	catch (Exception e_all)
        {
        	e_all.printStackTrace();
        }
	}
}
