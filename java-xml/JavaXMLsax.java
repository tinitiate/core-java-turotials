package javaxml;

import javax.xml.parsers.*;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.*;

/**
 * @author TINITIATE.COM / Venkata Bhattaram
 *
 * @TOPIC :  JAVA XML SAX Introduction
 *
 * @NOTES :  1) XML is a widely used data transport format.
 *           2) JAVA Provides "Simple API for XML" (SAX) to work with XML files.
 *           3) SAX is a Simple API for XML.
 *              3.1) SAX is an event based parser that Parses node by node.
 *              3.2) SAX Doesn’t store the XML in memory,
 *                   hence uses much less memory than DOM Parser.
 *              3.3) SAX cannot insert or delete a node. 
 *              3.4) SAX doesn’t preserve comments.
 *              3.5) SAX generally runs a little faster than DOM.
 *              3.6) SAX is a PUSH Parser, It iterates through the XML 
 *                   and calls methods created in the handler object.
 *           4) How does a SAX Parsing work? Heres How..
 *              4.1) There are 3 Steps in a simple SAX Parsing setup.
 *              4.2) STEP 1: Create the SAXParserFactory and SAXParser Objects
 *              4.3) STEP 2: Create and Use a Handler with the Parser,
 *                           to handle the Events of the XML 
 *              4.4) STEP 3: Associate the XML INPUT to the Handler
 *              4.4) Events are Methods in the DefaultHandler Class
 *                   Which needs to be OverRidden by the Programmer:
 *                   >Some Methods listed below   
 *                   >>// Document Specific Events                   
 *                      startDocument()
 *                          Receive notification of the beginning of the document.
 *                      endDocument()
 *                          Receive notification of the end of the document.
      
 *                   >>// Element Specific Events
 *                          startElement()
 *                              Identifies the START of a USER SPECIFIED 
 *                              Element name in the XML
 *                          characters()
 *                              Character Data inside an element.
 *                          endElement()
 *                               Identifies the END of a USER SPECIFIED
 *                               Element name in the XML
 *
 *          HOW TO READ THIS CODE:
 *              Start from the String: "== > START READING FROM HERE"    
 *
 */



/**
 * @CLASS JavaXMLsax extends DefaultHandler 
 * NOTE the extends DefaultHandler
 * SAX Parse uses a Handler in this case the DefaultHandler
 * The DEVELOPER Must OverRide the Methods that DefaultHandler provides.
 * 
 */
public class JavaXMLsax extends DefaultHandler {

    // This is the SAMPLE XML File, which this program uses.
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
        System.out.println("Please Make Sure the following XML Code is in ");
        System.out.println("\"c:\\tinitiate\\data.xml\" File.");
        System.out.println("------XML START------");
        System.out.println(SampleXML);
        System.out.println("------XML END------\n");
    }

    /**
     * == > START READING FROM HERE
     **/ 
    public static void main(String[] args) {

        try {
            // * STEP (1)
            //Create a "parser factory" for creating SAX parsers
            SAXParserFactory factory = SAXParserFactory.newInstance();
            // Use the factory to create a new SAXParser() Object 
            SAXParser      saxParser = factory.newSAXParser();
            // * STEP (2)
            // * Use the OverRide Methods from the Handler Implementing Class
            // * NOTE CLASS: tinSaxHandler is below
            DefaultHandler handler   = new tinSaxHandler();

            // * STEP (3)
            // Call the parse() Method, to Assign the XMLInput to the Handler  
            // The Handler In-Turn Looks for OverRidden 
            // methods [startDocument, endDocument, startElement ... ]
            saxParser.parse("c:\\tinitiate\\data.xml", handler);

        } catch (Exception err) {
            ProgramInfo(); // Print the Instructions if ERROR
            err.printStackTrace (); }
    }
}

// ********************************************************// 
// * @CLASS tinSaxHandler                                 *//  
// *        Class for Over Ride Methods of DefaultHandler *//
// ********************************************************//
class tinSaxHandler extends DefaultHandler {

    //*************************************************//
    //* OVERRIDE METHODS OF THE CLASS DefalutHandler  *//
    //*************************************************//

    // startDocument() Is called by the parser() when
    // START of XML Document is encountered  
    @Override
    public void startDocument() throws SAXException {
        System.out.println("");
    }

    // endDocument() Is called by the parser() when 
    // END of XML Document is encountered  
    @Override
    public void endDocument() throws SAXException {
        System.out.println("");
    }

    // startElement() Is called by the parser() when 
    // START of XML Element is encountered 
    @Override
    public void startElement( String     uri
                             ,String     localName
                             ,String     qName
                             ,Attributes attributes) throws SAXException {
            System.out.println("Element Name: " + qName);
            // Print Attribute details if Any
            if (attributes.getLength() >0 ) {
                System.out.println("Attribute Name: " + attributes.getLocalName(0));
                System.out.println("Attribute Value: "  + attributes.getValue(0));
            }
    }

    // characters(), Print all the Characters between the close and end element tag
    @Override
    public void characters( char[] ch
                           ,int    start
                           ,int    length) {
        System.out.println("\t" + new String(ch, start, length));
    }

    // endElement() Is called by the parser() when 
    // END of an XML Element is encountered  
    @Override
    public void endElement( String uri
                           ,String localName
                           ,String qName) {
        try {
            System.out.println("Element Name: " + qName);
       } catch (Exception    e)   { e.printStackTrace();  }
    }
}
