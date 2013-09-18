package JavaSerialization;

import java.io.*;


/**
 * @author TINITIATE.COM
 *
 * > TOPIC : JAVA Serialization
 * 
 * > NOTES : JAVA Serialization
 *           1) Java's Mechanism, to represent an object as a sequence of bytes is called serialization.
 *           2) It captures the Object-Type (Class which the object belongs to) and the data assigned 
 *              class member variables.
 *           3) These Bytes can be written to a file, and read at a later time.
 *           4) The file should be read to be "Deserialized" and use the data in a program to recreate 
 *              the object in memory.
 *           5) The entire process is JVM independent, meaning an object can be serialized on one 
 *              platform and deserialized on another.
 *           6) Practical applications:
 *                  - Serialization is mainly used to send objects across the network applications 
 *                    like (RMI, Spring HttpInvoker..)
 *                  - Can be used for session replication between clustered JVM instances.
 *                  - Serialization across JVM versions and Class Versions
 *                    ( For Various Class versions,Common practice Use a class serialVersionID and Description 
 *                      field, to indicate serialization compatibility and make notes in JavaDoc. )
 *           7) Advantages:
 *                  - Java Provides easy method to grab, Objects data and simple calls to create to bytes
 *                    and write to file.
 *                  - Easy to deserialize
 *           8) Disadvantages:
 *                  - Using Serialization durable persistent storage is questionable
 *                  - It is impossible to query and analyze, as the files generated are in binary format.
 *                  - Maintenance issues with changes to Classes.
 *                  - Could be slow for large data sets.
 *                  - Known issues with Serialized objects with Swing classes.
 *           9) Alternatives:
 *                  - Save data in JSON and XML format, More Open and common formats.
 *                  - For long term data persistence use an RDBMS.
 *           10)  Sample Implementation:
 *                
 *                10.1) Classes ObjectInputStream and ObjectOutputStream 
 *                      provide methods for serializing and deserializing an object.
 *                10.2) For class to be serialized two conditions must be met:
 *                        - It must implement the java.io.Serializable interface.
 *                        - All of the fields in the class must be serializable.
 *                        - For a field to be not serializable, mark it as "transient".
 * 
 *  
 */


// Class to serialize
class WorldNations implements java.io.Serializable
{
   public String CountryName;
   public String CountryCapital;
   // This is a NON-serializable field
   transient public int CountryPopulation;

   public void CountryDetails()
   {
      System.out.println(  "Country Name: " + CountryName
                         + "Capital City: " + CountryCapital);
   }
}

public class JavaSerialization
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        // Create an Object of WorldNations
        WorldNations USA = new  WorldNations();
        // Add data to the Object
        USA.CountryName = "U.S.A";
        USA.CountryCapital = "Washington DC";

        System.out.println("Serialization of the Object data");
        /**
         *  Code to Serialize the Object
         **/
        // Create an output file to save the data
        FileOutputStream OutFile       =  new FileOutputStream("c:\\ubs\\USA.ser");
        ObjectOutputStream ObjectOut   =  new ObjectOutputStream(OutFile);

        // Write the object to the Stream.. to the file 
        ObjectOut.writeObject(USA);
        ObjectOut.close();
        OutFile.close();

        /**
         *  Code to De-Serialize the Object
         **/
        // Create an Object of WorldNations
        WorldNations DeSerUSA;

        // Read the Serialized object data from the file
        FileInputStream InFile = new FileInputStream("c:\\ubs\\USA.ser");
        ObjectInputStream ObjectIn = new ObjectInputStream(InFile);

        // De-Serialize data
        DeSerUSA = (WorldNations) ObjectIn.readObject();
        ObjectIn.close();
        InFile.close();
        
        // Call the Method to read the De-Serialized data
        System.out.println("\nReading the De-Serialized data");
        DeSerUSA.CountryDetails();
    }
}
