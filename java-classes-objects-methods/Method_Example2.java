package JavaClassAndMethods;

/*==============================================*/
/* TINITIATE.COM				                */
/* --> T..O..P..I..C  				            */
/*  Various types of METHODS - 2                */
/*==============================================*/


// * Class to that has all the types of methods
 class MoreMethods
{
    /*
     *  OverLoaded methods:
     *  Same name, and different input parameters
     *  In this class there are two Methods with the name over_load
     *  The first one has no input parameter.
     *  The second one has one input parameter 
     */
	void over_load ()
	{
		System.out.println("This is the first overloaded method with no params");
	}
	
	void over_load(String s)
	{
		System.out.println("This is the second overloaded method with a string param: "+ s);
	}

	/* "finalize" is a KEYWORD, this is a built-in 
	 *  method that is called after the object (class) is done
	 *  executing all the methods it called and protected means it cannot be accessed outside the class.
	 *  It is important to understand that finalize( ) is only called just prior to garbage collection.
	 *  It is not called when an object goes out-of-scope:
	 *  Developer cannot know when—or even if—finalize() will be executed.
	 *  Therefore, your program should provide means of releasing system resources used by the object
	 *  Developers must NOT rely on finalize() for normal program operation. 
	 */
	protected void finalize()
	{
		System.out.println("**** FINALIZING ****");
	}

	Object test1()
	{
		return null;
	}

	public Object main(String[] args) {
		// TODO Auto-generated method stub
		return "AAA";
	}

}

public class Method_Example2
{
	// Call the Class MoreMethods from this class
	public static void main(String[] args)
	{
		MoreMethods m1 = new MoreMethods();
		m1.over_load();
		m1.over_load("Calling method with a Parameter");
		System.out.println(m1.hashCode());
		System.out.println(m1.toString());
		System.out.println(m1.getClass());
		System.out.println(m1.main(args));
	}
}
