package JavaDataStructuresAndCollections;

import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;
/**
 * @author TINITIATE.COM
 *
 * > TOPIC : TreeMap implementation for Map, Java Collection FrameWork
 *
 * > NOTES : 1) Maps are key-value pairs of data, creating maps stored in a tree structure.
 *           2) TreeMap class extends AbstractMap and implements the NavigableMap interface.
 *           3) Efficient means of storing and provides quick retrieval.
 *           4) tree map stores its elements in ascending key order.
 *           5) Supports below methods and more (See MapCollectionsHashMap example):
 *               5.1) put(K key, V value)
 *                         Associates the specified value with the specified key in this map.
 *               5.2) get(Object key)
 *                         Returns the value to which the specified key is mapped,
 *                         or null if this map contains no mapping for the key.
 *               5.3) boolean containsKey(Object key)
 *                         Returns true if this map contains a mapping for the specified key.
 *               5.4) boolean containsValue(Object value)
 *                         Returns true if this map maps one or more keys to the specified value.
 *		         5.5) remove(Object key)
 *		                  Removes the mapping for the specified key from this map if present.
 *               5.6) Looping through HashMap entries
 *                     1) Declaring a Set and using entrySet() to return elements 
 *                        as a Set and looping using For-All
 *                     2) Not Declaring a Set and using entrySet() to return elements 
 *                        as a Set and looping using For-All
 *                     3) Declaring a Set and using entrySet() to return elements 
 *                        as a Set and looping using Iterator
 *                     4) Not Declaring a Set and using entrySet() to return elements 
 *                        as a Set and looping using Iterator
 *           6) Sample Code Put(), getValue, Iterator
 * 
 * 
 * 
 */
public class MAPCollectionsTreeMap
{
	public static void main(String[] args)
	{
		// Declare, using : Map or TreeMap
		Map<Integer, String> tmap = new TreeMap<Integer, String>();
        // Other valid declarations
		// TreeMap<Integer, String> tmap = new TreeMap<Integer, String>();
		
		
		// Add elements using put(), in random order
		System.out.println("Adding elements to the TreeMap in Random order");
		tmap.put(2,"C++");
		tmap.put(1,"JAVA");
		tmap.put(3,"SCALA");

		// Checking updated values
		System.out.println("Value of Key '2' is: " + tmap.get(2));
		System.out.println("Value of Key '1' is: " + tmap.get(1));
		System.out.println("Value of Key '3' is: " + tmap.get(3));

		// TreeMap Prints elements in Ascending order
		System.out.println("TreeMap Prints elements in Ascending order");
        // Calling Iterator
		Iterator itr1 = tmap.entrySet().iterator();

		while (itr1.hasNext())
		{
			Map.Entry mEntry = (Map.Entry) itr1.next();
			System.out.println("Key " + mEntry.getKey() + " Value: " + mEntry.getValue());
		}
	}
}
