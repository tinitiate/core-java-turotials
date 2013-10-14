package javaxml;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author TINITIATE.COM / Venkata Bhattaram
 *
 * @TOPIC :  JAVA XML DOM Parser Advanced (Programmatically determine the Elements and Attributes)
 * 
 * @NOTES :  1) Programmatically determine the Element Names and Values, Attribute Names and Values
 *              using DOM Parser.
 *           2) JAVA DOM to get Unknown Elements and Attributes.
 *           3) Steps to achieve this:
 *              3.1) Parse the Input XML
 *              3.2) Check for RootElement Name, ChildElements
 *              3.3) Check for RootElement Attributes
 *              3.4) Recursively Check for ChildElement Name, Attributes, Siblings, Childs-Child.
 *
 */

/**
 * @CLASS: This Class HOLDS THE most atomic (Most Basic) XML Components
 *         ElementName, ElementValue, ElementAttrubuteName and ElementAttrubuteValue
 */
class AtomicXML {
    public String ElementName;
    public String ElementValue;
    public String ElementAttrubuteName;
    public String ElementAttrubuteValue;

    // Constructor (Setter)
    public AtomicXML( String ElementName
                     ,String ElementValue
                     ,String ElementAttrubuteName
                     ,String ElementAttrubuteValue) {
        this.ElementName            = ElementName;
        this.ElementValue           = ElementValue;
        this.ElementAttrubuteName   = ElementAttrubuteName;
        this.ElementAttrubuteValue  = ElementAttrubuteValue;
    }
}

/**
 * @CLASS: This is the Main Class
 */
public class JavaDOMxmlAdvanced {

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

    // Recursive Method to parse through the XML file.
    private static void getDetails (Element CurrElement, ArrayList<AtomicXML> ElementList) {
        NodeList ChildElements       = CurrElement.getChildNodes();

        // Variables to Store the Simplest (Lowest Level XML Elements and Attributes info.
        String AtomicElementName     = "", AtomicElementValue = "";
        String AtomicElementAttrName = "", AtomicElementAttrValue = "";

        for (int i = 0; i < ChildElements.getLength(); i++) {
            Node n = ChildElements.item(i);

            // Get Node Name and Value
            AtomicElementName  = n.getNodeName();
            AtomicElementValue = n.getTextContent();

            // Get Node AttributeName and Value
            if (n.hasAttributes()) {
                NamedNodeMap nnm = n.getAttributes();
                try {
                    for (int j=0; j<=nnm.getLength(); j++ ) {
                        Attr a = (Attr)nnm.item(j);
                        if (a.getName().equals(null)) { }
                        else { 
                            AtomicElementAttrName  = a.getName();
                            AtomicElementAttrValue = a.getValue();
                        }
                    }
                } catch (Exception ee) {}   
            }
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                ElementList.add(new AtomicXML( AtomicElementName
                                              ,AtomicElementValue
                                              ,AtomicElementAttrName
                                              ,AtomicElementAttrValue));

                /**
                 **  Recursive Check for Elements
                 **/
                getDetails ((Element)n, ElementList);
            }
        }
    }

    // Main Method of the program
    public static void main(String[] args) {

        try {
            // Location of the XML file
            File XMLfile = new File("c:\\tinitiate\\data.xml");

            // Create DocumentBuilderFactory, DocumentBuilder and Document Objects
            DocumentBuilderFactory docFactory =  DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder        =  docFactory.newDocumentBuilder();
            Document doc                      =  docBuilder.parse(XMLfile);
            ArrayList<AtomicXML> AllXMLelements = new ArrayList<AtomicXML>();

            // Get the ROOT Element
            Element currElement = doc.getDocumentElement();

            // Get all node details
            getDetails (currElement, AllXMLelements);
            
            for (AtomicXML o : AllXMLelements) {
                System.out.println(o.ElementName);
                System.out.println(o.ElementValue);
                System.out.println(o.ElementAttrubuteName);
                System.out.println(o.ElementAttrubuteValue);
                System.out.println("");
            }

        } catch (Exception e) { 
            // Prints the PreReqs for this Program
            ProgramInfo();
            e.printStackTrace();
          }
    }
}
