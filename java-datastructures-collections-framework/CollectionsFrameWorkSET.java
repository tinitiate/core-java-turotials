package JavaDataStructuresAndCollections;

import java.util.*;

/**
 * @author TINITIATE.COM
 *
 * > TOPIC : SET Implementations, Java Collection FrameWork
 *
 * > NOTES : 1) There are three general "Set" implementations: HashSet, TreeSet and LinkedHashSet.
 *           2) HashSet:
 *                 -- HashSet is much faster.
 *                 -- Does not guarantee ordering.
 *                 -- Iteration is linear in the sum of the number of entries buckets (the capacity).
 *                 -- Choosing an large initial capacity consumes more space and time.
 *                 -- Choosing an small initial capacity consumes time when the capacity is increased
 *                    for an existing HashSet.
 *                 -- Default initial capacity is 16.
 *            3) TreeSet:
 *                 -- Provides efficiency in operations with the SortedSet interface.
 *                 -- Provides efficiency in operations for value-ordered iteration.
 *            4) LinkedHashSet:
 *                 --  Its an intermediate between HashSet and TreeSet.
 *                 --  Implemented as a hash table with a linked list running through it.
 *                 --  Provides insertion-ordered iteration (least recently inserted to most recently). 
 *                 --  Runs nearly as fast as HashSet.
 *                 --  Provides efficient ordering over HashSet.
 *            5) There are two special "Set: implementations: EnumSet and CopyOnWriteArraySet.
 *            6) EnumSet:
 *                 -- Set implementation for ENUM types.
 *                 -- All of the members of an ENUM set must be of the same ENUM type.
 *                 -- Set elements are represented by bit-vectors.
 *                 -- Support iteration over ranges of ENUM types.
 *            7) CopyOnWriteArraySet:
 *                 -- Set implementation backed up by a copy-on-write array.
 *                 -- To prevent locking; Add, Set and Remove operations are implemented by making a new copy of the array.
 *                 -- Even iteration may safely proceed concurrently with element insertion and deletion.
 *                 -- This implementation is suited for sets that are rarely modified, but frequently iterated.
 *                 -- May require maintaining an event-handler that prevents duplicates.
 *
 */

public class CollectionsFrameWorkSET 
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

	}
}
