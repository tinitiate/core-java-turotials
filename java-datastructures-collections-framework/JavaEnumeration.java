package JavaDataStructuresAndCollections;

/** 
 * @author TINITIATE.COM
 *
 * > TOPIC : Java Enumeration
 *
 * > NOTES : 1) Enumeration, List of ACCEPTABLE/VALID pre-defined values,
 *              Which can be assigned to a variable.
 *           2) Enumeration is implemented using
 *              (a) Java Enumeration Interface, This construct supports two methods
 *                   (1) boolean hasMoreElements()
 *                       It returns true when there are more elements
 *                       to extract, else returns false.
 *                   (2) Object nextElement()
 *                       It returns the next object in the enumeration.
 *              (b) "Enum" Keyword.
 *                  (1) Define a class type, enumerations, without instantiating using new.
 *                      declare enumeration variable like a primitive type.
 *                  (2) This provides with values() and valuesOf() methods.
 *
 */
import java.util.Vector;
import java.util.Enumeration;

import JavaDataStructuresAndCollections.JavaEnumeration.OceansOfWorld;

public class JavaEnumeration
{
	// Enumeration using "ENUM" keyword, Like a primitive type
	enum OceansOfWorld {Arctic, Pacfic, Atlantic, Indian, Southern};

    public static void main(String[] args)
	{
		
    	/**
    	 * Enumeration using interface 'java.util.Enumeration'
    	 */
    	System.out.println("Enumeration using interface 'java.util.Enumeration'");
		System.out.println("----------------------------------------------------");
		// Using Java Enumeration Interface.
		Enumeration WorldOceans;
        Vector OceanNames1 = new Vector();
        OceanNames1.add("Arctic");
        OceanNames1.add("Pacfic");
        OceanNames1.add("Atlantic");
        OceanNames1.add("Indian");
        OceanNames1.add("Southern");
        WorldOceans = OceanNames1.elements();

        // hasMoreElements() methods, using with vector class
        while (WorldOceans.hasMoreElements())
        // nextElement(), use to iterate to the next object.
        {  System.out.println(WorldOceans.nextElement());  }

        System.out.println("");

        /**
    	 * Enumeration using Enum keyword
    	 */
        System.out.println("Enumeration using Enum keyword");
		System.out.println("----------------------------------------------------");
		// Calling the Enumeration defined above using "ENUM" keyword
		OceansOfWorld OceanNames2;

		// Methods of the enum class object: values() method
		System.out.println("Using the 'values()' method:");
		OceansOfWorld allOceans[] = OceansOfWorld.values();
		for(OceansOfWorld o : allOceans)
		System.out.println(o);
		System.out.println("");
		// Methods of the enum class object: valuesOf() method
		System.out.println("Using the 'valuesOf()' method:");
		// Methods of the enum class object: valueOf() method
		// Passing a valid enum value to get it back, or test
		// if a given entry is a valid enumeration.
		OceanNames2 = OceansOfWorld.valueOf("Indian");
		System.out.println("Name of an Ocean is: " + OceanNames2);
	}
}
