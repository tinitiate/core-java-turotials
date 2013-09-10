package JavaStrings;
import java.io.*;
/** 
 * @author TINITIATE.COM
 * 
 * 
 * TOPIC   : String Class
 * 
 * CLASS   : StringClass (Using Built-in classes / Constructs)
 * PURPOSE : 1) StringsAndChars(): Understanding Char Arrays and String Class.
 * 			 2) charAt for Printing Char at a specified position in the string using charAt
 *           3) Finding the length of a string using length() method
 *           4) Comparing strings using the equals() method
 *           5) Comparing strings by ignoring case using equalsIgnoreCase() method
 *           6) Finding which string is greater (alphabetical) using the CompareTo() method 
 *           7) Ignoring the case finding which string is greater using compareToIgnoreCase() method
 *           8) Finding the Position of a string in another string, using indexOf() method 
 *           9) Extracting subset of string, part of string, using Substring Method
 *          10) Hash code of a string, using hashCode() method 
 *          11) Replacing characters in a string, replace() method
 *          12) Convert string toUpperCase() and toLowerCase()
 *          13) Comparing a String to another Object using compareTo()
 *          14) StringBuffer contentEquals
 *          15) copyValueOf() of a string into Char array
 *          16) startsWith; returns true if the suffix is equal to value specified, Else false 
 *          17) endsWith; returns true if the suffix is equal to value specified, Else false
 *          18) getBytes(String charsetName): Encodes String into byte array using the named charset
 *          19) getChars: copies characters from input string into a character array.
 *          20) indexOf, Returns the index within this string of the first occurrence
 *          21) Trim(), returns string omitting leading and trailing whitespaces.
 * 
 */
public class StringClass
{
    /**
     * @Name: StringsAndChars 
     * @Description: Understanding Char Arrays and String Class.
	 * @Parameters: None
     */
	public static void StringsAndChars()
	{
		// String Type is NOT a Native type
		String MyString1 = "TEST";
		System.out.println("String MyString1 :" + MyString1);

		// Character array
		char[] MyCharArray2 = {'T', 'E', 'S', 'T'};
		System.out.print("char[] MyCharArray2 :");
		// Print Char array
		for (char i: MyCharArray2)
		{ System.out.print(i); }

		System.out.println("");

		// Char Array to String
		String MyString3 = new String(MyCharArray2);
		System.out.println("String MyString3 = new String(MyCharArray2) :" + MyString3);		

		System.out.println("");

		// String to Char Array
		System.out.println("Converting from String to Char Array");
        char[] MyCharArray3 = MyString1.toCharArray();
		for (char j: MyCharArray3)
		{ System.out.print(j); }
	}

