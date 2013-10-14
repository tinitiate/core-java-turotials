package javaxml;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

/**
 * @author TINITIATE.COM / Venkata Bhattaram
 *
 * @TOPIC :  JAVA XML Document Object Model (DOM) API Parser Extract Elements and Atributes
 *           From Specified Element and Attribute Names.
 * 
 * @NOTES :  1) DOM XML Parser, Loads the entire XML document into memory before processing 
 *           2) It is a tree model parser which enables programmer to 
 *               Traverse in any direction.
 *           3) Since the entire XML Document is loaded into the memory, if the XML is large
 *               DOM Parsing occupies more memory, Making the Process slower    
 *           4) Nodes can be inserted or deleted and comments are Preserved.
 *           ************************   
 *           ** ABOUT THIS PROGRAM **
 *           ************************
 *           5) THIS PROGRAM Reads the XML "Pre-KNOWN" elements,
 *              > This code assumes the programmer knows the XML structure  
 *           6) THIS PROGRAM DOES NOT Extract the XML Element Names.
 * 
 */

public class JavaDOMxml {

    // This is the SAMPLE XML File, which this program uses.
    public static void ProgramInfo () {
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
        System.out.println("Please Make Sure the following XML Code is in ");
        System.out.println("\"c:\\tinitiate\\data.xml\" File.");
        System.out.println("------XML START------");
        System.out.println(SampleXML);
        System.out.println("------XML END------\n");
    }

    public static void main(String[] args) {
        try {
            // Location of the XML file
            File XMLfile = new File("c:\\tinitiate\\data.xml");

            // Create DocumentBuilderFactory, DocumentBuilder and Document Objects
            DocumentBuilderFactory docFactory =  DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder        =  docFactory.newDocumentBuilder();
            Document doc                      =  docBuilder.parse(XMLfile);

            // Get the ROOT Element
            Element RootElement = doc.getDocumentElement();
            System.out.println("Root Element: " + RootElement.getNodeName());

            // Read All Child Nodes of a Known Element Name
            NodeList allNodes = doc.getElementsByTagName("album");

            // Loop through the NodeList
            for (int i=0; i < allNodes.getLength(); i++) {
                Node n = allNodes.item(i);
                if (n.getNodeType() == Node.ELEMENT_NODE) {

                    // Cast the Node as Element
                    Element e = (Element)n;
                    System.out.println("Element #" + (i+1));
                    // Read HardCoded element "name"
                    System.out.println(e.getElementsByTagName("name").item(0).getTextContent());
                    // Read HardCoded element "name"'s Attribute "id"
                    System.out.println("Attribute id: " + e.getAttribute("id"));
                    // Read HardCoded element "artist"
                    System.out.println(e.getElementsByTagName("artist").item(0).getTextContent());
                    // Read HardCoded element "price"
                    System.out.println(e.getElementsByTagName("price").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
              e.printStackTrace();
        }
    }    
}
