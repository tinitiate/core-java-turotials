package JavaIO;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author TINITIATE.COM
 *
 * > TOPIC : JAVA IO, File Operations With Java.IO
 *
 * > NOTES : 1) Java IO is stream oriented.
 *           2) In a stream oriented setup bytes are read into a stream, But are NOT cached.
 *              This prevents from moving forth and back in the data with-in a stream.
 *           3) Java IO streams are blocking, Which is, when a thread invokes read()/write(),
 *              that thread is blocked until the stream has exhausted the data and completed the
 *              read/write operation. And that thread can do nothing else when its doing its operation.
 *           4) When to use java.io, over java.nio:
 *              4.1) Where there are fewer connections with very high bandwidth,
 *              4.2) sending a lot of data in a single go.
 *           5) Sample Code:
 *              5.1) To use this program
 *                   - Create a folder "c:\tinitiate\"  
 *                   - In that folder file named "data.txt"
 *                   - Add multi-line text to data.txt and save the file.
 *                   - Run this java code.
 *              5.2) Code samples the following methods:
 *                   exists() 
 *                         Tests if the file or directory exists or not.
 *                   createNewFile()
 *                         Creates a new file with the specified name in the File object
 *                   canExecute()
 *                         Tests if the program can execute the file
 *                   canRead()
 *                         Tests if the program can read the file
 *                   canWrite()
 *                         Tests if the program can modify the file
 *                   lastModified() 
 *                         Returns the date time when the file was last modified.
 *                   length() 
 *                         Returns the number of bytes of the file.                         
 *                   renameTo(File dest) 
 *                         Renames the file to the name specified (By using an object).
 *                   setReadable(boolean readable, boolean ownerOnly) 
 *                         Sets the file read permission to true /false as specified. 
 *                   setWritable(boolean writable) 
 *                         Sets the file write permission to true /false as specified. 
 *                   setExecutable(boolean executable) 
 *                         Sets the file execute permission to true /false as specified. 
 *                   setLastModified(long time) 
 *                         Sets the last-modified time of the file to the specified time.
 *                   getFreeSpace() 
 *                         Returns the free Space in Bytes, of the partition on which the File object resides.
 *                   getTotalSpace() 
 *                         Returns the total space in Bytes, of the partition on which the File object resides. 
 *
 *             6) !! NOTE !!, Either [DirectoryPath + FileName] or [DirectoryPath], Both will work, with File class.
 */

public class JavaIOFileOperations
{
    public static void main(String[] args) throws IOException
    {
        // Create a new File object, Specify the Path and/or file-Name
        // Java reads and operates on this path/file.
        File fObj = new File("c:\\tinitiate\\data.txt");

        // Check if the file exists of the file object
        if (fObj.exists())
            {   System.out.println("The file: " + fObj.getName() + " Exists.");   }        
        else
            {   
                System.out.println("The file: " + fObj.getName() + "does Not Exists.");   
                // creates the file
                fObj.createNewFile(); 
            }    

        // Get File Permissions of the file object
        System.out.println(fObj.getName() + " Read Permission status "    + fObj.canRead());
        System.out.println(fObj.getName() + " Write Permission status "   + fObj.canWrite());
        System.out.println(fObj.getName() + " Execute Permission status " + fObj.canExecute());

        // Get File Properties of the file object
        System.out.println("File: " + fObj.getName() + " last modified: " + fObj.lastModified());
        System.out.println("Size of File: " + fObj.getName()+ " is " + fObj.length() + " Bytes");

        // Renaming a file (of the file object) to a new name (specified in the new file object)
        // Create a new file object
        File nfObj = new File("c:\\tinitiate\\MyData.txt");
        // Use the new file object's name to rename file name
        System.out.println("Renaming the file: " + fObj.getName() + " to: "+ fObj.renameTo(nfObj)); 

        // Set File Permissions of the file object
        System.out.println(nfObj.getName() + " Set Read Permission status "    + nfObj.setReadable(true));
        System.out.println(nfObj.getName() + " Set Write Permission status "   + nfObj.setWritable(true));
        System.out.println(nfObj.getName() + " Set Execute Permission status " + nfObj.setExecutable(true));

        // Set File Properties
        // (1) Create a new time that you want to use.
        DateFormat formatter = new SimpleDateFormat("MM/dd/yy hh:mm:ss");
        Date FileModifydate = null;
        try {FileModifydate = (Date)formatter.parse("12/12/12 12:12:12"); }
        catch (ParseException e) { e.printStackTrace(); }
        
        // (2) Setting the Last Modified time to "12/12/12 12:12:12" Format MM/dd/yy hh:mmss.
        System.out.println("Status of File: " + nfObj.getName() + " Setting last modified to: "+ FileModifydate.toString()
                           + " " + nfObj.setLastModified(FileModifydate.getTime()));

        /**
         *  Disk Space metrics
         */
        // Create a new file object, Dont specify a fileName, specify a drive name or folder name
        File DiskObj = new File("c:\\");

        // Total free space on the partition on which the fileObject point to is:
        System.out.println("The Free Space on the Drive partition on which the file object points to : " + DiskObj.getFreeSpace());

        // Total total space on the partition on which the fileObject point to is:
        System.out.println("The total Space on the Drive partition on which the file object points to : " + DiskObj.getTotalSpace());

    }
}
