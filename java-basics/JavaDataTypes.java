package JavaBasics;
import java.util.*; // Importing a Built-In Package

public class JavaDataTypes
{
	// Static variables, Will change values through
	// out the program
	static int i;  // Declaration, but no initialization of i
	static int j=20; // Declaration and Initialization of j
	public static void main(String[] args)
	{

		/*==============================================*/
		/* TINITIATE.COM								*/
		/* --> T..O..P..I..C  							*/
		/* Data Types Basics 							*/
		/*==============================================*/		
		byte b;
		int p=233;
		// Floating-point literals in Java are set to double by default.
		// For a float literal, "F" or "f" must be appended to the constant.
		float f=7.1f; // Appended "f" to make it work
		double d= .991;
		// Printing Date
		System.out.println(new Date());

		i=100;
		// Printing the Initialization of i
		System.out.println("Value of i is: " + i);

		//Type Casting in Java
		b = (byte) p;
		System.out.println("Byte Value of i is: " + b);

		// Printing Float / Double Values
		System.out.println("Value of f and d are: "+f+ " and " + d);


		/*==============================================*/
		/* TINITIATE.COM								*/
		/* --> T..O..P..I..C  							*/
		/* Escape Character Sequences 					*/
		/*==============================================*/		

		String s;
		s="\'";
		System.out.println("Escape Character Single Quote: " + s);

		s=" This is the words";
		System.out.println("Escape Character Backspace: " + s+"\b");

		s="Hello";
		System.out.println("Escape Character NewLine: " + s+"\n"+s);

		s="Hello";
		System.out.println("Escape Character Backspace: " + s+"\t"+s);
    //*** End of MAIN *** //
	}

	/*==============================================*/
	/* TINITIATE.COM								*/
	/* --> T..O..P..I..C  							*/
	/* Scope of Variables 							*/
	/*==============================================*/		

	public static void out_of_scope()
	{
		/* Having the Below line in the code will not compile the code. */
		//System.out.println("Value of s outside MAIN is" + s);
		
		// This line is valid because i is a static variable and is available for the whole class to use 
		System.out.println("Value of i outside MAIN is" + i);
	}	
}

