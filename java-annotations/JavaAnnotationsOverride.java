package javaannotations;

/**
 * @author TINITIATE.COM / Venkata Bhattaram
 *
 * @TOPIC :  JAVA Annotations Introduction and Basics 
 * 
 * @NOTES :  1) @Override, Annotation will warn when we use a Non existent method in Parent Class as 
 *              an suspecting to be an overRide method, with the Annotation ofcourse.
 */

// Create a ParentClass
class ParentClass {
    
    public final int ParentsMoney = 1000;
    
    public int getSomeMoney() {
        // Get 10% of parents money
        return (ParentsMoney*10/100);
    }
}

public class JavaAnnotationsOverride extends ParentClass{

    // OverRide method to get more Money
    // Use the @Override to validate the overRidden method 
    // with parameter signature and names 
    @Override
    public int getSomeMoney() {
        // Get 20% of parents money
        return (ParentsMoney*20/100);
    }

    // The below if unCommented will cause an error while compilation
    // as there is a @Override annotation and  there is no method with the name
    // getLittleMoney() in the parent class
    // *************************************************************************
    // @Override
    // public int getLittleMoney() {
    //     // Get 20% of parents money
    //     return ParentsMoney*(20/100);
    // }

    // The above block wil be valid if the @Override is not used
    
    // Main Method
    public static void main(String[] args) {

        JavaAnnotationsOverride obj = new JavaAnnotationsOverride();
        System.out.println(obj.getSomeMoney());
    }
}
