package JavaExceptions;
import java.io.*;
public class ExceptionBasics
{

    /**
     * TINITIATE.COM
     * --> T..O..P..I..C
     * Exceptions Basics
	 * 
	 * Exception: After the successful code compilation,
	 *            Failure of Code can occur during execution
	 *            these are exceptions.
	 *     1)Reasons:
	 *         1.1) Invalid data, assignment to a datatype
	 *         1.2) UnHandled operation
	 *         1.3) Invalid Array Index
	 *         1.4) Reasons could be many.
	 *
	 *     2) There are THREE types of Exceptions
	 *        2.1) Checked Exception: These are exceptional conditions that 
	 *                                well-written CODE should anticipate 
	 *                                and recover from.
	 *
	 *        2.2) Errors Exceptions: These are not subject to the Catch.
	 *                                Errors Exceptions are indicated 
	 *                                by Error and its subclasses.
     *
     *        2.3) Runtime exception: These are exceptional conditions that are 
     *                                application specific. They could be programming bugs
     *                                and logic errors.
     *
	 *     3) Understanding Exceptions:
	 *         3.1) "try { ..code .. }" Block:
     *                   Place the code that might throw an exception within a try block.
     *         
     *         3.2) "catch(Name-Of-Exception-To-Be-Handled) { ..Exception handling code.. }" Block:
     *                   A try block is associated with one or more catch blocks placed 
     *                   directly after the try block.
     *                   No code can be between the end of the try block and the beginning 
     *                   of the first catch block.
     *         3.3) "finally
     *                The finally block always executes when the try block exits.
     *                This ensures that the finally block is executed even if an unexpected 
     *                exception occurs.
     *         
     *         
     */
	   public static void main(String args[])
	   {
	      /**
	       *  Exception example with try{}catch{} and finally{}
	       */
		  int[] numArray = new int[4];
	      System.out.println("Code Block Start");
		  try
	      {
	         System.out.println("Access element SIX :" + numArray[6]);
	         System.out.println("This line will never be executed");
	      }
		  // Cannot have CODE here !!
	      catch(ArrayIndexOutOfBoundsException e)
	      {
	         System.out.println("The Array numArray Has only "+ numArray.length +" elements. "+ e);
	         System.out.println(e.getMessage());
	         System.out.println(e.toString());
	         e.printStackTrace();
	      }
	      finally
	      {
	    	  System.out.println("Executing finally");
	      }
	      System.out.println("Code Block End");
	   }
}