	/**
	 * @Name: Main Class to call all the StringClass methods
	 * 
	 */
	public static void main(String[] args)
	{
		System.out.println("--> Method StringsAndChars(); Start");
		System.out.println("");
		// Call the Method: StringsAndChars 
		StringsAndChars();
		System.out.println("");
		System.out.println("... Method StringsAndChars(); End");
		System.out.println("");

		/**
		 *  charAt for Printing Char at a specified position in the string using charAt
		 */
		char c;
		String s = "Hello World";
		int pos =6;

		System.out.println("charAt for Printing Char at a specified position in the string using charAt");
		c = s.charAt(pos);
	    System.out.println("The CHAR in String: "+s+" at Position: "+pos+" is: "+c);		
		System.out.println("");

		/**
		 *  Finding the length of a string using length() method
		 */
		System.out.println("Finding the length of a string using length() method");
		System.out.println("Length of String 's' is: "+s.length());
		System.out.println("");

		/**
		 *  Comparing strings using the equals() method
		 */
		System.out.println("Comparing strings using the equals() method");
		String src = "Demo1";
		String tar = "Demo1";
		if ( src.equals(tar) )
		{ System.out.println("Strings are equal"); }
		else
		{System.out.println("Strings are not equal");}
		System.out.println("");

		/**
		 *  Comparing strings by ignoring case using equalsIgnoreCase() method
		 */
		System.out.println("Comparing strings by ignoring case using equalsIgnoreCase() method");
		String src10 = "Demo1";
		String tar10 = "Demo1";

		System.out.println("src10: " + src10 + "tar10: " + tar10);

		if ( src10.equalsIgnoreCase(tar10) )
		{ 
		  System.out.println("Strings src10 and tar10 are equal"); 
		}
		else
		{
			System.out.println("Strings src10 and tar10 are NOT equal");
		}
		System.out.println("");

		/**
		 * Finding which string is greater (alphabetical) using the CompareTo() method 
		 */
		System.out.println("Finding which string is greater (alphabetical) using the CompareTo() method");
		String s1 = "ABC";
		String s2 = "XYZ";

		if ( s1.compareTo(s2) > 0)
		{ System.out.println("String s1: "+s1+" is greater than "+s2); }
		else
		{ System.out.println("String s2: "+s2+" is greater than s1"+s1); }

		/**
		 *  Ignoring the case finding which string is greater (alphabetical) using the compareToIgnoreCase() method
		 */
		System.out.println("Ignoring the case finding which string is greater (alphabetical) using the compareToIgnoreCase() method");
		String sa1 = "EAT";
		String sa2 = "eat";

		if ( sa1.compareToIgnoreCase(sa2) > 0)
		{ System.out.println("String sa1: "+sa1+" is greater than sa2"+sa2); }
		else
		{ System.out.println("String sa2: "+sa2+" is greater than sa1"+sa1); }
		System.out.println("");

		/**
		 * Finding the Position of a string in another string, using indexOf() method 
		 */
		System.out.println("Finding the Position of a string in another string, using indexOf() method");
		String s11= "I like java.";
		System.out.println(s11.indexOf("java"));
		System.out.println("");
		
		/**
		 *  Extracting subset of string, part of string, using Substring Method
		 *  NOTE: beginIndex inclusive, endIndex   exclusive.
		 */
		System.out.println("Extracting subset of string, part of string, using Substring Method");
		String s12 = "I like java";
		System.out.println(s12.substring(6,9));
		System.out.println("");
		/**
		 *  Hash code of a string, using hashCode() method 
		 */
		System.out.println("Hash code of a string, using hashCode() method");
		String s33 = "Hello Java";
		System.out.println("Hashcode of 'Hello Java' is:"+s33.hashCode());
		System.out.println("");

		/**
		 * Replacing characters in a string, replace() method
		 */
		System.out.println("Replacing characters in a string, replace() method");
		String s44 = "JAVA C++";
		System.out.println(s44.replace("C++", "JAVA"));
		System.out.println("");
		
		/**
		 * Converting a string to uppercase using toUpperCase() and 
		 * lowercase using  toLowerCase() methods
		 */
		System.out.println("Using toUpperCase() and toLowerCase()");
		String s55 = "Upper-Lower";
		System.out.println(s55.toUpperCase());
		System.out.println(s55.toLowerCase());
		System.out.println("");
		/**
		 *  Comparing a String to another Object
		 *  Returns 0 : If Source string [case INSensitive] equals to target string
		 *  Returns value less than 0: If Source string [case INSensitive] greater than target string
		 *  Returns value greater than 0: If Source string [case INSensitive] less than target string 
		 *  int compareTo(Object obj)
         *  int compareTo(String targetString)
         */
		  System.out.println("Comparing String to Objects using compareTo()");
	      String str71 = "AbC";
		  String str72 = "pQR";
	      String str73 = "XyZ";

	      System.out.println("str71: "+str71+ "str72: "+str72+ "str73: "+str73);	      
	      int res = str71.compareTo( str72 );
	      System.out.println("str71.compareTo( str72 )");
	      System.out.println(res);

	      res = str72.compareTo( str73 );
	      System.out.println("str72.compareTo( str73 )");
	      System.out.println(res);

	      res = str73.compareTo( str71 );
	      System.out.println("str73.compareTo( str71 )");
	      System.out.println(res);

	      System.out.println("");


		/**
         * StringBuffer contentEquals
         * This method returns true if the given String represents the same sequence of 
         * characters as the specified StringBuffer, else false.
         *  
         */
	      String strA1 = "TEST";
	      String strA2 = "test";
	      StringBuffer strB = new StringBuffer( "test");

	      boolean SBres = strA1.contentEquals( strB );
	      System.out.println(SBres);

	      SBres = strA2.contentEquals( strB );
	      System.out.println(SBres);

	      System.out.println("");
	     /**
	      * copyValueOf(char[] data)	
	      *     Returns String character sequence in the specified array.
	      *
	      * copyValueOf(char[] data, int offset, int count):
	      *     Returns String character sequence in the specified array.
	      */
		 char[] St1={'S','u','p','e','r','J','a','v','a'};

		 String St2 = "SuperJavaOthersToo";
		 St2.copyValueOf( St1 );
		 System.out.println(St2.copyValueOf( St1 ));
		 System.out.println(St2.copyValueOf( St1, 5, 4 ));
		 System.out.println("");
		 
	    /**
		 *  startsWith; returns true if the suffix is equal to value specified 
		 *  else returns false otherwise. 
		 */
	      String Str_stw = "Java is great";
	      System.out.println(Str_stw.startsWith("Java") );
	      System.out.println(Str_stw.startsWith("The") );
	      System.out.println("Checks for Specified prefix beginning a specified index");
	      System.out.println(Str_stw.startsWith("is",5) );
		  System.out.println("");

		/**
		 *  endsWith; returns true if the suffix is equal to value specified
		 *  else returns false otherwise. 
		 *   
         */
	      String Str = new String("This is Java");
	      boolean retVal1;

	      retVal1 = Str.endsWith( "Java" );
	      System.out.println("Returned  Value " + retVal1 );

	      retVal1 = Str.endsWith( "This" );
	      System.out.println("Returned  Value " + retVal1 );
	      System.out.println("");
	      
	    /**
	     * getBytes(String charsetName): Encodes String into byte array using the named charset
		 * getBytes():  Encodes String into byte array using system charset
	     */
	      String Str1 = new String("JAVA");
	      try{
	         byte[] Str2 = Str1.getBytes();
	         System.out.println("Returned  Value " + Str2 );

	         Str2 = Str1.getBytes( "UTF-8" );
	         System.out.println("Returned  Value " + Str2 );

	         Str2 = Str1.getBytes( "ISO-8859-1" );
	         System.out.println("Returned  Value " + Str2 );
	         }
	      catch( UnsupportedEncodingException e)
	      {
	         System.out.println("Unsupported character set");
	      }
	      System.out.println("");
	      
        /**
         * getChars: copies characters from input string into a character array.
         * getChars(int    SrcIndexStart,
         *          int    SrcIndexEnd,
         *          char[] TarCharArray,
         *          int    TarIndexStart)
         * SrcIndexStart : index of the first character in the string to copy.
         * SrcIndexEnd   : index after the last character in the string to copy.
         * TarCharArray  : the destination array.
         * TarIndexStart : the start offset in the destination array. 
         */ 
		 String S1 = new String("Java is good.");
		 char[] S2 = new char[4];
 	     S1.getChars(0, 4, S2, 0);
		 System.out.println(S2);
		 System.out.println("");
		 
		 /**		 
		  * public int indexOf(int ch): 
		  *     Returns the index within this string of the first occurrence 
		  *     of the specified character or -1 if the character does not occur.
		  * public int indexOf(int ch, int fromIndex): 
		  *     Returns the index within this string of the first occurrence 
		  *     of the specified character, starting the search at the 
		  *     specified index or -1 if the character does not occur.
		  * int indexOf(String str): 
		  *     Returns the index within this string of the first occurrence 
		  *     of the specified substring. If it does not occur as a
		  *     substring, -1 is returned.
		  * int indexOf(String str, int fromIndex): 
		  *     Returns the index within this string of the first occurrence 
		  *     of the specified substring, starting at the specified index.
		  *     If it does not occur, -1 is returned.
		  */
	      String lStr_1 = "Welcome to Java";
	      String lStr_2 = "Java";

	      System.out.println(lStr_1.indexOf('J'));
	      System.out.println(lStr_1.indexOf('J',4));
	      System.out.println(lStr_1.indexOf(lStr_2));
	      System.out.println(lStr_1.indexOf(lStr_2,4));
	      System.out.println("");
	      
	      /**
	       * Trim(), Returns the string omitting the  leading and trailing whitespace.
	       */
	      String StrTrim = "   Test  ";
	      System.out.println(" StrTrim Before Trim -->|" + Str +"|<--");
	      System.out.println(" StrTrim after Trim -->|" + Str.trim() +"|<--");
	      System.out.println("");	      
	}
}
