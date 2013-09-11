package JavaIO;
import java.util.Scanner;

/** 
 * @author TINITIATE.COM
 * 
 * TOPIC   : Java IO, Reading from Console using Scanner class
 * 
 * CLASS   : Scanner user Input [Requires the Package "java.util"]
 * PURPOSE : 1) Reading from Console.
 *
 */
public class JavaReadingUserInput3
{
	public static void main(String[] args)
	{
		Scanner ReadUserInput = new Scanner( System.in );
		String UserEnteredText;

		System.out.println("Enter, 'quit' to exit the program.");
		System.out.print("Enter Text: ");

	    do
	    {
	    	UserEnteredText = ReadUserInput.next();
	        System.out.println(UserEnteredText);
	    }   while(!UserEnteredText.toUpperCase().equals("QUIT"));
	}
}
