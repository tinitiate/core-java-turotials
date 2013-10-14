package javaannotations;

/**
 * @author TINITIATE.COM / Venkata Bhattaram
 *
 * @TOPIC :  JAVA Annotations Introduction and Basics 
 * 
 * @NOTES :  1) @Suppresswarnings, Annotation will tell the compiler 
 *              to NOT raise warnings for the specified scenarios
 *           2) @Suppresswarnings, Annotation is compiler specific
 *           3) Some of the Annotations mentioned for Eclipse / JDK 6   
*/
public class JavaAnnotationsSupressWarnings {

    public static void main(String[] args) {

        // This will show an unused Warning
        int a1 = 1;

        @SuppressWarnings("unused")
        // This will NOT show an UNUSED Warning
        // As the @SuppressWarnings("unused") Annotation is used
        int a2 = 1;
    }
}

/**        Search for Eclipse's SupressWarnings Annotations, Some of them mentioned below
*           boxing autoboxing conversion 
*           charConcat when a char array is used in a string concatenation without being converted explicitly to a string 
*           conditionAssign possible accidental boolean assignment 
*           constructorName method with constructor name 
*           emptyBlock undocumented empty block 
*           enumSwitch, incomplete-switch incomplete enum switch 
*           fieldHiding field hiding another variable 
*           finalBound type parameter with final bound 
*           finally finally block not completing normally 
*           forbidden use of types matching a forbidden access rule 
*           javadoc invalid javadoc 
*           null potential missing or redundant null check 
*           nullDereference missing null check 
*           over-ann missing @Override annotation 
*           unchecked unchecked type operation 
*           warningToken unhandled warning token in @SuppressWarnings
*           ....... 
*
*        JDK (1.6)
*           deprecation Check for use of depreciated items.
*           unchecked Give more detail for unchecked conversion warnings that are mandated by the Java Language Specification.
*           serial Warn about missing serialVersionUID definitions on serializable classes.
*           finally Warn about finally clauses that cannot complete normally.
*           fallthrough Check switch blocks for fall-through cases and provide a warning message for any that are found.
*           path Check for a nonexistent path in environment paths (such as classpath).
*
*/
