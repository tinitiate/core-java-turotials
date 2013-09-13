package JavaPackagesAndInterfaces;
/**
 *  @author TINITIATE.COM
 *  Notes:  This call implements the interface "JavaInterface"
 *
 */
public class JavaInterfaceEatHealthy implements JavaInterface
{
    // Methods with body from the interface JavaInterface
	public void food()
	{
        System.out.println("Eat Salad.");
	}
    public void drink()
    {
        System.out.println("Drink Green Tea.");
    }
    public void dressing()
    {
        System.out.println("Lite italian dressing for Salad.");
    }
    public void side()
    {
        System.out.println("Low salt crackers.");
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
		JavaInterfaceEatHealthy obj1 = new JavaInterfaceEatHealthy();
		obj1.food();
		obj1.dressing();
		obj1.drink();
		obj1.side();
		// Test Method to call the interface Fields(Variables)
		obj1.TestUseInterfaceFields();
	}
}
