package JavaIO;

import java.io.*;

/**
 * @author TINITIATE.COM
 *
 * > TOPIC : JAVA IO, File Operations With Java.IO
 *
 * > NOTES : 1) FileWriter writes streams of characters, to a File specified in the File Object.
 *              1.1) write()  Writes a Char Array or a String to a file.(OverWrites the data)
 *              1.2) append() Appends a Char Array or a String to a file.(Appends data to EOF)
 *              1.3) flush()  Flushes the stream's.saved characters from the write() method.
 *              1.4) close()  Closes the stream, flushing it first.
 *           2) FileReader reads streams of characters. It should be used for reading text files.
 *              2.1) Using the read() method the data is returned into a character array  
 *
 * 
 */

public class JavaIOFile_Writer_Reader
{
    public static void main(String[] args)throws IOException
    {
        File fileObj = new File("c:\\tinitiate\\WriteReadDemo.txt");
        // creates the file
        fileObj.createNewFile(); 

        // creates a FileWriter Object
        FileWriter writer1 = new FileWriter(fileObj); 
        // Writes the content to the file
        writer1.write("(1)Welcome\n to\n tinitiate.com\n");
        // Flushes the stream's.saved characters from the write() method.
        writer1.flush();
        // Closes the stream, flushing it first
        writer1.close();

        // creates a FileWriter Object
        FileWriter writer2 = new FileWriter(fileObj); 
        
        writer2.write("(2)Welcome\n to\n tinitiate.com\n");
        writer2.append("(3)Welcome\n to\n tinitiate.com\n");

        writer2.flush();
        writer2.close();

        //Creates a FileReader Object
        FileReader fr = new FileReader(fileObj); 
        char [] fileDataChars = new char[5000];
        // reads the content to the array
        fr.read(fileDataChars); 
        //prints the characters one by one
        for(char c : fileDataChars)
            System.out.print(c);
        fr.close();

    }
}
