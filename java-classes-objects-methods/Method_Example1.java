package JavaClassAndMethods;

/*==============================================*/
/* TINITIATE.COM				                */
/* --> T..O..P..I..C  				            */
/*  Various types of METHODS					*/
/*==============================================*/

class MyMethods
{
	// Void Method: Method that does'nt return anything
	void display()
	{
		System.out.println("This Method doesnt return any value !!");
	}

	// Int Method:	Method returning Int value, With input parameters
	int get_sum(int value1,int value2)
	{
		return value1+value2;
	}
}
public class Method_Example1 
{
	public static void main(String[] args)
	{
		int m1_result;
		// Creating Object for the class MyMethods
		MyMethods m1 = new MyMethods();

		// Calling the Void Method
		m1.display();
        // Calling the INT method
		m1_result=m1.get_sum(1, 2);
		System.out.println("Result from the m1 Object's get_sum "+m1_result);

		int m2_result;
		// Creating Object for the class MyMethods
		MyMethods m2 = new MyMethods();

		// Calling the Void Method
		m2.display();
        // Calling the INT method
		m2_result=m2.get_sum(100, 200);
		System.out.println("Result from the m2 Object's get_sum "+m2_result);
	}
}
