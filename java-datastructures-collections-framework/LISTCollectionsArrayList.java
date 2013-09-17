package JavaDataStructuresAndCollections;

import java.util.*;
/**
 * @author TINITIATE.COM
 *
 * > TOPIC : ArrayList Implementation of List, Java Collection FrameWork
 *
 * > NOTES : 1) This is the most commonly used "List" implementation.
 *           2) Provides positional access and is fast.
 *           3) Sample code mentioned below for: 
 *               3.1) size()   Displays number of elements in the list, Index starts from ZERO
 *               3.2) add()    Adds elements to the array list.
 *               3.3) Display all list elements, Direct display, using for-each and iterator constructs.
 *               3.4) get()    Returns the element at the specified position in this list.
 *               3.5) remove() Removes elements from the array list, By element value or by index value
 *               3.6) Checking for values using equals(), contains().
 *               3.7) Replacing a value at a position using set().
 */

public class LISTCollectionsArrayList
{
	public static void main(String[] args)
	{
		ArrayList<String> alist = new ArrayList<String>();

		// Display number of elements in the list, Index starts from ZERO
		System.out.println("Initial size of al: " + alist.size());

		// Add elements to the array list.
		alist.add("JAVA");
		alist.add("SCALA");
		alist.add("GROOVY");
		alist.add("JYTHON");
		alist.add(4,"JSP");
		alist.add(5,"JSP");

		// Returns the number of elements in this list.
		System.out.println("Size of alist after additions: " +	alist.size());

		// Direct display
		System.out.println("Contents of alist: " + alist);

		// Display using for-each construct
		System.out.println("Printing Contents of alist using for-each construct:");
		for (Object o : alist)
		{  System.out.print(o + " ");  }
		System.out.println("");

		// Display using iterator construct
		System.out.println("Printing Contents of alist using iterator construct:");
		Iterator itr = alist.iterator();
		while(itr.hasNext())
		{
		    Object element = itr.next(); 
		    System.out.print(element + " ");
		}
		System.out.println("");

		// Display using ListIterator construct (Printing in reverse)
		System.out.println("Printing Contents of alist using ListIterator construct:");
		ListIterator litr = alist.listIterator(); 
		while(litr.hasPrevious())
		{
		    Object element = litr.next();
		    System.out.print(element + " ");
		}

		// Display using ListIterator construct
		while(litr.hasNext())
		{
		    Object element = litr.next();
		    System.out.print(element + " ");
		}

		System.out.println("");

		// Returns the element at the specified position in this list.
		System.out.println("alist(1) " + alist.get(4));

		// Remove elements from the array list, By element value.
		alist.remove("JYTHON");

		// Remove elements from the array list, By index value.
		alist.remove(3);

		System.out.println("Size of alist after remove: " +	alist.size());
		System.out.println("Contents of alist after remove: " + alist);

		// Checking for a value at an index
		if (alist.get(3).equals("JSP"))
		{
			System.out.println("Elements at index 3 is  'JSP' ");
		}

        // Boolean checking for a value's existence, using contains
		if (alist.contains("JSP"))
		{  System.out.println("Element 'JSP' is present in the ArrayList alist.");  }

		// Replaces the element at the specified position in this list with the specified element.
		alist.set(0,"C");

		// Direct display
		System.out.println("Contents of alist: " + alist);
	}
}
