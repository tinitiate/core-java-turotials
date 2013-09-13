package JavaPackagesAndInterfaces;

/**
 * @author TINITIATE.COM
 *
 * > TOPIC : Java Interface Reference
 *
 * > NOTES : 1) Using a interface reference, this class uses implementations of interface 
 *              JavaInterface from the classes:  JavaInterfaceEatHealthy and JavaInterfaceEatJunkFood  
 *           2) The implementation of the methods food(), drink(), dressing(), side() 
 *              are resolved at run time rather than at compile time, Demonstrating polymorphism.
 *           3) The implementation of the methods are called using a interface reference variable
 *
 */
public class JavaInterfaceReference
{
    public static void main(String[] args)
    {
        // Interface Reference
    	JavaInterface refJI;

    	// Object for class JavaInterfaceEatHealthy
    	JavaInterfaceEatHealthy  objHF  =  new JavaInterfaceEatHealthy();

    	// Object for class JavaInterfaceEatJunkFood
    	JavaInterfaceEatJunkFood objJF  =  new JavaInterfaceEatJunkFood();
        
    	/**
    	 *  Determine at RunTime which implementation of the interface to use,
    	 *  By selecting the object of the implementing class JavaInterfaceEatHealthy
    	 */
    	System.out.println("Implementation of class JavaInterfaceEatHealthy...");
        // Assign implementing class JavaInterfaceEatHealthy object to interface reference
    	refJI  =  objHF;
        // Call methods
    	refJI.food();
    	refJI.dressing();
    	refJI.drink();
    	refJI.side();
        
    	System.out.println("");
    	System.out.println("----------------------------------------------------------");
    	System.out.println("");
    	/**
    	 *  Determine at RunTime which implementation of the interface to use,
    	 *  By selecting the object of the implementing class JavaInterfaceEatJunkFood
    	 */
    	System.out.println("Implementation of class JavaInterfaceEatJunkFood...");
    	// Assign implementing class JavaInterfaceEatJunkFood object to interface reference
    	refJI  =  objJF;
        // Call methods
    	refJI.food();
    	refJI.dressing();
    	refJI.drink();
    	refJI.side();
	}
}
