package com.tinitiate.java.jaxb;

// @AUTHOR     Venkata Bhattaram / tinitiate.com (c) 2014

// @FILE-NAME  JAXB_Marshalling.java

// @TOPIC      JAVA JAXB

// ==================================================================================
// @PREREQUISITES
//         1) Make sure the folder: "c:\tinitiate\" exists
// ==================================================================================

// @NOTES  1) JAXB [Java Architecture for XML Binding] uses JAXB annotations 
//            to convert Java objects to XML and XML to Java Objects.
//            Marshalling    : convert Java objects to XML
//            Un-Marshalling : content XML to Java objects.
//            This program demonstrates the Marshalling process. 
//
//         2) Java JAXB is not directly comparable to DOM and SAX APIs, They are
//            are lower-level APIs to parse XML documents.
//
//         3) JAXB (Java API for XML Binding) is a higher-level API for converting 
//             XML elements and attributes to a Java objects (and vice versa)
//
//         4) Implementations of JAXB would inturn use DOM or SAX parser under the 
//            hood for actual XML parsing.
//
//         5) JAXB was included as a standard library as part of the standard 
//             JRE from 1.6 prior to 1.6 a manual install of the JAR was required.
//
//         6) JAXB usage
//            ============================================================
//            6.1) Create a Getter/Setter for every XML element of the XML
//                 as a POJO (Plain Old Java Object) Class.
//            6.2) Annotate the POJO as XMLROOTELEMENT, XMLELEMENT, XMLATTRIBUTE.
//            6.3) Create the JAXBContext, Unmarshaller/marshaller Objects as needed
//            6.4) Refer to the XML ELements / Attributes usingthe JAXB Objects.
// 
//=>>>>>>  7) The usage is explained in the below "" steps.


//
//===================================================================================
//===================== This is the XML File That will be generated =================
//===================================================================================
//          ---- XML File Content Start ----
//
//         <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
//         <musicElement>
//             <album id="1">
//                 <album_name>Cool Music</album_name>
//                 <artist>GenX</artist>
//                 <price>200</price>
//             </album>
//            <album id="2">
//                 <album_name>Holy Cow</album_name>
//                <artist>Domestic Animals</artist>
//                 <price>100</price>
//             </album>
//             <music_year>2014</music_year>
//         </musicElement>
//
//       ---- XML File Content End ----
//===================================================================================

import java.util.List;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.FileOutputStream;  
import java.util.ArrayList;  
import javax.xml.bind.JAXBContext;  
import javax.xml.bind.Marshaller;  



// =====================================================
// STEP - 1  : Create the POJO(Getter/Setter for every 
//             Element/Attribute of the XML, Using the 
//             Annotations provided.
// =====================================================

// The POJO Class which has the Getters and Setters to handle the XML Elements
// Lets create the class as per the target XML contents
// Name:      Music
// Variables: music - Annotation XMLRootElement as per the XML 
//            album - A class to represent the inner elements

//            album_name - Variable if album class
//            artist     - Variable if album class
//            price      - Variable if album class
//            id         - Variable if album class, reresenting the Attribute of the
//                         eleemnt "album"

// Using Annotations to represent the XML Attributes and Elements
// @XmlRootElement specifies the root element of the XML.
// @XmlAttribute specifies the attribute(s) of the XML.
// @XmlElement specifies the sub element of the root element of the XML.

// ======================================================
// Starting from the innermost nested elements of the XML
// The "album" element, Create a class.
// This has the elements: album_name, artist and price
// ======================================================
class AlbumElement {
   
   // Variables for the Attribute
   private String id;

   // Variables foreachof the elements of 
   // the nested element Album
   private String album_name;
   private String artist;
   private String price;

   // Constructors
   public AlbumElement() {}
   
   public AlbumElement(String id, String album_name, String artist, String price) {  
       super();
       this.id         = id;
       this.album_name = album_name;
       this.artist     = artist;
       this.price      = price;
   }

   // ============================================================
   // getters and setters for each of the XML-ATTRIBUTE Variables
   // ============================================================
   // Annotate the XML Attribute (Getters only)
   @XmlAttribute
   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   // ==========================================================
   // getters and setters for each of the XML-ELEMENT Variables
   // ==========================================================
   // Annotate the XML Elements (Getters only)
   @XmlElement
   public String getAlbum_name() {
      return album_name;
   }

   public void setAlbum_name(String album_name) {
      this.album_name = album_name;
   }
   
   @XmlElement
   public String getArtist() {
      return artist;
   }

   public void setArtist(String artist) {
      this.artist = artist;
   }

   @XmlElement
   public String getPrice() {
      return price;
   }

   public void setPrice(String price) {
      this.price = price;
   }
}

// ======================================================
// Now create the class that has the outer XML elements
// With the inner nested elements as Class Objects List,
// So that the List elements can be iterated over to read
// the multiple inner elements
// ======================================================

@XmlRootElement
class MusicElement {
  
   // Create One Variable per XML element
   private String music_year;
   
   // The element "album" is nested,
   // Here we will be using the above Class
   // which represents the album nested XML element
   private ArrayList<AlbumElement> album;

   // =============================================
   // getters and setters for each of the variables
   // =============================================   
   @XmlElement
   public String getMusic_year() {
      return music_year;
   }

   public void setMusic_year(String music_year) {
      this.music_year = music_year;
   }
   
   @XmlElement
   public ArrayList<AlbumElement> getAlbum() {
      return album;
   }

   public void setAlbum(ArrayList<AlbumElement> album) {
      this.album = album;
   }

   // Constructors
   public MusicElement() {}
   public MusicElement(String music_year, ArrayList<AlbumElement> album) {
       super();
       this.music_year   = music_year;
       this.album        = album;
   }
}

// =====================================================================
// STEP - 2  : - Create the JAXB Object, with the instance
//               of the POJO Class,with elements 
//               and setters and getters.
//             - Create the Unmarshaller Object, to read 
//               from the XML.
//             - Create the POJO class and CAST the Unmarshaller Object
//               to the POJO class.
// =====================================================================

// Class to Read an XML file using JAXB

public class JAXB_Marshalling {

   public static void main(String[] args) throws Exception {

      try {

            JAXBContext jaxbObj = JAXBContext.newInstance(MusicElement.class);  

            Marshaller marshallerObj = jaxbObj.createMarshaller();  
            marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  

            // =========================
            //  Create Data for Elements
            // =========================

            // 1) Create Nested Elements data
            AlbumElement NestedElement1 
                    = new AlbumElement( "1", "Cool Music", "GenX", "200" );

            AlbumElement NestedElement2 
                    = new AlbumElement( "2", "Holy Cow", "Domestic Animals", "100" );

            // Add both the elements to a ArrayLIST
            ArrayList<AlbumElement> NestedElements = new ArrayList<AlbumElement>();
            NestedElements.add(NestedElement1);
            NestedElements.add(NestedElement2);
                    
            // 2) Add the nested Elements data to the outer element
            MusicElement OuterElement =
                    new MusicElement ( "2014"            // Music Year Element of XML
                                      ,NestedElements ); // Nested Album Element

            marshallerObj.marshal( OuterElement,new FileOutputStream("c:\\tinitiate\\MusicAlbum.xml"));

      } catch (JAXBException e) {
         e.printStackTrace();
      }
   }
}   
