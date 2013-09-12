package JavaExceptions;
import java.io.*;
public class ExceptionMultiCatch {

	/**
	 * 
	 * Multiple Catch blocks for a single try
	 * Always make sure the catch(Exception e) is in the end
	 * This is generic class to Handle the Unreachable Code, or "all-else" scenario
	 *  
	 */
	public static void main(String[] args) {
	      /**
	       *  Exception example with try{}catch{} and finally{}
	       */
		  int a1;
		  int a2;
	      System.out.println("Code Block Start");
		  try
	      {
	         a2 = 100;
	         System.out.println("Trying to divide by Zero.");
	         a1=a2/0;
	         System.out.println("This line will never be executed");
	      }
	      catch(ArithmeticException  e)
	      {
	         System.out.println("Arithmetic Error "+ e);
	         System.out.println(e.getMessage());
	         System.out.println(e.toString());
	         e.printStackTrace();
             StackTraceElement elements[] = e.getStackTrace();
	         for (int i = 0, n = elements.length; i < n; i++) 
	         {       
	             System.err.println(elements[i].getFileName()
	                              + ":" + elements[i].getLineNumber() 
	        	                  + ">> "
	        	                  + elements[i].getMethodName() + "()");
        	}
	      }
		  catch(Exception e1)
		  {
			  System.out.println("Generic Exception. Should be placed in the end.");
		  }
	      finally
	      {
	    	  System.out.println("Executing finally");
	      }
	      System.out.println("Code Block End");
	}

}
