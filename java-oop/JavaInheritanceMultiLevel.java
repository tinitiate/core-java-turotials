package JavaOOP;

/** 
 * @author TINITIATE.COM
 * 
 * > TOPIC : Java OOP, Inheritance, Multilevel Hierarchy
 * 
 * > NOTES : 1) Program to demonstrate Multilevel Hierarchy, with inheritance
 *           2) CountryClass, is the level-1 Parent
 *           3) StateClass, is the level-2 Parent that inherits from CountryClass
 *           4) CityClass, is the Child that inherits from StateClass
 *
 */
class Country
{
    String ContinentName;
    String CountryName;

	public void PrintCountryName()
    {
	    System.out.println("CountryClass Message: Name of the Continent "+ ContinentName);
	    System.out.println("CountryClass Message: Name of the Country "+ CountryName);
    }
}

class CountryState extends Country
{
    String StateName;
    public void PrinStateName()
    {
        System.out.println("StateName Class Message: Name of the state "+ StateName);
    }
}

class CountryCity extends CountryState
{
	String CityName;
	public void PrintCityName()
	{
		System.out.println("CityName Class Message: Name of the city "+ CityName);
	}
	public static void main(String[] args) 
	{
		CountryCity ObjCity = new CountryCity();
		ObjCity.ContinentName = "North America";
		ObjCity.CountryName   = "USA";
		ObjCity.StateName     = "New York";
		ObjCity.CityName      = "New York City";
		ObjCity.PrintCountryName();
		ObjCity.PrinStateName();
		ObjCity.PrintCityName();
	}
}
