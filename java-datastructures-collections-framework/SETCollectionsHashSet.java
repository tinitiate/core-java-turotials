package JavaDataStructuresAndCollections;
import java.util.*;

/**
 * @author TINITIATE.COM
 *
 * > TOPIC : HastSet Implementation of Set, Java Collection FrameWork
 *
 * > NOTES : HashSet:
 *             1) HashSet is much faster.
 *             2) Does not guarantee ordering.
 *             3) Iteration is linear in the sum of the number of entries buckets (the capacity).
 *             4) Choosing an large initial capacity consumes more space and time.
 *             5) Choosing an small initial capacity consumes time when the capacity is increased
 *                for an existing HashSet.
 *             6) Default initial capacity is 16.
 *             7) Does not support GET / SET methods.
 *
 */
public class SETCollectionsHashSet
{
	public static void main(String args[])
	{
		// Creating a HashSet of element type Integer.
		HashSet<Integer> hset = new HashSet<Integer>();

		// Adding elements to a HashSet.
		hset.add(9999);
		hset.add(8888);
		hset.add(7777);

		// Printing contents of the HashSet
		System.out.println("Contents of the HashSet" + hset);

		// Printing the size of the HashSet
		System.out.println("Size of the HashSet: " + hset.size());

		// Printing elements using Iterator
		System.out.println("Displaying the Contents of HashSet using Iterator:");
		Iterator itr = hset.iterator();
		while(itr.hasNext())
		{
		    Object element = itr.next();
		    System.out.print(element + " ");
		}
	}
}
