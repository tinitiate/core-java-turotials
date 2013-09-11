package JavaIO;

import java.io.*;

/**
 * @author TINITIATE.COM
 *
 * > TOPIC : FileInputStream, With Java.IO
 *
 * > NOTES : 1) FileInputStream reads raw bytes of data from the specified file. 
 *           2) FileInputStream is better suited for reading streams of raw bytes 
 *              from binary files(Images, Video, PDF ...)
 *           3) To use this program
 *                - Create a folder "c:\tinitiate\"  
 *                - In that folder file named "MyData.txt"
 *                - Add multi-line text to data.txt and save the file.
 *                - Run this java code.
 *           4)  read() 
 *                   Reads a byte of data from this input stream, And returns the ASCII decimal of the Byte.
 *
 * 
 */

public class JavaIOFileInputStream
{
    public static void main(String[] args) throws IOException
    {
        // Create a New InputStream of Bytes 
        InputStream StreamData = new FileInputStream("c:\\tinitiate\\MyData.txt");

        // Integer to Capture the ASCII decimal of the Bytes
        int ByteAsciiDecimal;

        // String Buffer to capture the ASCII of the "Byte ASCII Decimal"
        StringBuffer strContent = new StringBuffer("");

        // Read the StreamData (File Data as byte stream)
        // and return ASCII decimal of each Byte of the stream
        ByteAsciiDecimal = StreamData.read();

        // -1 indicates no more bytes in stream
        while (ByteAsciiDecimal != -1)
        {
            // Reads 1 Byte of data, Casts the Decimal to Char to get the ASCII character
            // Store them in a StringBuffer by appending every ASCII character 
            strContent.append((char)ByteAsciiDecimal);
            // Reads 1 byte at a time, hence read in every iteration of the loop
            ByteAsciiDecimal = StreamData.read();
        }
        // Print the StringBuffer, to display the file contents.
        System.out.println(strContent);
    }
}
