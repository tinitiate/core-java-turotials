package JavaClassAndMethods;

/*
============================================================
  TINITIATE.COM
  --> T..O..P..I..C
  Object Properties hashCode (), equals() and getClass()
============================================================
*/

class DemoClass
{
	int var1;

	// Constructor
	DemoClass(int inVar)
	{
		var1=inVar;
	}

	int MultiplyBy1000()
	{
		return var1=var1*1000; 
	}
}

public class ObjectProperties 
{
	public static void main(String[] args)
	{
		// Create an object of DemoClass
		DemoClass myObj1 = new DemoClass(9);
		System.out.println("Object myObj1.var1: " + myObj1.var1);
		System.out.println("Object myObj1.MultiplyBy1000(): " + myObj1.MultiplyBy1000());

		// Creating a new Object myObj2 and copying over the values of myObj1  
		DemoClass myObj2=myObj1;
		System.out.println("Object myObj2.var1: " + myObj2.var1);
		System.out.println("Object myObj2.MultiplyBy1000(): " + myObj2.MultiplyBy1000());

		// Using the " .equals "
		// Checking if the two objects are same
		System.out.println("Condition myObj1 = myObj2 is: "+ myObj1.equals(myObj2));

		// create another object of type object
		Object myObj3 = null;
		// Using the " .equals "
		// Checking if the two objects are same
		System.out.println("Condition myObj1 = myObj3 is: "+ myObj1.equals(myObj3));
		
		// Printing the class of an object
		System.out.println("Class of the object myObj2 is: " + myObj2.getClass());
		// Data stored in an instance of the class (Object) into a single hash value
		// hashCode of myObj2 and myObj2 are the same see above "DemoClass myObj2=myObj1;"
		System.out.println("Hashcode of myObj2 is " +myObj2.hashCode());
		System.out.println("Hashcode of myObj1 is " +myObj1.hashCode());

		// Prints the String of the object. 
		System.out.println(myObj2.toString());
	}
}
