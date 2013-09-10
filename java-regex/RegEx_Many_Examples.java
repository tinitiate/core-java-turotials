package JavaRegEx;

import java.util.regex.*;

/**
 * ******************************************
 * All examples with replaceAll method,     *
 * wrapped inside the RegEx custom method   *
 * ******************************************
 * 1)  Matches any single character using '.'
 * 2)  Matches start of line '^'
 * 3)  Matches END of line '$'
 * 4)  Matches any single character in brackets. [...]
 * 5)  Matches any single character NOT in brackets. [^...]
 * 6)  Matches Beginning of entire string '\\A'
 * 7)  Matches End of entire string '\\z'
 * 8)  Matches End of entire string except valid final line terminator CAPS(Z) '\\Z'
 * 9)  Matches 0 or more occurrences of preceding expression. '*'
 * 10) Matches 1 or more of the preceding expression. '+'
 * 11) Matches 0 or 1 occurrence of preceding expression. '?'
 * 12) Matches exactly n number of occurrences of preceding expression. 'exp{n}'
 * 13) Matches n or more occurrences of preceding expression. 'exp{n,}'
 * 14) Matches exactly n occurrences and m times, of preceding expression. 'exp{n,m}'
 * 15) Matches  X OR Y. 'X|Y'
 * 16) Matches word characters '\\w'
 * 17) Matches NON word characters '\\W'
 * 18) Matches whitespace. Equivalent to [\t\n\r\f]. '\\s'
 * 19) Matches NON whitespace. NOT Equivalent to [\t\n\r\f]. '\\S'
 * 20) Matches digits. Equivalent to [0-9]. '\\d'
 * 21) Matches NON digits. '\\D'
 * 
 */
public class RegEx_Many_Examples
{
    public static void RegEx(String p_RegEx, String p_TargetString, 
    		                 String p_RegExPattern, String p_ReplaceString)
    {

    	System.out.println("");
    	System.out.println("-------------------------------------");
    	System.out.println("Example RegEx   : " + p_RegEx);
    	System.out.println("Target String   : " + p_TargetString);
    	System.out.println("Search for      : " + p_RegExPattern);
    	System.out.println("Replace with    : " + p_ReplaceString);

    	String l_RegEx;
    	// Create a RegEx / Pattern object
 	    Pattern p = Pattern.compile(p_RegExPattern);
		// get a RegEx / matcher object
		Matcher m = p.matcher(p_TargetString);

		l_RegEx = m.replaceAll(p_ReplaceString);
		System.out.println("Replaced String : " + l_RegEx);
    	System.out.println("-------------------------------------");
    	System.out.println("");
    }

