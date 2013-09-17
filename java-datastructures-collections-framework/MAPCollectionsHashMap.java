package JavaDataStructuresAndCollections;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

/**
 * @author TINITIATE.COM
 *
 * > TOPIC : HashMap implementation for Map, Java Collection FrameWork
 *
 * > NOTES : 1) Maps are key-value pairs of data.
 *           2) A key is an object that, Which has another object value, associated to it.
 *           3) They contain unique keys and their values, Values may be duplicated.
 *           4) For every Key-Value stored in the Map, Value can retrieved by its key.
 *           5) HashMap uses a hash table to store the map.
 *           6) The default HashMap size is 16.
 *           7) HashMap does not display elements in the order they were added.
 *           8) Sample Code for methods:
 *               8.1) put(K key, V value)
 *                         Associates the specified value with the specified key in this map.
 *               8.2) get(Object key)
 *                         Returns the value to which the specified key is mapped,
 *                         or null if this map contains no mapping for the key.
 *               8.3) boolean containsKey(Object key)
 *                         Returns true if this map contains a mapping for the specified key.
 *               8.4) boolean containsValue(Object value)
 *                         Returns true if this map maps one or more keys to the specified value.
 *		         8.5) remove(Object key)
 *		                  Removes the mapping for the specified key from this map if present.
 *               8.6) Looping through HashMap entries
 *                     1) Declaring a Set and using entrySet() to return elements 
 *                        as a Set and looping using For-All
 *                     2) Not Declaring a Set and using entrySet() to return elements 
 *                        as a Set and looping using For-All
 *                     3) Declaring a Set and using entrySet() to return elements 
 *                        as a Set and looping using Iterator
 *                     4) Not Declaring a Set and using entrySet() to return elements 
 *                        as a Set and looping using Iterator
 *
 */

public class MAPCollectionsHashMap
{
	public static void main(String[] args)
	{
		// Create a hash map.
		HashMap<String, String> HM_NationCapitals = new HashMap();

		// Adding elements to the map using put()
		HM_NationCapitals.put("USA",   "WASHINGTON DC");
		HM_NationCapitals.put("INDIA", "NEW DELHI");
		HM_NationCapitals.put("CHINA", "PEKING");
		HM_NationCapitals.put("DUMMY", "DUMMY");

		// Display Value of a Key using get() 
		System.out.println("Capital of USA is " + HM_NationCapitals.get("USA"));

		// Updating the value of a Key using put() 
		HM_NationCapitals.put("CHINA", "BEJING");

		// Checking updated values
		System.out.println("CHINA's Updated Capital: " + HM_NationCapitals.get("CHINA"));

        // Checks if the given key exists
		if (HM_NationCapitals.containsKey("RUSSIA"))
		{ System.out.println("Key 'RUSSIA' exists in the HashMap"); }
		else
		{System.out.println("Key 'RUSSIA' doesn't exist in the HashMap"); }
		
        // Checks if the given value exists
		if (HM_NationCapitals.containsValue("MOSCOW"))
		{ System.out.println("Value 'MOSCOW' exists in the HashMap"); }
		else
		{ System.out.println("Value 'MOSCOW' doesn't exist in the HashMap"); }

		// Removes the mapping for the specified key
		System.out.println("Data for DUMMY before remove " + HM_NationCapitals.get("DUMMY"));
		HM_NationCapitals.remove("DUMMY");
		System.out.println("Data for DUMMY after remove " + HM_NationCapitals.get("DUMMY"));

		System.out.println();
		System.out.println();

		// Looping through HashMap entries
		System.out.println("Methods to Loop through a HashMap");
		System.out.println("");
		System.out.println("");
		System.out.println("Method 1:");
		System.out.println("=====================================================");
		System.out.println("Declaring a Set and using entrySet() to return " + "\n" +
				           "elements as a Set and looping using For-All.");
		System.out.println("=====================================================");
		// Get Map into set of the entries.
		// Declare a Set, Convert Map to Set using entrySet() method
		Set<Map.Entry<String, String>> set1 = HM_NationCapitals.entrySet();

		// Display the set contents using "for"
		for(Map.Entry<String, String> me : set1)
		{
		    System.out.println("Nation " + me.getKey() + " Capital: " + me.getValue());
		}
		System.out.println();
		System.out.println();

		System.out.println("Method 2:");
		System.out.println("=====================================================");
		System.out.println("Not Declaring a Set and using entrySet() to return " + "\n" +
				           "elements as a Set and looping using For-All.");
		System.out.println("=====================================================");		
		// Display the set contents, Directly use the entrySet() 
		// without an intermediate object declaration for Set.
		for(Map.Entry<String, String> me : HM_NationCapitals.entrySet())
		{
		    System.out.println("Nation " + me.getKey() + " Capital: " + me.getValue());
		}
		System.out.println();
		System.out.println();

		// Looping through HashMap entries
		System.out.println("Method 3:");
		System.out.println("=====================================================");
		System.out.println("Declaring a Set and using entrySet() to return " + "\n" +
				           "elements as a Set and looping using For-All.");
		System.out.println("=====================================================");
		// Declare a Set,  Convert Map to Set using entrySet() method
		Set<Map.Entry<String, String>> set2 = HM_NationCapitals.entrySet();

		// Get Map into set of the entries. into Iterator
		Iterator itr2 = set2.iterator();

		while (itr2.hasNext()) {
			Map.Entry mEntry = (Map.Entry) itr2.next();
			System.out.println("Nation " + mEntry.getKey() + " Capital: " + mEntry.getValue());
		}
		System.out.println();
		System.out.println();

		System.out.println("Method 4:");
		System.out.println("=====================================================");
		System.out.println("Not Declaring a Set and using entrySet() to return " + "\n" +
				           "elements as a Set and looping using For-All.");
		System.out.println("=====================================================");		

		// Get Map into set of the entries. into Iterator
		// Directly use the entrySet() without an intermediate object 
		// declaration for Set and use the iterator method.
		Iterator itr1 = HM_NationCapitals.entrySet().iterator();

		while (itr1.hasNext()) {
			Map.Entry mEntry = (Map.Entry) itr1.next();
			System.out.println("Nation " + mEntry.getKey() + " Capital: " + mEntry.getValue());
		}
		System.out.println();
		System.out.println();
	}
}
