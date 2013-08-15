package JavaClassAndMethods;

/*==============================================*/
/* TINITIATE.COM                                */
/* --> T..O..P..I..C                            */
/*  Various types of CONSTRUCTORS               */
/*==============================================*/


/* 
 * SIMPLE CONSTRUCTOR
 * 
 */
class GetProduct
{
	int num1, num2;

	/*  
	 * Constructor declarations look like method declarations—except that
	 * they use the name of the class and have no return type.
	 * 
	 * Method PRODUCT() requires two arguments, an error will occur if it were called without all of them.
	 * if we want to be able to initialize the PRODUCT() with only the number of values 
	 * we need, we could use a constructor to handles this situation.
	 * 
	 */

	GetProduct(int n1,int n2)
	{
		num1=n1;
		num2=n2;
	}
	
	int product()
	{
		return num1*num1;
	}
}

/* 
 * OVERLOADED CONSTRUCTOR
 * 
 */
class GetMax
{
	int num1, num2,num3;
			
	/*  
	 * Constructor declarations look like method declarations—except that
	 * they use the name of the class and have no return type.
	 * 
	 * Method MAX() requires three arguments, an error will occur if it were called without all of them.
	 * if we want to be able to initialize the max() with only the number of values 
	 * we need, we could use a constructor to handles this situation.
	 * 
	 */
	// Constructor Overload-1 (All the three input Params)
	GetMax(int n1,int  n2,int n3)
	{
		num1=n1;
		num2=n2;
		num3=n3;
	}
	// Constructor Overload-2 (Uses two input Params)
	GetMax(int n1,int  n2)
	{
		num1=n1;
		num2=n2;
		num3=-999999999;
	}

	int max()
	{
		// Find the Greatest of the three numbers or the inputs that were provided
		int max_num = num1 > num2 ? (num1 > num3 ? num1 : num3) : (num2 > num3 ? num2 : num3);
		return max_num;
	}
}

class GetTotal
{
	int num1, num2,num3;

	/*
	 * 
	 * Constructor declarations look like method declarations—except that
	 * they use the name of the class and have no return type.
	 * 
	 * Method TOTAL() requires three arguments, an error will occur if it were called without all of them.
	 * if we want to be able to initialize the TOTAL() with only the number of values 
	 * we need, we could use a constructor to handles this situation.
	 * 
	 */
	// Constructor Overload-1 (All the three input Params)		
	GetTotal(int n1,int  n2,int n3)
	{
		num1=n1;
		num2=n2;
		num3=n3;
	}
	// Constructor Overload-2 (Uses two input Params)
	GetTotal(int n1,int  n2)
	{
		num1=n1;
		num2=n2;
		num3=0;
	}
	// Constructor Overload-2 (Uses one input Param)
	GetTotal(int n1)
	{
		num1=n1;
		num2=0;
		num3=0;
	}

	int total()
	{
		// Get the total of the three number or any inputs that were provided
		return num1+num2+num3;
	}
}

/*
 * Understanding THIS REFERENCE or the THIS KEYWORD
 * Refer to the object that invoked the class.
 * NOTE that there are TWO variables with the same name "var1" and "var2"
 * this.var1 and this.var2 will be use the class values
 * var1 and var2 will use the object values.
 * 
 */

class ThisKeywordSample
{
	private int var1=10;
	public int var2=100;
	
	public void Method1(int var1,int var2)
	{

		System.out.println("Printing the CLASS VARIABLE var1: "+ var1);
		System.out.println("Printing the OBJECT VARIABLE var1: "+ this.var1);

		System.out.println("Printing the CLASS VARIABLE var2: "+ var2);
		System.out.println("Printing the OBJECT VARIABLE var2: "+ this.var2);

	}
}

public class Constructor_Eample1
{
	
	public static void main(String[] args)
	{
		
		// GetProduct: Constructor
		GetProduct m = new GetProduct(5, 10);
		System.out.println("Product of 5, 10 is: "+ m.product());

		// GetMax: Calling Overload-1
		GetMax m1 = new GetMax(1, 2, 3);
		System.out.println("Greatest of 1,2,3 is: "+ m1.max());

		// GetMax: Calling Overload-2
		GetMax m2 = new GetMax(99, 21);
		System.out.println("Greatest of 99, 21 is: "+ m2.max());

		// GetSum: Calling Overload-1
		GetTotal m11 = new GetTotal(1, 2, 3);
		System.out.println("Sum of 1,2,3 is: "+ m11.total());

		// GetSum: Calling Overload-2
		GetTotal m12 = new GetTotal(100, 99);
		System.out.println("Sum of 100, 99 is: "+ m12.total());

		/*
		 * Understanding THIS REFERENCE or the THIS KEYWORD
		 * this.var1 and this.var2 will be use the class values
		 * var1 and var2 will use the object values.
		 */

		ThisKeywordSample ThisSample = new ThisKeywordSample();
		ThisSample.Method1(20,200);
	}
}
