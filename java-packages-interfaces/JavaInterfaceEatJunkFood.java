package JavaPackagesAndInterfaces;
/**
 *  @author TINITIATE.COM
 *  Notes:  This call implements the interface "JavaInterface"
 *
 */
public class JavaInterfaceEatJunkFood implements JavaInterface
{
	// Methods with body from the interface JavaInterface
	public void food()
	{
	       System.out.println("Eat Burger.");
	}
	public void drink()
	{
	    System.out.println("Drink soda.");
	}
	public void dressing()
	{
	    System.out.println("Ketchup and Mustard for Burger.");
	}
	public void side()
	{
	    System.out.println("Lots of fries.");
	}
	
	// Test Method to call the interface Fields(Variables)
    public void TestUseInterfaceFields()
    {
    	System.out.println("Calling the interface 'JavaInterface' variables:");
    	System.out.println("SunRiseDirection  :" + SunRiseDirection);
    	System.out.println("SunSetDirection   :" + SunSetDirection); 
    	System.out.println("waterBoilingPoint :" + waterBoilingPoint);
    }
    public static void main(String[] args)
	{
    	JavaInterfaceEatJunkFood obj1 = new JavaInterfaceEatJunkFood();
		obj1.food();
		obj1.dressing();
		obj1.drink();
		obj1.side();
		// Test Method to call the interface Fields(Variables)
		obj1.TestUseInterfaceFields();		
	}
}
