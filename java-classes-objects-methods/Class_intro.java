package JavaClassAndMethods;

/*==============================================*/
/* TINITIATE.COM				                */
/* --> T..O..P..I..C  				            */
/*  CLASS, VARIABLES, METHODS, OBJECTS			*/
/*==============================================*/

// Instance Variables
class Class_demo
{
	 int var_Class_demo_int=9009;
	 String var_Class_demo_string="This is the Class: Class_demo";

	// Class Method
	public void print_statement()
	{
		System.out.println("This is message from the method: print_statement in the class: Class_demo");
	}
}

// This is the Class with the Main. This is the entry point into this Java Program
public class Class_Intro 
{
	// Class Main Method, There is only one Main method in any class
	public static void main(String[] args)
	{
		// Create an object: MyFirstObject to use the methods and variables of the class "Class_Demo"
		Class_demo MyFirstObject = new Class_demo();
		
		//Reading the Instance variables of Class_Demo using the MyFirstObject
		System.out.println("Reading the first Instance variable of Class_Demo using the MyFirstObject: " + 
						   MyFirstObject.var_Class_demo_int);

		System.out.println("Reading the Second Instance variable of Class_Demo using the MyFirstObject " + 
				   MyFirstObject.var_Class_demo_string);
		
		//Calling the method from the of Class_Demo using the MyFirstObject
		MyFirstObject.print_statement();
	}
}