    public static void main(String[] args)
	{
    	// All Declarations
    	String RegEx;
    	String TargetString;
    	String RegExPattern;
    	String ReplaceString;

        // 1)Matches any single character using '.'
    	RegEx = "1) Matches any single character using '.'";
    	TargetString  = "ABCDEFG";
    	RegExPattern  = "B(.)D";
    	ReplaceString = "BXD";
    	RegEx(RegEx, TargetString, RegExPattern, ReplaceString); // Call the STATIC method

        // 2) Matches start of line '^'
    	RegEx = "2) Matches START of line '^'";
    	TargetString  = " is a line.";
    	RegExPattern  = "^";
    	ReplaceString = "Here";
    	RegEx(RegEx, TargetString, RegExPattern, ReplaceString); // Call the STATIC method

    	RegEx = "3) Matches END of line '$'";
    	TargetString  = "This is a ";
    	RegExPattern  = "$";
    	ReplaceString = "line";
    	RegEx(RegEx, TargetString, RegExPattern, ReplaceString); // Call the STATIC method

    	RegEx = "4) Matches any single character in brackets. [...]";
    	TargetString  = "SAT SIT SET";
    	RegExPattern  = "S[AI]T";
    	ReplaceString = "SXT";
    	RegEx(RegEx, TargetString, RegExPattern, ReplaceString); // Call the STATIC method

    	RegEx = "5) Matches any single character NOT in brackets. [^...]";
    	TargetString  = "SAT SIT SET";
    	RegExPattern  = "S[^AI]T";
    	ReplaceString = "SXT";
    	RegEx(RegEx, TargetString, RegExPattern, ReplaceString); // Call the STATIC method

    	RegEx = "6) Matches Beginning of entire string '\\A' ";
    	TargetString  = "there was PASCAL";
    	RegExPattern  = "\\A";  // Using the Escape Character "\"
    	ReplaceString = "Once upon a time ";
    	RegEx(RegEx, TargetString, RegExPattern, ReplaceString); // Call the STATIC method

    	RegEx = "7) Matches End of entire string '\\z' ";
    	TargetString  = "there was ";
    	RegExPattern  = "\\z";  // Using the Escape Character "\"
    	ReplaceString = "PASCAL.";
    	RegEx(RegEx, TargetString, RegExPattern, ReplaceString); // Call the STATIC method

    	RegEx = "8) Matches End of entire string except valid final line terminator CAPS(Z) '\\Z'";
    	TargetString  = "there was \n";
    	RegExPattern  = "\\Z";  // Using the Escape Character "\"
    	ReplaceString = "PASCAL.";
    	RegEx(RegEx, TargetString, RegExPattern, ReplaceString); // Call the STATIC method

    	RegEx = "9) Matches 0 or more occurrences of preceding expression. '*'";
    	TargetString  = "JA is Cool, JAJA is Cool";
    	RegExPattern  = "J*";
    	ReplaceString = "JAVA";
    	RegEx(RegEx, TargetString, RegExPattern, ReplaceString); // Call the STATIC method

    	RegEx = "10) Matches 1 or more of the preceding expression. '+'";
    	TargetString  = "JA is Cool, JAJA is Cool";
    	RegExPattern  = "J+";
    	ReplaceString = "JAVA";
    	RegEx(RegEx, TargetString, RegExPattern, ReplaceString); // Call the STATIC method

    	RegEx = "11) Matches 0 or 1 occurrence of preceding expression. '?'";
    	TargetString  = "JA is Cool, JAJA is Cool";
    	RegExPattern  = "J?";    	
    	ReplaceString = "JAVA";
    	RegEx(RegEx, TargetString, RegExPattern, ReplaceString); // Call the STATIC method

    	RegEx = "12) Matches exactly n number of occurrences of preceding expression. 'exp{n}'";
    	TargetString  = "avav av avavav avavavavavav";
    	RegExPattern  = "(av){2}";
    	ReplaceString = "JAVA";
    	RegEx(RegEx, TargetString, RegExPattern, ReplaceString); // Call the STATIC method

    	RegEx = "13) Matches n or more occurrences of preceding expression. 'exp{n,}'";
    	TargetString  = "avav av avavav avavavavavav";
    	RegExPattern  = "(av){2,}";
    	ReplaceString = "JAVA";
    	RegEx(RegEx, TargetString, RegExPattern, ReplaceString); // Call the STATIC method

    	RegEx = "14) Matches exactly n occurrences and m times, of preceding expression. 'exp{n,m}'";
    	TargetString  = "avav av avavav avavavavavav";
    	RegExPattern  = "(av){2,2}";
    	ReplaceString = "JAVA";
    	RegEx(RegEx, TargetString, RegExPattern, ReplaceString); // Call the STATIC method

    	RegEx = "15) Matches  X OR Y. 'X|Y'";
    	TargetString  = "ERLANG is great";
    	RegExPattern  = "(ERLANG|SCALA)";
    	ReplaceString = "JAVA";
    	RegEx(RegEx, TargetString, RegExPattern, ReplaceString); // Call the STATIC method

    	RegEx = "16) Matches word characters '\\w'";
    	TargetString  = "Java is great";
    	RegExPattern  = "(\\w)";
    	ReplaceString = "JAVA";
    	RegEx(RegEx, TargetString, RegExPattern, ReplaceString); // Call the STATIC method

    	RegEx = "17) Matches NON word characters '\\W'";
    	TargetString  = "Java is great";
    	RegExPattern  = "(\\W)";
    	ReplaceString = "JAVA";
    	RegEx(RegEx, TargetString, RegExPattern, ReplaceString); // Call the STATIC method

    	RegEx = "18) Matches whitespace. Equivalent to [\t\n\r\f]. '\\s'";
    	TargetString  = "Java is	great";
    	RegExPattern  = "(\\s)";
    	ReplaceString = "JAVA";
    	RegEx(RegEx, TargetString, RegExPattern, ReplaceString); // Call the STATIC method

    	RegEx = "19) Matches NON whitespace. NOT Equivalent to [\t\n\r\f]. '\\S'";
    	TargetString  = "Java is	great";
    	RegExPattern  = "(\\S)";
    	ReplaceString = "JAVA";
    	RegEx(RegEx, TargetString, RegExPattern, ReplaceString); // Call the STATIC method

    	RegEx = "20) Matches digits. Equivalent to [0-9]. '\\d'";
    	TargetString  = "Java is Number 1 !!";
    	RegExPattern  = "(\\d)";
    	ReplaceString = "one";
    	RegEx(RegEx, TargetString, RegExPattern, ReplaceString); // Call the STATIC method

    	RegEx = "21) Matches NON digits. '\\D'";
    	TargetString  = "1a2b3";
    	RegExPattern  = "(\\D)";
    	ReplaceString = "JAVA";
    	RegEx(RegEx, TargetString, RegExPattern, ReplaceString); // Call the STATIC method

	}
}
