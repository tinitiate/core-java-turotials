package JavaDataStructuresAndCollections;

import java.util.*;

public class CollectionsIntro
{
	/**
	 * @author TINITIATE.COM
	 *
	 * > TOPIC : Java Collection FrameWork
	 *
	 * > NOTES : 1) The framework with implementations of basic collections like: dynamic arrays,
	 *              Sets, linked lists, trees, and hash tables.
	 *           2) It is part of package "java.util".
	 *           3) Advantage of the Collections Framework:
	 *              (a) Providing an efficient method of implementation and ease of usage.
	 *              (b) Unified architecture, Categorized by various collection types.
     *              (b) Convenient and consistent approach for coding collections by providing 
     *                  Standard set of interfaces and classes, Methods to handle collection data
     *                  for search, sort, iterate ..
     *              (d) Offers numerous specific implementations of the interfaces, Allowing the developer
     *                  to use optimal approach for application development.
     *           4) All interfaces provided by the package java.util, as part of the
     *               (a) Interface Collection          : Its the root interface; on top of the collections hierarchy.
     *                                                   A collection represents a group of objects known as its elements.
     *               (b) Interface Set                 : Extends Collection to handle sets, which must contain unique elements.
     *                  (b.1) Interface SortedSet      : Extends Set to handle sorted sets.
     *                  (b.2) Interface NavigableSet   : Extends SortedSet to handle retrieval of elements based on match.
     *               (c) Interface List                : Extends Collection to handle sequences (lists of objects).
     *               (d) Interface Queue               : Extends Collection to handle FIFO lists.
     *                  (d.1) Interface Deque          : Extends Queue to handle a double-ended queue.
     *               (f) Interface Map                 : An object that maps keys to values.
     *                  (f.1) Interface SortedMap      : A Map that maintains its mappings in ascending key order.               
     *
	 */

	public static void main(String[] args)
	{
	      //List interface, ArrayList Implementation (Class)
		  List a1 = new ArrayList();
	      a1.add("JAVA");
	      a1.add("SCALA");
	      a1.add("JYTHON");
	      System.out.println(" ArrayList Elements");
	      System.out.print("\t" + a1);

	      //Set interface, HashSet Implementation (Class)
	      Set s1 = new HashSet();
	      s1.add("C");
	      s1.add("C++");
	      s1.add("VC++");
	      System.out.println();
	      System.out.println(" Set Elements");
	      System.out.print("\t" + s1);

	      //Map interface, HashMap Implementation (Class)
	      Map m1 = new HashMap(); 
	      m1.put("JAVA",   "1");
	      m1.put("SCALA",  "2");
	      m1.put("JYTHON", "3");
	      System.out.println();
	      System.out.println(" Map Elements");
	      System.out.print("\t" + m1);
	}
}
