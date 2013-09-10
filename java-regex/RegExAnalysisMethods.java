package JavaRegEx;
/**
 * 
 * METHOD: "matches"   : * Always start at the beginning of the target string.
 *                       * Match the Search RegEx sequence against a pattern.
 *                       * "matches" Returns TRUE if the entire target string is matched
 *                         else returns FALSE.
 *
 * METHOD: "lookingAt" : * Always start at the beginning of the target string.
 *                       * Match the Search RegEx sequence against a pattern.
 *                       * "lookingAt" Returns TRUE if the starting of the target string matches
 *                         else returns FALSE.
 * 
 */
import java.util.regex.*;

public class RegExAnalysisMethods
{
    public static void main( String args[] )
    {
       // String to be scanned to find the pattern.
       String TargetString = "Find me in me this string me, test me";
       String SearchExpression_literal = "Find";  // Default Pattern (RegEx ) group

       // Create a Pattern object
       Pattern r = Pattern.compile(SearchExpression_literal);
       // Now create matcher object.
       Matcher m = r.matcher(TargetString);
       
       System.out.println("Current TargetString string is: " + TargetString);
       System.out.println("Current Pattern / RegEx is: " + SearchExpression_literal);

       System.out.println("lookingAt(): " + m.lookingAt());
       System.out.println("matches(): " + m.matches());

       System.out.println("");

       // String to be scanned to find the pattern.
       TargetString = "Find me in me this string me";
       SearchExpression_literal = "Find me in me this string me";  // Default Pattern (RegEx ) group

       // Create a Pattern object
       r = Pattern.compile(SearchExpression_literal);
       // Now create matcher object.
       m = r.matcher(TargetString);

       System.out.println("Current TargetString string is: " + TargetString);
       System.out.println("Current Pattern / RegEx is: " + SearchExpression_literal);

       /**
        *  Matcher.lookingAt Returns TRUE if the starting of the target string matches
        *  else returns FALSE.
        */
       System.out.println("lookingAt(): " + m.lookingAt());

       /**
        *  Matcher.matches Returns TRUE if the entire target string is matched
        *  else returns FALSE.
        */
       System.out.println("matches(): " + m.matches());

       // String to be scanned to find the pattern.
       TargetString = "Find me in me this string me";
       SearchExpression_literal = "me";  // Default Pattern (RegEx ) group

       // Create a Pattern object
       r = Pattern.compile(SearchExpression_literal);
       // Now create matcher object.
       m = r.matcher(TargetString);

       System.out.println("Current TargetString string is: " + TargetString);
       System.out.println("Current Pattern / RegEx is: " + SearchExpression_literal);
    }
}
