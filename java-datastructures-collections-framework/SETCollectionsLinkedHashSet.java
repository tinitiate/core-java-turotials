package JavaDataStructuresAndCollections;
import java.util.*;

/**
 * @author TINITIATE.COM
 *
 * > TOPIC : LinkedHastSet Implementation of Set, Java Collection FrameWork
 *
 * > NOTES : LinkedHashSet:
 *             1) LinkedHashSet extends HashSet and adds no members of its own.
 *             2) Elements are maintained by a linked list in the set, 
 *                remembering the order in which they were inserted
 *             3) Provides ordering when used.
 *             4) Does not support GET / SET methods.
 *
 */
public class SETCollectionsLinkedHashSet
{
	public static void main(String args[])
	{
		// Creating a LinkedHashSet of element type Integer.
		LinkedHashSet<Integer> lhset = new LinkedHashSet<Integer>();

		// Adding elements to a LinkedHashSet.
		lhset.add(222);
		lhset.add(333);
		lhset.add(444);

		// Printing contents of the LinkedHashSet
		System.out.println("Contents of the HashSet" + lhset);

		// Printing the size of the LinkedHashSet
		System.out.println("Size of the HashSet: " + lhset.size());

		// Printing elements using Iterator
		System.out.println("Displaying the Contents of LinkedHashSet using Iterator:");
		Iterator itr = lhset.iterator();
		while(itr.hasNext())
		{
		    Object element = itr.next();
		    System.out.print(element + " ");
		}
	}
}
