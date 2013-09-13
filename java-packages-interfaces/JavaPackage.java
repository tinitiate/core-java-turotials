/** 
 * @author TINITIATE.COM
 * 
 * > TOPIC : Java Packages
 * 
 * > NOTES : 1) Packages are containers for classes, interfaces, enumerations and annotation types 
 *              related to a project or more commonly to a specific functionality.
 *           2) It serves two purposes
 *               (a) Every package creates a new namespace, which prevents any name conflicts, 
 *                   with members in other packages.(Class created in different packages, Could have same name.)
 *                   and is convenient to locate related classes. For example a fileWriter package could have
 *                   all the classes that are related to the fileWriting Process. And a GraphGenerator could
 *                   have its own package, to bundle all its classes.
 *               (b) Easier to provide access control to access classes across projects and functionality.
 *           3) To create a package, Add keyword "package" followed by a package-name in
 *              the Java source file. All classes declared in that file will belong to the 
 *              specified package.
 *           4) If no package is mentioned, the class belongs to the default package. Its Nameless package
 *           5) The package name in this file is "JavaPackagesAndInterfaces"
 *              will be put into an unnamed package.
 *           6) For a Class can directly access other class in the same package.
 *           7) For a class to access classes from other packages, the keyword 
 *              import <Package-Name> must be used., It can be used with the combination of Asterix(*),
 *              To select all classes in that package, or particular classes
 *              Example: import java.util.zip.* (or) import java.util.zip.ZipFile;
 *           8) Directory name of bytecode (.CLASS files), must be the same as the package name.
 *           9) Access Control of Class members (Variables and Methods) using packages:
 *                  Same class
 *                      Public Member is accessible.
 *                      Private Member is accessible.
 *                      Protected Member is accessible.
 *                      (No Modifier) Member is accessible.
 *
 *                  Same package subclass
 *                      Public Member is accessible.
 *                      Private Member is NOT accessible.
 *                      Protected Member is accessible.
 *                      (No Modifier) Member is accessible.
 *
 *                  Same package non-subclass
 *                      Public Member is accessible.
 *                      Private Member is NOT accessible.
 *                      Protected Member is accessible.
 *                      (No Modifier) Member is accessible.
 *
 *                  Different package subclass
 *                      Public Member is accessible.
 *                      Private Member is NOT accessible.
 *                      Protected Member is accessible.
 *                      (No Modifier) Member is NOT accessible.
 *
 *                  Different package non-subclass
 *                      Public Member is accessible.
 *                      Private Member is NOT accessible.
 *                      Protected Member is NOT accessible.
 *                      (No Modifier) Member is NOT accessible.
 *
 */
package JavaPackagesAndInterfaces;   // <---- PACKAGE DECLARATION
// Calling Class from the standard Package "java"
import java.util.regex.*;

// Class from the package "JavaPackagesAndInterfaces"
class PackageTest
{
	public void dummyMethod()
	{
        System.out.println("CLASS: PackageTest, METHOD: dummyMethod");
	}
}
public class JavaPackage
{
    /**
     * Static Method using the regex class from the Package: "java"
     */
	public static void StringFinder()
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
        if (m.find())
        { 
    	    System.out.println("Match Found");
        }
    }	
	public static void main(String[] args)
	{
		PackageTest obj1 = new PackageTest();
        // Direct Call to the Class from the same package: JavaPackagesAndInterfaces
		obj1 .dummyMethod();
		
		// Call to the Class of the imported package: "java.util"
		StringFinder();
	}
}
