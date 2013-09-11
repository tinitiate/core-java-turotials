package JavaIO;
import java.io.*;
/** 
 * @author TINITIATE.COM
 * 
 * TOPIC   : Java IO, Reading from Console using InputStreamReader class
 * 
 * CLASS   : BufferedReader, Reading  user Input [Requires the Package "java.io"]
 * PURPOSE : 1) Reading Characters from Console.
 *           2) Reading Strings from Console.
 *
 */
public class JavaReadingUserInput1
{
	public static void main(String[] args) throws IOException
	{
		System.out.println("Example (1) Reading Chars from console.");
		System.out.println("Example (2) Reading Strings from Console.");
		System.out.println("");

		//-------
		System.out.println("(1) Reading Chars from console.");
		char pChar;
	    // BufferedReader using InputStreamReader with System.in
	    BufferedReader brObj1 = new BufferedReader(new InputStreamReader(System.in));
	    System.out.println("Char reader.");
	    System.out.println("Enter text String:");
	    System.out.println("Enter, 'q' or 'Q' to quit.");
	    // Read characters and print them, until Q or q is entered
	    do
	    {
	    	pChar = (char) brObj1.read();
	        System.out.println(pChar);
	    }   while(pChar != 'q' && pChar != 'Q');

		//-------
	    System.out.println("Example (2) Reading Strings from Console.");
	    // Create a BufferedReader using System.in
	    BufferedReader brObj2 = new BufferedReader(new InputStreamReader(System.in));
	    String pString;
	    System.out.println("String reader.");
	    System.out.println("Enter text String:");
	    System.out.println("Enter, 'quit' to exit the program.");
    	pString = brObj2.readLine();
        System.out.println(pString.toUpperCase());
	    do
	    {
	    	pString = brObj2.readLine();
	        System.out.println(pString);
	    }   while(!pString.toUpperCase().equals("QUIT"));
	}
}
