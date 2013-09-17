package JavaDataStructuresAndCollections;

import java.util.*;

/**
 * @author TINITIATE.COM
 *
 * > TOPIC : LinkedList Implementation of List, Java Collection FrameWork
 *
 * > NOTES : 1) Doubly-linked list implementation of the List and Deque interfaces.
 *           2) Implements all optional list operations, and permits all elements (including null).
 *           3) Sample code mentioned below for:
 *               3.1)  add(Object o): Appends the specified element to the end of this list.
 *               3.2)  add(int index, Object element) Inserts the specified element at the specified position in this list.    
 *               3.3)  addFirst(Object o): Inserts the given element at the beginning of this list. 
 *               3.4)  void addLast(Object o): Appends the given element to the end of this list. 
 *               3.5)  set(int index, Object element) Replaces the element at the specified position in this list with the specified element.
 *               3.6)  get(int index): Returns the element at the specified position in this list.
 *               3.7)  remove(int index): Removes the element at the specified position in this list. 
 *               3.8)  boolean remove(Object o): Removes the first occurrence of the specified element in this list. 
 *               3.9)  removeFirst(): Removes and returns the first element from this list. 
 *               3.10) Object removeLast(): Removes and returns the last element from this list. 
 *               3.11) contains(Object o): Returns true if this list contains the specified element.
 *
 */
public class LISTCollectionsLinkedList 
{
	public static void main(String[] args)
	{
		LinkedList<String> llist = new LinkedList<String>();
		// Add elements to the linked list.
		llist.add("JAVA");
		llist.add("C++");

		llist.addLast("ERLANG");
		llist.addLast("GROOVY");
		llist.addFirst("SCALA");
		llist.add(0, "C");

		// Display Linked List contents
		System.out.println("Contents of llist: " + llist);

		// Get value at specified index.
		System.out.println("Value at index 2 is: " + llist.get(2));

		// Set value at specified index.
		llist.set(2, "LISP");
		System.out.println("llist after change: " + llist);		
  
		// Get Returns the element at the specified position in this list.
		System.out.println("The first element using get(0): " + llist.get(0));

		// Remove elements from the linked list.
		llist.remove("ERLANG");
		llist.remove(2);

		System.out.println("Contents of llist after remove : "+ llist);

		// Remove first and last elements.
		llist.removeFirst();
		llist.removeLast();

		System.out.println("llist after remove first and last: " + llist);

		// Checks for a value using contains, Returns true if the list contains the specified element.
		if (llist.contains("SCALA"))
		{  System.out.println("Element 'SCALA' exists in the LinkedList: " + llist);  }
	}
}
