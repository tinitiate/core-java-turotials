package JavaRegEx;
/**
 * Regular Expressions
 * Target string:
 *     This is the string that we will be searching in for a search pattern.
 * Pattern / Search expression
 *      We search for this in the Target String.
 *      Its made up of the components: Literals and Meta-character 
 *      (Both are optional but either one is required)
 *   
 *       Literal:
 *           It is literally the string we want to find. No patterns but exact characters / Strings 
 *       Meta-character:
 *           Reserved character(s) with an unique meaning
 *           They are understood by the compiler
 *           They are anything but literals in the search expression.*
 *
 *       Escape sequence:
 *           An escape sequence are used to convert meta-characters into literals.
 */
 /******************************************************************************************/
 /**
  *  The java.util.regex package primarily consists of the following three classes:
  *  Pattern Class: 
  *      A Pattern object the representation of a compiled regular expression.
  *      The Pattern class provides no public constructors.
  *      To create a pattern, you must first invoke one of its public static compile methods, 
  *      which will then return a Pattern object.
  *      These methods accept a regular expression as the first argument.*
  *
  *  Matcher Class:
  *      A Matcher object is the engine that interprets the pattern
  *      Performs match operations against an target string.
  *      The Matcher class provides no public constructors.
  *      Create Matcher object by invoking the matcher method on a Pattern object.
  *
  *  PatternSyntaxException:
  *      PatternSyntaxException object is an exception to catch syntax error in a regular expression pattern.
  *
  */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExIntro
{
    public static void main( String args[] )
    {
        // String to be scanned to find the pattern.
        String TargetString = "Find me in me this string me, test me";
        String SearchExpression_literal = "me";  // Default Pattern (RegEx ) group

        // Create a Pattern object
        Pattern r = Pattern.compile(SearchExpression_literal);

        // Now create matcher object.
        Matcher m = r.matcher(TargetString);

        int SearchFindCounter = 0;
        /**
         *  Matcher.find() Returns Boolean for every occurrence found
         */
        while (m.find())
        { 
        	System.out.println(" -- -- -- -- ");
        	System.out.println("TargetString: " + TargetString);
        	System.out.println("SearchExpression '"+ SearchExpression_literal +"' occurrence#: "+(SearchFindCounter+1));

        	/** 
    	     *  group() method prints the exact string found.
    	     */
    	    System.out.println("SearchExpression: " + m.group());

    	    /**
    	     *  start()  method, Returns the start index of the pattern
    	     *  end()    method, Returns the end index of the pattern
    	     */
    	    System.out.println("SearchExpression Start Index m.start: " + m.start());
    	    System.out.println("SearchExpression End Index m.end: " + m.end());

    	    SearchFindCounter++;
        }
        System.out.println("Total occurrences of SearchExpression 'is' :"+SearchFindCounter);
    }
}
