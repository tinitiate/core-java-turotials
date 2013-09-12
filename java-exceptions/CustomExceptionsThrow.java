package JavaExceptions;
/**
 *  @author TINITIATE.COM
 *  
 *  Creating Custom exceptions, Inheriting the Exception Class.
 *  "Throwable" objects are instances of any subclass of the "Throwable" class.
 *  Create class to handle custom exceptions.
 *  There must be a code somewhere in the program that might raise the custom exception.
 *  The "throw" keyword with an object reference raises the exception. 
 *  A single argument is required by the throw statement i.e. a "Throwable" object. 
 *   
 *  Difference between throw and throws keywords
 *     To forcibly raise an exception, use throw keyword. 
 *     The throw keyword (note the singular form) is used to force an exception. 
 *     Allows Passing a custom message to your exception handling module. 
 *
 */
class MyCustomException extends Exception 
{
	public MyCustomException(String msg)
	{
		System.out.println(msg);
	}
}

public class CustomExceptionsThrow 
{
    public static void checkEmployeeBonus (double d,double e) throws MyCustomException
	{ 
        if (e > d/2)
        {
        	throw new MyCustomException("Too Much Bonus");
        }
	}
    public static void main(String[] args) 
    {
	    try 
	    {
		    System.out.println("Checking Employee Bonus, with SAL = 5000.00 and Bonus = 3000.00.");
		    checkEmployeeBonus (5000.00,3000.00);
		}
		catch (MyCustomException exc) 
		{
		    exc.printStackTrace();
		}
	}
}
