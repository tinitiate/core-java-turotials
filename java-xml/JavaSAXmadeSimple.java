package javaxml;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author TINITIATE.COM / Venkata Bhattaram
 *
 * @TOPIC :  JAVA XML SAX Introduction
 *
 * @NOTES :  1) A clean and simple example (a bit length), but made easy.
 *           2) Start Reading the Program from the String "#START READING FROM HERE#"   
 * 
 **/

public class JavaSAXmadeSimple {

    /**
     * #START READING FROM HERE#
     */
    public static void main(String[] args) {

        try {
            // STEP 1
            // Create a SAXParserFactory Object and SAXParser Object
            SAXParserFactory xmlFactoryObject  = SAXParserFactory.newInstance();
            SAXParser        xmlParserObject   = xmlFactoryObject.newSAXParser();

            // STEP 2
            //      STEP 2.1) Create a custom Handler Class
            //                Look for the Class TinitiateSAXHandler BELOW
            //      STEP 2.2) Create the Handler Object
            DefaultHandler customhandlerObject   = new TinitiateSAXHandler();

            // STEP 3
            // Parse an XML file using the Custom Handler,
            // Using the parse() method
            xmlParserObject.parse("c:\\ubs\\javaxml\\data.xml",customhandlerObject);

        } catch (Exception e) { e.printStackTrace(); }
    }
}

// STEP 2.1
// Class for a Handler, By Extending the DefaultHandler class
// OverRide the methods that the DefaultHandler class provides
// Each Method has a specific purpose and can be 
// implemented by the developer.
class TinitiateSAXHandler extends DefaultHandler {

    // startDocument() Is called by the parser() when
    // START of XML Document is encountered  
    @Override
    public void startDocument() throws SAXException {
        System.out.println("----XML Document Parsed Output Start----");
    }


    // startElement() Is called by the parser() when 
    // START of XML Element is encountered 
    @Override
    public void startElement( String     uri
                             ,String     localName
                             ,String     qName
                             ,Attributes attributes) throws SAXException
   {
        // Check if there is any Data to Print
        if (qName.trim().length() != 0 ) {
            System.out.println("Element Name: " + qName);
            // Print Attribute details if Any
            if (attributes.getLength() > 0 ) {
                System.out.println("Attribute Name: " + attributes.getLocalName(0));
                System.out.println("Attribute Value: "  + attributes.getValue(0));
            }
        }
    }

    // characters(), Print all the Characters between the close and end element tag
    @Override
    public void characters( char[] ch
                           ,int    start
                           ,int    length) {
        String xmlData = new String(ch, start, length);
        // Check if there is any Data to Print
        if (xmlData.trim().length() != 0 ) {
            System.out.println("Element Value: " + new String(ch, start, length));
        }    
    }

    // endDocument() Is called by the parser() when 
    // END of XML Document is encountered
    // Can be used to add some Post Parsing actions
    @Override
    public void endDocument() throws SAXException {
        System.out.println("----XML Document Parsed Output End----");
    }
}
