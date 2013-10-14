package javaannotations;

/**
 * @author TINITIATE.COM / Venkata Bhattaram
 *
 * @TOPIC :  JAVA Annotations Introduction and Basics 
 * 
 * @NOTES :  1) Java annotations is a mechanism for including metadata  and reading it 
 *              directly in the source code introduced in J2SE 1.5
 *           2) MetaData includes, Comments, Parameter Types, if the method is OverRidden or Inherited..
 *              and many more properties, Annotation tags are checked by the compiler and this helps 
 *              to provide meaningful and more precise warnings at compile time, these can also be used 
 *              by build tools to, make the build fail if some unexpected code is present.
 *           3) Annotations can be used as a information source about the code to the compiler;
 *              made available for compile-time or deployment-time processing
 *           4) There are built-in and custom Annotations.
 *           5) Scope of this program covers three simple built-in annotations
 *           6) @Deprecated, Annotation will warn when we use a Deprecated method or attribute,
 *              The annotation must be set just above the target method/attribute 
 *
 */

public class JavaAnnotationsDeprecated {

    // An old version of Adder
    @Deprecated
    public static int Adder(int number1, int number2 ) {
        
        int result;
        result = number1 + number2;
        return result;
    }

    // Newer and more efficient Version of Adder
    public static int newAdder(int number1, int number2 ) {

        return number1 + number2;
    }

    public static void main(String[] args) {
        
        // The Compiler will warn or the IDE will strikeOut this code
        // As we are using a deprecated method.
        // The Code runs though but its just that the compiler warns that
        // we are using a code version that is decommissioned.
        System.out.println(Adder(10,20));

        // The Compiler will Not warn for this code
        System.out.println(newAdder(10,20));
    }
}
