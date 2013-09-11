package JavaIO;

import java.nio.ByteBuffer;   

/**
 * @author TINITIATE.COM
 *
 * > TOPIC : JAVA NIO, Buffer
 *
 * > NOTES : 
 *       JAVA.NIO 
 *           1) Java NIO is buffer oriented.
 *           2) Data is first read into a buffer and then processed from it.
 *           3) This provides flexibility to move back and forth during processing. 
 *           4) Buffer management must be done, 
 *              - Check to see if all data in the buffer is used.
 *              - Pickup all the data and place in buffer based on size in chunks, 
 *                if data byte size is greater than the buffer size.  
 *              - Make sure the data is not overwritten in the buffer. 
 *           5) NIO provides management of multiple network connections / files,
 *              using a one or a few threads.
 *           6) Its also advantageous, when there is a need to manage many of open
 *              connections simultaneously, handling smaller dataset.
 *           7) Since the data can be split into chunks and buffered, It also is well suited
 *              for low bandwidth - multiple thread operations.                      
 *              But the cost is that parsing the data and buffering it might be expensive.
 *           
 *       JAVA.NIO.BUFFER
 *           1) Buffer is a linear, finite sequence of elements of a primitive type.
 *           2) Buffer Properties:
 *              capacity()
 *                - It is the number of elements the buffer contains.
 *                - The capacity of a buffer is never negative and never changes.
 *              position()
 *                - It is the index of the next element to be read or written.
 *                - It is never negative and is never greater than its limit.
 *              limit()
 *                - It is the index of the first element that should not be read or written. 
 *                - Limit is never negative and is never greater than its capacity.
 *              mark() and reset()
 *                - Mark, Captures the current position, when its called.
 *                - when reset is called, position is set to the Mark.
 *              Remember: With-in a Buffer 
 *                0(Zero) <= position <= limit <= capacity 
 *
 *           3) clear() makes a buffer ready for a new sequence of channel-read or relative put operations: 
 *                      It sets the limit to the capacity and the position to zero. 
 *              flip()  makes a buffer ready for a new sequence of channel-write or relative get operations: 
 *                      It sets the limit to the current position and then sets the position to zero. 
 *              rewind() makes a buffer ready for re-reading the data that it already contains: 
 *                      It leaves the limit unchanged and sets the position to zero.
 *           4) put() Adds bytes to the buffer.
 *           5) get() Relative get method.
 *                  Reads the byte at this buffer's current position, and then increments the position. 
 *              hasRemaining()
 *                  Returns true if the buffer has any elements between the current position and limit.
 *
 *
 */ 
public class JavaNIOBuffer
{
    public static void main(String[] args)
    {
        // Define some data with a String
        String SomeData = "THIS TINITIATE JAVA.NIO SAMPLE DATA";

        System.out.println("String SomeData = " + SomeData);
        System.out.println("");

        // Allocate 100 Bytes of Buffer (Works within JVM. And JVM within the Computers Memory.
        ByteBuffer tinBuffer = ByteBuffer.allocate(100);

        // Read buffer properties
        System.out.println("Buffer Initial Properties:");
        System.out.println("Buffer Capacity: " + tinBuffer.capacity());
        System.out.println("Buffer Limit:    " + tinBuffer.limit());
        System.out.println("Buffer Position: " + tinBuffer.position());
        System.out.println("Buffer Remaining:" + tinBuffer.remaining());
        System.out.println("");

        // Using put() method to Collect the bytes from the String 
        // and putting them in the buffer.
        System.out.println("Adding 'SomeData's Bytes to the buffer using put()..");
        tinBuffer.put(SomeData.getBytes());
        System.out.println("");

        // Read buffer properties
        System.out.println("Buffer after put() Properties:");
        System.out.println("Buffer Capacity: " + tinBuffer.capacity());
        System.out.println("Buffer Limit:    " + tinBuffer.limit());
        System.out.println("Buffer Position: " + tinBuffer.position());
        System.out.println("Buffer Remaining:" + tinBuffer.remaining());
        System.out.println("");

        // Capture the position after Put.
        int positionAfterPut = tinBuffer.position();

        /**
         * Printing contents with start and end indicators
         */
        System.out.println("Printing Buffer contents with DATA-START and DATA-END indicators.\n");

        // Printing Contents of the Buffer
        // Flip the Buffer (Make the position as ZERO and Limit as the 'positionAfterPut'
        tinBuffer.flip();
        tinBuffer.limit(positionAfterPut);
        // Print contents by checking for hasRemaining() 
        System.out.println("Printing the contents of the Buffer from Zero to Position after the Put:");
        System.out.print("|<<DATA-START>>|");
        while (tinBuffer.hasRemaining())
        {  System.out.print((char)tinBuffer.get()); }
        System.out.print("|<<DATA-END>>|" + "\n\n");

        // Printing all Contents of the Buffer
        // Flip the Buffer (Make the position as ZERO and Limit as the 'positionAfterPut'
        //Invoke chaining: Methods that return buffer are allowed to be chained; 
        tinBuffer.flip().limit(tinBuffer.capacity());
        // Print contents by checking for hasRemaining()
        System.out.println("Printing the entire contents of the Buffer:");
        System.out.print("|<<DATA-START>>|");
        while (tinBuffer.hasRemaining())
        {  System.out.print((char)tinBuffer.get()); }
        System.out.print("|<<DATA-END>>|" + "\n\n");

        System.out.println("Trying to Add new data to the buffer ...");        
        try 
        {
            // This section will fail, because the position = capacity
            // and no new data can be added from that position value.
            // Using put() method to Add more bytes to the buffer 
            // and putting them in the buffer.
            System.out.println("Adding more Bytes to the buffer using put()..");
            tinBuffer.put(new String(" NEW-DATA ").getBytes());
            System.out.println("");
        }
        catch (Exception e)
        {
            System.out.println("ERROR!!: Attempting to add contents " + "' NEW-DATA '" + " to buffer.");
            System.out.println("Current Position: " + tinBuffer.position());
            System.out.println("Current capacity: " + tinBuffer.capacity());
        }

        System.out.println("\nTrying to Add new data to the buffer, By resetting to old position ...");
        tinBuffer.position(positionAfterPut);
        System.out.println("Buffer Position: " + tinBuffer.position());

        try 
        {
            // This section will succeed, because the (position + (NewData byteSize)) < capacity
            // Using put() method to Add more bytes to the buffer 
            // and putting them in the buffer.
            System.out.println("Adding more Bytes to the buffer using put()..");
            tinBuffer.put(new String(" NEW-DATA ").getBytes());
            System.out.println("");
        }
        catch (Exception e)
        {
            System.out.println("ERROR!!: Attempting to add contents " + "' NEW-DATA '" + " to buffer.");
            System.out.println("Current Position: " + tinBuffer.position());
            System.out.println("Current capacity: " + tinBuffer.capacity());
        }

        // Printing all Contents of the Buffer
        // Flip the Buffer (Make the position as ZERO and Limit as the 'positionAfterPut'
        //Invoke chaining: Methods that return buffer are allowed to be chained; 
        tinBuffer.flip().limit(tinBuffer.capacity());
        // Print contents by checking for hasRemaining()
        System.out.println("Printing the entire contents of the Buffer:");
        System.out.print("|<<DATA-START>>|");
        while (tinBuffer.hasRemaining())
        {  System.out.print((char)tinBuffer.get()); }
        System.out.print("|<<DATA-END>>|" + "\n\n");

    }
}
