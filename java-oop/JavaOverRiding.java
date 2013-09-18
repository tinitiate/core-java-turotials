package JavaOOP;
/** 
 * @author TINITIATE.COM
 * 
 * > TOPIC : Java OOP
 *           Polymorphism: Use of common interface instead of concrete implementation 
 *                         in code  OverRiding.
 * 
 * > NOTES : 1) Overriding: override the functionality of any existing method 
 *           2) Java Inheritance provides method override 
 *           3) Methods marked as final, CANNOT be overridden.
 *           4) Method overriding only occurs when the names and signatures 
 *              of the two methods are identical. If not, they are simply overloaded.
 *
 */

class WorldCountry
{
	String CountryName;
	String LandAreaSize;
	String population;

	public void LandArea()
    {
	    System.out.println("LandArea of the Country "+ CountryName +" is: " + LandAreaSize);
	}
	public void population()
    {
	    System.out.println("population of the Country "+ CountryName +" is: " + population);
	}
}

class State extends WorldCountry
{
	String StateName;
	String LandAreaSize;
	String population;

	public void LandArea()
    {
	    System.out.println("LandArea of the State "+ StateName +" is: " + LandAreaSize);
	}
	public void population()
    {
	    System.out.println("population of the State "+ StateName +" is: " + population);
	}
	public void SuperMethodsCall(String CountryName, String population, String LandAreaSize)
	{
		super.CountryName   =  CountryName;
		super.LandAreaSize  =  LandAreaSize;
		super.population    =  population;

		super.LandArea();
		super.population();
	}
}

public class JavaOverRiding
{
    public static void main(String args[])
    {
    	State objState = new State();
        
    	objState.CountryName   =  "USA";
    	objState.StateName     =  "NEW YORK";
    	objState.population    =  "300 Million";
    	objState.LandAreaSize  =  "9,161,966 Sq KM";

    	// The below methods are from the "State" class not the "WorldCountry" Class
    	objState.LandArea();
    	objState.population();

    	// The below method is from the "WorldCountry" Class
    	objState.SuperMethodsCall(objState.CountryName, objState.population, objState.LandAreaSize);
    }
}
