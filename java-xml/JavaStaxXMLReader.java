package javaxml;

import java.io.FileReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

/**
 * @author TINITIATE.COM / Venkata Bhattaram
 *
 * @TOPIC :  JAVA XML StAX Introduction
 *
 * @NOTES :  1) XML is a widely used data transport format.
 *           2) JAVA Provides "Simple API for XML" (SAX) to work with XML files.
 *           3) StAX "Streaming XML API"
 *           4) StAX is a "pull" AP, while SAX is a "push" API.
 *           5) StAX can read and write to an XML, While SAX can only read an XML.
 *           6) StAX API is interfaces only, there are no implementations by default,
 *              Developer needs to implement the Methods.
 *           7) StAX streams the entire XML document, by iterating over it
 *              similar to the ResultSet concept of JDBC, Parsing can be done either-ways  
 *              in forward or backward direction, This provides a significant advantage 
 *              when parsing large XML documents.   
 *           
 */

public class JavaStaxXMLReader {

    public static void main(String[] args) {

        try {
            // Create XMLInputFactory Factory Object
            XMLInputFactory xmlFactory = XMLInputFactory.newInstance();
            
            // Set Properties
            // IS_COALESCING,  parser coalesce adjacent character data sections.
            // Assumes whole text data as a Single event
            xmlFactory.setProperty(XMLInputFactory.IS_COALESCING, Boolean.TRUE);
            
            // Read the XML file (Source)
            XMLStreamReader xmlStream
                        = xmlFactory.createXMLStreamReader(new FileReader("c:\\tinitiate\\data.xml"));

            // Loop Through the XMLStreamReader
            while(xmlStream.hasNext()) {

                // Check if the next event is a StartElement
                // Note that We are Moving one step Ahead after Start of Document Start
                if(xmlStream.next() == xmlStream.START_ELEMENT) {
                    // Print the ElementName
                    System.out.println("Element Name " + xmlStream.getLocalName());

                    // Check if there are Any Attributes in the current Element
                    if (xmlStream.getAttributeCount() > 0) {
                        for (int aCtr = 0; aCtr < xmlStream.getAttributeCount(); aCtr++) {
                            // Print the AtributeName and Value
                            System.out.println("Attribute Name " + xmlStream.getAttributeLocalName(aCtr));
                            System.out.println("Attribute Value " + xmlStream.getAttributeValue(aCtr));
                        }
                    }
                    // Print the Attribute Value
                    if (xmlStream.hasText() && !xmlStream.getText().trim().isEmpty()) {
                        System.out.println("Element Value " + xmlStream.getText());
                    }
                }
            }
        } catch (Exception e) {
            // Prints the XML, that needs to be in the Specified Folder
            ProgramInfo();
            e.printStackTrace(); }
    }

    public static void ProgramInfo() {
        String SampleXML = "<?xml version=\"1.0\"?> " + "\n" +
                           " <music> " + "\n" +
                           "     <album id = \"1\" > " + "\n" +
                           "         <name>GreatSongs</name> " + "\n" +
                           "         <artist>Various Artists</artist> " + "\n" +
                           "        <price>20</price> " + "\n" +
                           "     </album> " + "\n" +
                           "    <album id = \"2\" > " + "\n" +
                           "         <name>PartySongs</name> " + "\n" +
                           "         <artist>StreetSingers</artist> " + "\n" +
                           "         <price>15</price> " + "\n" +
                           "     </album> " + "\n" +
                           " </music> ";

        System.out.println("----------------------------------------------------");
        System.out.println("!!! POSSIBLE ERROR !!!");
        System.out.println("Please Make Sure the following XML Code is in ");
        System.out.println("\"c:\\tinitiate\\data.xml\" File.");
        System.out.println("------XML START------");
        System.out.println(SampleXML);
        System.out.println("------XML END------\n");
    }
}
