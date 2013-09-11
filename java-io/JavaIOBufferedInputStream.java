package JavaIO;

import java.io.*;

/**
 * @author TINITIATE.COM
 *
 * > TOPIC : BufferedInputStream, With Java.IO
 *
 * > NOTES : 1) BufferedInputStream: 
 *                  It creates, buffer of byte array from the stream 
 *                  as and when read() or skip() methods are applied to the stream,
 *                  the buffer is refilled with the stream with new byte array of data.
 *           2) BufferedInputStream is better suited for reading streams of raw bytes 
 *              from binary files(Images, Video, PDF ...)
 *           3) To use this program
 *                - Create a folder "c:\tinitiate\"  
 *                - In that folder file named "MyData.txt"
 *                - Add following text to MyData.txt
 *                  
 *                  12345
 *                  23456
 *                  34567
 *                  45678
 *                 
 *                 and save the file.
 *                - Run this java code.
 *           5) Sample Methods demo.
 *              available() 
 *                  Returns an estimate of the number of bytes that can be read 
 *                  or skip() (Skipped) for the input stream.              
 *              read() 
 *                  Reads a byte of data from the input stream, And returns the ASCII decimal of the Byte.
 *              skip(long i)
 *                  Skips "i" bytes of data from the input stream.
 *              mark(int readlimit) 
 *                  Sets the read buffer size mark for the InputStream.
 *              reset()
 *                  resets the mark set in the InputStream.
 *
 */

public class JavaIOBufferedInputStream 
{
    public static void main(String[] args) throws IOException
    {
        // Create a New BufferedInputStream 
        InputStream StreamData = new BufferedInputStream(new FileInputStream("c:\\tinitiate\\MyData.txt"));
        
        // Make a new Object
        InputStream newStreamData = new BufferedInputStream(new FileInputStream("c:\\tinitiate\\MyData.txt"));

        System.out.println("Total estimated bytes in the file 'c:\\tinitiate\\MyData.txt': "
                           + StreamData.available());

        // Capture each ASCII decimal of each byte into an integer 
        int dataBytes = StreamData.read();
        // Loop through the stream
        while ( dataBytes != -1 )
        {
            System.out.println((char)dataBytes);
            // Capture each ASCII decimal of each byte into an integer,
            // Overwriting the integer dataBytes.             
            dataBytes = StreamData.read();
        }
        
        // Sets a bufferArray size
        newStreamData.mark(10);
        System.out.println((char)newStreamData.read());

        // Resets the mark
        newStreamData.reset();
        System.out.println((char)newStreamData.read());
    }
}
