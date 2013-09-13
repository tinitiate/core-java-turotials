package JavaPackagesAndInterfaces;
/**
 * @author TINITIATE.COM
 *
 * > TOPIC : Java Nested Interface
 *
 * > NOTES : 1) Interface that is declared as a member of class or another interface is 
 *              nested interface or member interface 
 *           2) Nested interfaces can be declared as public, private or protected. 
 *           3) Parent or top-level interface, must either be declared as public or 
 *              left with previously mentioned access level.
 */

// Class with member interface.
class Nations 
{
    // Nested member Interface
    public interface WorldCountry 
    {
        // Method that returns the input country name
    	String countryName(String i_countryName);
    }
}
// SomeNation implements the nested interface from Nations-class
class SomeNation implements Nations.WorldCountry
{
    public String countryName(String i_countryName)
    {
        return i_countryName;
    }
}
// Testing the nested interface from the child class. 
public class JavaNestedInterface
{
	public static void main(String args[])
	{
		/**
		 * Object "objA" created a reference to interface Nations.WorldCountry, and assigned to a reference of 
		 *  "SomeNation" class, As class "SomeNation" implements the interface Nations.WorldCountry
		 */
		Nations.WorldCountry objA = new SomeNation();
		String s = objA.countryName("USA");
		System.out.println("Value of 's' is: " + s);
	}
}
