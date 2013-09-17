package JavaDataStructuresAndCollections;

import java.util.*;

/**
 * @author TINITIATE.COM
 *
 * > TOPIC : Sorting Collections using: Comparable; compareTo 
 *                                      Collections.sort
 *
 * > NOTES : 1) Comparable object compares itself with another object. 
 *           2) java.lang.Comparable: int compareTo(Object Obj1)
 *              This method compares "this" object with Obj1 object.
 *              Returns an integer,
 *               1. Returns positive  = this object is greater than Obj1
 *               2. Returns zero      = this object equals to Obj1
 *               3. Returns negative  = this object is less than Obj1
 *           3) To understand the program start reading from the Main method of the program.
 *           4) Useful to write Custom sort orders, See example below:
 *                 2.1) For example we have a list with following elements:
 *                      (3,1,5,4,2)
 *                 2.1) Ascending sort: Collection.sort((3,1,5,4,2)) will return (1,2,3,4,5)
 *                 2.2) Descending sort: Collection.sort((3,1,5,4,2),Collections.reverseOrder())
 *                      will return (5,4,3,2,1)
 *                 2.3) But if we want to write custom sorts like,
 *                      Even numbers first, Then Ascending amongst them: (2,4,1,3,5)
 *                      or 
 *                      Odd numbers first,  Then Ascending amongst them: (1,3,5,2,4)
 *                      In such cases we can "IMPLEMENT" the Comparator Interface's
 *                      "compare" Method.
 *
 *           5) Overrides the sort order in Collections.sort and Arrays.sort
 *              3.1) java.util.Collections.sort(List),
 *              Where Comparable.compareTo is written by the developer
 *
 */

class NumberList implements Comparable<NumberList>
{
    // Main Data
	int IntVal;

	// Creating multiple SortTypes
	public static String SortType; 

	public NumberList(int iIntval)
	{
		IntVal = iIntval;
	}

    // OverRide compareTo class	
    public int compareTo(NumberList val1)
    {
        if ( SortType.toUpperCase() == "ASCENDING" )
        // IF the SortType is ASCENDING then return values as described below.
        { return (val1.IntVal > IntVal ? -1 : (val1.IntVal == IntVal ? 0 : 1)); }

        // IF the SortType is DESCENDING then return values as described below.        
        else if  ( SortType.toUpperCase() == "DESCENDING" )
        { return (val1.IntVal > IntVal ? 1 : (val1.IntVal == IntVal ? 0 : -1)); }

        // IF the SortType is EVEN-FIRST-ASCENDING then return values as described below.        
        else if  ( SortType.toUpperCase() == "EVEN-FIRST-ASCENDING" )
        {
        	// Order data with Even numbers first and then odd numbers last
        	// Amongst the even and odd do an ascending order
            // Check if both are even and both are odd
          	if (((val1.IntVal%2) == 0 && (IntVal%2) == 0) || ((val1.IntVal%2) != 0 && (IntVal%2) != 0))
                { return (val1.IntVal > IntVal ? -1 : (val1.IntVal == IntVal ? 0 : 1)); }
            else if  ((val1.IntVal%2) == 0 && (IntVal%2) != 0)
                { return 1;}
            else if  ((val1.IntVal%2) != 0 && (IntVal%2) == 0)
                { return -1;}
            else
                return 0;
        }
        // IF the SortType is ODD-FIRST-ASCENDING then return values as described below.
        else if  ( SortType.toUpperCase() == "ODD-FIRST-ASCENDING" )
		{
        	// Order data with odd numbers first and then even numbers
        	// Amongst the even and odd do an ascending order
            if (((val1.IntVal%2) == 0 && (IntVal%2) == 0) || ((val1.IntVal%2) != 0 && (IntVal%2) != 0))
            { return (val1.IntVal > IntVal ? -1 : (val1.IntVal == IntVal ? 0 : 1)); }
            else 
            if  ((val1.IntVal%2) == 0 && (IntVal%2) != 0)
            { return -1;}
            else if  ((val1.IntVal%2) != 0 && (IntVal%2) == 0)
            { return 1;}
            else
            return 0;
        }
        return 0;
	}
}

public class JavaComparable
{
	public static void main(String[] args)
	{

		// Create Objects for the class and initialize to null 
        // Create a ArrayList of type NumberList Class
		ArrayList<NumberList> myList = new ArrayList<NumberList>();

		myList.add(new NumberList(2));
		myList.add(new NumberList(4));
		myList.add(new NumberList(1));
		myList.add(new NumberList(3));


        /**
         *  Print sorted data with " Collections.sort(myList) ", Just by specifying the sortType..
         */

        System.out.println("Sorting elements using [ Collections.sort with With user specified order ]," +
                           " Sorting in Ascending order:");
        // Set the Sort type
        NumberList.SortType = "ASCENDING";
        // Sorting elements using Collections.sort, With user specified order
        Collections.sort(myList);
        // Display elements
        for (NumberList i : myList)
        { System.out.print("  " + i.IntVal); }
        System.out.println("\n" + "-------");


        System.out.println("Sorting elements using [ Collections.sort with With user specified order ]," +
                           " Sorting in Descending order:");
        // Set the Sort type
        NumberList.SortType = "DESCENDING";
        // Sorting elements using Collections.sort, With user specified order
        Collections.sort(myList);
        // Display elements
        for (NumberList i : myList)
        { System.out.print("  " + i.IntVal); }
        System.out.println("\n" + "-------");
        

        System.out.println("Sorting elements using [ Collections.sort with With user specified order ]," +
                           " Sorting in Even numbers first Ascending order:");
        // Set the Sort type
		NumberList.SortType = "EVEN-FIRST-ASCENDING";
        // Sorting elements using Collections.sort, With user specified order
        Collections.sort(myList);
        // Display elements
        for (NumberList i : myList)
        { System.out.print("  " + i.IntVal); }
        System.out.println("\n" + "-------");

        
        System.out.println("Sorting elements using [ Collections.sort with With user specified order ]," +
                           " Sorting in Odd numbers first Ascending order:");
        // Set the Sort type
		NumberList.SortType = "ODD-FIRST-ASCENDING";
        // Sorting elements using Collections.sort, With user specified order
        Collections.sort(myList);
        // Display elements
        for (NumberList i : myList)
        { System.out.print("  " + i.IntVal); }
        System.out.println("\n" + "-------");
	}
}
