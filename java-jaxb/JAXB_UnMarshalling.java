package com.tinitiate.java.jaxb;

// @AUTHOR    tinitiate.com (c) 2014

// @FILE-NAME  JAXB_UnMarshalling.java

// @TOPIC     JAVA JAXB

// @NOTES  1) JAXB [Java Architecture for XML Binding] uses JAXB annotations 
//            to convert Java objects to XML and XML to Java Objects.
//            Marshalling    : convert Java objects to XML
//            Un-Marshalling : content XML to Java objects.
// 
//         2) Java JAXB is not directly comparable to DOM and SAX APIs, They are
//            are lower-level APIs to parse XML documents.
//
//         3) JAXB (Java API for XML Binding) is a higher-level API for converting 
//             XML elements and attributes to a Java objects (and vice versa)
//
//         4) Implementations of JAXB would inturn use DOM or SAX parser under the 
//  		  hood for actual XML parsing.
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

// @REQUIREMENTS 

//          1) Make sure the following XML file with the exact name is in the folder
//             "c:\tinitiate\data.xml"
//
//===================================================================================
//===================== This is the XML File used in this program ===================
//===================================================================================
//          ---- XML File Content Start ----
//
//			<?xml version="1.0"?> 
//				<music>
//             <music_year>2000</music_year>
//    			<album id = "1" > 
//                <album_name>GreatSongs</album_name> 
//                <artist>Various Artists</artist> 
//                <price>20</price> 
//    			</album> 
//   				<album id = "2" > 
//                <album_name>PartySongs</album_name> 
//                <artist>StreetSingers</artist> 
//                <price>15</price> 
//   				</album> 
//				</music>
//
//			---- XML File Content End ----
//===================================================================================

import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// =====================================================
// STEP - 1  : Create the POJO(Getter/Setter for every 
//             Element/Attribute of the XML, Using the 
//             Annotations provided.
// =====================================================

// The POJO Class which has the Getters and Setters to handle the XML Elements
// Lets create the class as per the XML contents
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
class Album {
   // Variables foreachof the elements of 
   // the nested element Album
   private String album_name;
   private String artist;
   private String price;

   // Constructors
   public Album() {}
   
   public Album(String album_name, String artist, String price) {  
       super();  
       this.album_name = album_name;
       this.artist     = artist;
       this.price      = price;
   }

   // =============================================
   // getters and setters for each of the variables
   // =============================================
   public String getAlbum_name() {
      return album_name;
   }

   public void setAlbum_name(String album_name) {
      this.album_name = album_name;
   }

   public String getArtist() {
      return artist;
   }

   public void setArtist(String artist) {
      this.artist = artist;
   }

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
class Music {
  
   // Create One Variable per XML element/attribute
   private String id; // Attribute
   private String music_year;
   // The element "album" is nested,
   // Here we will be using the above Class
   // which represents the album nested XML element
   private List<Album> album;

   // =============================================
   // getters and setters for each of the variables
   // =============================================
   
   // Annotate all the GETTERs
   @XmlAttribute
   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }
   
   @XmlElement
   public String getMusic_year() {
      return music_year;
   }

   public void setMusic_year(String music_year) {
      this.music_year = music_year;
   }
   
   @XmlElement
   public List<Album> getAlbum() {
      return album;
   }

   public void setAlbum(List<Album> album) {
      this.album = album;
   }

   // Constructors
   public Music() {}
   public Music(String id, String music_year, List<Album> album) {
       super();
       this.id           = id;
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

public class JAXB_UnMarshalling {

   public static void main(String[] args) {

      try {

         // Read the XML file into the file object
         File file = new File("C:\\tinitiate\\data.xml");

         JAXBContext jaxbContext = JAXBContext.newInstance(Music.class);

         Unmarshaller jaxbUnmarshaller  = jaxbContext.createUnmarshaller();
         
         //  Create an Elements
         Music xml_elements
                 = (Music) jaxbUnmarshaller.unmarshal(file);

         
         // Read the elements of the XML
         System.out.println("Music_year Element Value: " +
                            xml_elements.getMusic_year());
         
         // Reading the Nested Elements
         // Create an object of List of class type Nested Element Class "album"
         List<Album> album_obj = xml_elements.getAlbum();
         
         // Loop Through the List to print of each repeating elements in the XML
         for(Album a:album_obj) {
            System.out.println( a.getArtist()
                               + " " + a.getAlbum_name()
                               + " " + a.getPrice()
                              );
         }   
        
      } catch (JAXBException e) {
         e.printStackTrace();
      }
   }
}
