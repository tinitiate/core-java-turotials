package javamisc;

/**
 * Final Variable is whose value remains same through out the instance of a class
 * Final variable cannot be modified, Once assigned a value for a given instance.
 * Final methods cannot be overridden.
 * Final class cannot be inherited. 
 * Final variables that are declared and not initialized are called as blank final variables.
 * Blank final variables require constructors to initialize it.
 * Once initialized the Final variable's value wont change, 
 * Its like a constant value for every instance.
 *****
 * Static Variable is whose value remains same through out the ALL the Instances of a class.
 * But any instance can change its value
 * Static variables are marked final.
 * Static method cannot be instantiated.
 * Static method cannot be overloaded or overridden.
 **/

public class javaStaticFinalAttributes {

    static int staticInt;
    final int finalInt;
    // Create and assign once for all instances of the class
    // Using as GLOBAL constant.
    static final int StaticFinalInt = 20;

    // Constructor to Initialize the "final attribute"
    public javaStaticFinalAttributes(int finalInt) {
        this.finalInt       = finalInt;
    }

    public static void main(String[] args) {

        // Create Object and assign a value to 
        // the Final Attribute using Constructor
        javaStaticFinalAttributes jsfObj1 = new javaStaticFinalAttributes(1);

        // Assign a Static Value for OBJECT: jsfObj1 
        jsfObj1.staticInt       = 10;

        // Print Final and Static attributes
        System.out.println(jsfObj1.finalInt);
        System.out.println(jsfObj1.staticInt);
        System.out.println(jsfObj1.StaticFinalInt);

        // Create Object and assign a value to 
        // the Final Attribute using Constructor
        javaStaticFinalAttributes jsfObj2 = new javaStaticFinalAttributes(2);
        // NOTE We DO NOT Set the STATIC of the OBJECT: jsfObj2 

        // Print Final and Static attributes
        System.out.println(jsfObj2.finalInt);
        System.out.println(jsfObj2.staticInt);
        System.out.println(jsfObj2.StaticFinalInt);
    }
}
