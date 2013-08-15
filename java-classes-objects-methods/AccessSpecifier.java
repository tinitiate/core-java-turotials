package JavaClassAndMethods;
/*==============================================
/* TINITIATE.COM
/* --> T..O..P..I..C
/*  Access Specifiers / Access Modifiers:
 * 			 PUBLIC, DEFAULT, PRIVATE
 */
/*==============================================*/

class AccessSpecifierDemo
{
	/* 
	 * Default: 1) Classes can be at default level.
	 * 			2) If no explicit modifier is given to a variable, class or method;
	 * 			    they will be automatically treated as Default.
	 * 			3) Access is permitted from any method only in class.
     */
	// Default Variable
	int var_def;

	// Default Method
	void DefMethod()
	{
		System.out.println("Message from Default Method");
	}
	
	/* 
	 * Public: 1) Modifier is given to a variable, class or method;Can be accessed by all
	 * 		   2) Class or methods are universally accessible
	 * 		   3) then that member can be accessed by any other code
	 */

	// Public Variable
	public int var_pub;

	// Public Method
	public void PubMethod()
	{
		System.out.println("Message from Public Method");
	}
	
	
	/*
	 *  Private: 1) Modifier is given to a variable, class or method;
	 *  		 2) Member can only be accessed by other members of its class.
	 *  		 3) Subclass cannot access private members.
	*/
	
	// Public Variable
	private int var_pri;
	
	// Public Method
	private void PrvMethod()
	{
		System.out.println("Message from Private Method");
	}

	// A public method reading the private variable
	public void PubCallPrivate_variable()
	{
		// Reading the private members
		int privateReader_ByPub = var_pri;
	}

	// A public method reading the private method
	public void PubCallPrivate_method()
	{
		// Reading the private members
		PrvMethod();
	}
	

	// A default method reading the private members
	void DefCallPrivate_variable()
	{
		// Reading the private members
		int privateReader_ByDef = var_pri;
	}

	// A default method reading the private members
	void DefCallPrivate_method()
	{
		// Reading the private members
		PrvMethod();
	}

	
}

public class AccessSpecifier 
{
	public static void main(String[] args)
	{

		// Calling / Using the Default Variable and Method
		AccessSpecifierDemo objDefault = new AccessSpecifierDemo();

		objDefault.var_def=1;
		objDefault.DefMethod();

		/*--------------------------*/

		// Calling / Using the Public Variable and Method
		AccessSpecifierDemo objPublic = new AccessSpecifierDemo();

		objPublic.var_pub=1;
		objPublic.PubMethod();

		/*--------------------------*/

		// Calling / Using the Private Variable and Method
		/*
		 * This will never compile as Private members cannot be accessed 
		 * by a class other than the one which has them.
		 * 
		 */
		
		// --->     AccessSpecifierDemo objPrivate = new AccessSpecifierDemo();
		// --->     objPrivate.var_prv=1;
		// --->     objPrivate.PrvMethod();
		
		/*
		 *  In-Order to read the Private members of a class we need to write
		 *  custom methods (Default /Public) to access them
		 */
		
		AccessSpecifierDemo objPrivate = new AccessSpecifierDemo();

		objPrivate.PubCallPrivate_variable();
		objPrivate.PubCallPrivate_method();
		
		objPrivate.DefCallPrivate_variable();
		objPrivate.DefCallPrivate_method();

	}
}
