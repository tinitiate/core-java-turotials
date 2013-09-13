package JavaDataStructuresAndCollections;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author TINITIATE.COM
 *
 * > TOPIC : Stack Class Sample from, java.util Package
 *
 * > NOTES : Stack Class:
 *              1) Stack is First-in-Last-out.
 *              2) Push is used to insert element into a stack. 
 *              3) Pop is used to remove the top element from the stack. 
 *              4) search, Use this to search for an element, 
 *                         if found, returns the position of the element. 
 *              5) peek,   Check the top element in the stack.
 *              6) boolean empty, checks if the stack is empty or not.
 *              7) Using Iterator to read through stack elements.
 *              
 */

public class StackClassJavaUtil
{
    public static void main(String args[])
    {
        // Declaring a stack
    	Stack stk = new Stack();
    	
    	// Adding elements to a stack
        stk.push("C++");
        stk.push("JAVA");
        stk.push("SCALA");
        
        // Removing elements from the stack (First in Last out)
        System.out.println(stk.pop());

        // Find the position of the element in the stack
        System.out.println("Element 'JAVA' is at position: " + stk.search("JAVA"));
        
        // Check the top element in the stack.
        System.out.println("Top element in the stack: " + stk.peek());
        
        // Check if the stack is empty or not?
        System.out.println(stk.empty());

        // Using Iterator to display stack elements
        // This doesnt not pop the elements, it just reads them
        Iterator itr = stk.iterator();
		while(itr.hasNext())
		{
		    Object element = itr.next();
		    System.out.print(element + " ");
		}

		System.out.println("");
		System.out.println(stk.pop());
  }
}
