package JavaIO;

import java.io.FileInputStream; 
import java.io.FileOutputStream; 
import java.nio.channels.FileChannel; 
import java.nio.ByteBuffer;   

/**
 * @author TINITIATE.COM
 *
 * > TOPIC : JAVA NIO, File Copy with NIO ByteBuffer and FileChannel
 *
 * > NOTES : 1) Java NIO is buffer oriented.
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
 ***********************************************************************************************************
 *           8) FileChannel class:
 *                  - Provides a channel for reading and writing files.
 *                  - Provides mechanism to locked a portion of a file, against access by other programs.
 *                  - File channels are safe for use by multiple concurrent threads.
 *                  - FileInputStream, FileOutputStream provides "getChannel" method to return a FileChannel.
 *                Methods:
 *                8.1)  getChannel(), FileOutputStream.getChannel() Returns a FileChannel
 *                8.2)  write()       Writes a ByteBuffer to the FileChannel
 *                8.3)  read()        reads from a FileChannel and returns a ByteBuffer.
 */
public class JavaNIOFileChannel
{

    public static void main(String[] args) throws Exception
    {
        // Create an instance of FileInputStream to source file
        FileOutputStream OutFileObj = new FileOutputStream("c:\\ubs\\MasterFile.txt");

        // Sample data to write to Master data file.
        String MasterData = "This is master data." + "\n" + "Dynamic value: <This Value Changes>";

        // Get the FileChannel of FileOutputStream instance
        FileChannel fcOutFile = OutFileObj.getChannel();

        // Create a 200 Byte Buffer
        ByteBuffer dataBuf = ByteBuffer.allocate(200);

        // Read the MasterData in bytes, into the Buffer
        dataBuf.put(MasterData.getBytes());
        dataBuf.flip();

        // Write the Contents of the Buffer to the MasterData FileChannel;.
        // As specified in the FileOutputStream object
        fcOutFile.write(dataBuf);
        fcOutFile.close();

        /**
         *  Reading file Contents, Using FileChannel read()
         **/

        // Create an instance of FileInputStream to source file
        FileInputStream InFileObj = new FileInputStream("c:\\ubs\\MasterFile1.txt");

        // Get the FileChannel of FileInputStream instance
        FileChannel fcInFile = InFileObj.getChannel();

        // Reuse the old buffer, Clear to move the position to Zero,
        // So buffer can be overwritten
        dataBuf.clear();

        // Using the FileChannel read method, read the FileChannel into the ByteBuffer
        fcInFile.read(dataBuf);

        // Print the contents of the buffer that has the contents of the file.
        dataBuf.flip();
        // Cycle through the buffer to read byte-by-byte for printing
        System.out.println("File Contents:");
        while(dataBuf.hasRemaining())
        { System.out.print((char)dataBuf.get()); }

    }
}
