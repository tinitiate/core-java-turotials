package JavaDataStructuresAndCollections;

import java.util.*;

/**
 * @author TINITIATE.COM
 *
 * > TOPIC : TreeSet Implementation of Set, Java Collection FrameWork
 *
 * > NOTES : TreeSet:
 *              1) TreeSet extends AbstractSet and implements the NavigableSet interface.
 *              2) It creates a collection that uses a tree for storage.
 *              3) Objects are stored in sorted, ascending order. 
 *              4) Provides fast Access and retrieval time.
 *              5) Ideal for storing large amount of sorted data, for quick search and retrieval.
 *              6) Provides efficiency in operations with the SortedSet interface.
 *              7) Provides efficiency in operations for value-ordered iteration.
 *              8) Does not support GET / SET methods.
 *              9) Samples for Methods mentioned:
 *                  9.1)  Add, to add elements
 *                  9.2)  ceiling(E e) Returns the least element, greater than or equal to the 
 *                                     given element, returns null if there is no such element.
 *                  9.3)  floor(E e)   Returns the greatest element, less than or equal to the 
 *                                     given element, or null if there is no such element.
 *                  9.4)  headSet(E toElement) 
 *                                     Returns the subset of elements that are less than toElement. 
 *                  9.5)  headSet(E toElement, boolean inclusive) 
 *                                     Returns the subset of elements that are less than 
 *                                     (or equal to, if inclusive is true) toElement. 
 *                  9.6)  tailSet(E fromElement)
 *                                     Returns the subset of elements that are greater than
 *                                     or equal to fromElement.
 *                  9.7)  tailSet(E fromElement, boolean inclusive)
 *                                     Returns the subset of elements are greater than 
 *                                     (or equal to if inclusive is true) fromElement.
 *                  9.8)  subSet(E fromElement, E toElement)
 *                                     Returns a view of the portion of this set whose elements
 *                                     range from fromElement, inclusive, to toElement, exclusive. 
 *                  9.9)  subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) 
 *                                     Returns a view of the portion of this set whose elements 
 *                                     range from fromElement to toElement.
 *                  9.10)  pollFirst() Retrieves and removes the first (lowest) element,
 *                                     or returns null if this set is empty.
 *                  9.11)  pollLast()  Retrieves and removes the last (highest) element,
 *                                     or returns null if this set is empty.
 *                  9.12)  boolean remove(Object o) 
 *                                     Removes the specified element from this set if it is present. 
 *
 */

public class SETCollectionsTreeSet
{
	public static void main(String[] args)
	{
		// Declare a TreeSet
		TreeSet<Integer> tset = new TreeSet<Integer>();

		// Adding elements to the TreeSet
		tset.add(2222);
		tset.add(4444);
		tset.add(6666);
		tset.add(8888);
		tset.add(9999);
		
		// Printing the elements of the TreeSet
		System.out.println("Elements of the TreeSet " + tset);
		
		// ceiling() Returns the least element, which is greater or equal to the
		//            given element null if there is no such element.
		System.out.println(tset.ceiling(5555));
		
		// floor()   Returns the greatest element, less than or equal to the 
		//           given element, or null if there is no such element.
		System.out.println(tset.floor(5555));

		// headSet Sample
		System.out.println(tset.headSet(6666));

		// headSet with "inclusive" Sample
		System.out.println(tset.headSet(6666,true));

		// tailSet Sample
		System.out.println(tset.tailSet(6666));

		// tailSet with "inclusive" Sample
		System.out.println(tset.tailSet(6666,true));

		// subSet Sample
		System.out.println(tset.subSet(4444,8888));

		// subSet inclusive Sample
		System.out.println(tset.subSet(4444,false,8888,false));

		// Printing elements using Iterator
		System.out.println("Displaying the Contents of TreeSet using Iterator:");
		Iterator itr = tset.iterator();
		while(itr.hasNext())
		{
		    Object element = itr.next();
		    System.out.print(element + " ");
		}
		// pollFirst Sample
		System.out.println("Removing the First element using pollFirst");
		System.out.println("Elements before pollFirst " + tset);
		tset.pollFirst();
		System.out.println("Elements after pollFirst " + tset);
		
		// pollLast  Sample
		System.out.println("Removing the First element using polllast");
		System.out.println("Elements before pollLast " + tset);
		tset.pollLast();
		System.out.println("Elements after pollLast " + tset);

		//  boolean remove(Object o) 
		System.out.println("Removing elements using remove");
		System.out.println("Elements before remove " + tset);
		tset.remove(6666);
		System.out.println("Elements after remove " + tset);
	}
}
