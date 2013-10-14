package javaxml;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

/**
 * @author TINITIATE.COM / Venkata Bhattaram
 *
 * @TOPIC :  JAVA XML StAX Introduction
 *
 * @NOTES :  1) The XMLEventWriter class in the Java StAX API 
 *              provides write for various StAX XMLEvent
 *
 */

public class JavaStaxXMLWriter {

    public static void main(String[] args) {

        XMLOutputFactory factory      = XMLOutputFactory.newInstance();
        XMLEventFactory  eventFactory = XMLEventFactory.newInstance();

        try {
            XMLEventWriter xmlWriter 
                 = factory.createXMLEventWriter(new FileWriter("c:\\tinitiate\\target.xml"));

            // Creates the XML Document Start
            XMLEvent myEvent = eventFactory.createStartDocument();
            xmlWriter.add(myEvent);

            // XML Start Element
            myEvent = eventFactory.createStartElement( "","","TinitiateXML");
            xmlWriter.add(myEvent);

                // Simple Element Start
                myEvent = eventFactory.createStartElement( "","","SimpleElement");
                xmlWriter.add(myEvent);

                // Assign value to the Simple Element                    
                myEvent = eventFactory.createCharacters("This is the value of Element1");
                xmlWriter.add(myEvent);

                // Simple Element End
                myEvent = eventFactory.createEndElement("SimpleElement", "", "");
                xmlWriter.add(myEvent);

                // Element with Attribute Start
                Attribute attribute = eventFactory.createAttribute("version", "1");
                List attributeList = Arrays.asList(attribute);                
                myEvent = eventFactory.createStartElement
                        ( "","","ElementWithAttribute",attributeList.iterator(),null);
                xmlWriter.add(myEvent);

                // Assign value
                myEvent = eventFactory.createCharacters("This is the value of ElementWithAttribute");
                xmlWriter.add(myEvent);

                // Element with Attribute End
                myEvent = eventFactory.createEndElement("ElementWithAttribute", "", "");
                xmlWriter.add(myEvent);

            // End the XML Document
            myEvent = eventFactory.createEndElement("TinitiateXML", "", "");
            xmlWriter.add(myEvent);

            // Write and Close
            xmlWriter.flush();
            xmlWriter.close();

        } catch (XMLStreamException e) { e.printStackTrace(); }
        catch (IOException e) {
              System.out.println("Make Sure there is a Directory c:\\tinitiate\\");
              e.printStackTrace();
        }
    }
}
