package JavaIO;

import java.io.*;

/**
 * @author TINITIATE.COM
 *
 * > TOPIC : BufferedInputStream, With Java.IO
 *
 * > NOTES : 1) BufferedOutputStream writes raw bytes (Binary or text) image data to files.
 *           2) It can speed up IO, Rather than write one byte at a time to the network or disk
 *             ,It enables to write a larger block at a time, is better suited for writing 
 *             streams of raw bytes for binary files(Images, Video, PDF ...)
 *           3) This program
 *                - Checks if a folder "c:\tinitiate\" exists or not  
 *                - In the "c:\tinitiate" folder it creates a file named "OutputStreamData.txt"
 *              3.1)  write()   Writes byte array to this file in output stream.
 *              3.2)  flush()   Flushes the stream's.saved characters from the write() method.
 *                  
 *                  
 * 
 */

public class JavaIOBufferedOutputStream
{
    public static void main(String[] args) throws IOException
    {
        // Create a New OutputStream of Bytes, for the specified file. 
        OutputStream StreamData = new BufferedOutputStream
                                            ( new FileOutputStream("c:\\tinitiate\\OutputStreamData.txt"));

        // Create a byte array 
        byte OutData[] = new byte[300];

        // Data to write 
        String SomeData = "This is the TINITIATE.COM test data for OutputStream Demo\n Line1\n Line2\n";

        // Convert String to ByteArray 
        OutData = SomeData.getBytes();
        
        // Write data using the write(byte array) method. 
        StreamData.write(OutData);
        StreamData.flush();

        /**
         * 
         * Or Simply use the to write the string data  
         * StreamData.write(SomeData.getBytes());
         * 
         **/        
    }
}
