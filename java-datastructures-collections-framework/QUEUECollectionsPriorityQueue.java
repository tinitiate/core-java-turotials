package JavaDataStructuresAndCollections;

import java.util.*;
/**
 * @author TINITIATE.COM
 *
 * > TOPIC : PriorityQueue Implementation of Queue, Java Collection FrameWork
 *
 * > NOTES : PriorityQueue:
 *               1) The head of this queue is the least element, 
 *                  for multiple elements of same value, the head is one of those elements 
 *               2) Priority queue size is unbounded,
 *                  It depends on the size of an array, used to store the elements.
 *                  Adding elements automatically increases the size.
 *               3) boolean offer(E e)
 *                      Inserts the specified element into this priority queue.
 *                      add(), also adds elements.
 *               4) poll() 
 *                      Retrieves and removes the head of the queue or returns null for empty queue.
 *
 */

public class QUEUECollectionsPriorityQueue
{
	public static void main(String[] args)
	{
        // Declare a PriorityQueue
		PriorityQueue<Integer> pque = new PriorityQueue<Integer>();

		// Add elements to PriorityQueue, Using ADD
		pque.add(99);

		// Add elements to PriorityQueue, Using offer
		pque.offer(55);
		pque.offer(77);
		pque.offer(66);

		// Display elements of the Queue
		System.out.println("Elements of the PriorityQueue " + pque);

		// Retrieve and Remove head element using poll
		System.out.println("The head element of the PriorityQueue :" + pque.poll());

		// Display elements of the Queue after calling poll
		System.out.println("Elements of the PriorityQueue after calling POLL: " + pque);
	}
}
