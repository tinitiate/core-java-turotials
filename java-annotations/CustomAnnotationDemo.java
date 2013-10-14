package javaannotations;

import java.lang.reflect.Method;


// Added a Class level Annotation
@TinitiateAnno( Description = "This is a Class"
               ,date = "19-Mar-2013"
               ,version = 1)
public class CustomAnnotationDemo {

    // Added a Method level Annotation
    // Method using the Annotation: TinitiateAnno
    @TinitiateAnno( Description = "This is the Greatest Method Out there"
                   ,date = "19-Mar-2013"
                   ,version = 1)
    public static void theGreatestMethod() {
        System.out.println("This is the Greatest Method");
    }

    // Program Main
    public static void main(String[] args) {

        //  Call the Method
        theGreatestMethod();

        // Read the Class Annotation
        Class<CustomAnnotationDemo> MyClass = CustomAnnotationDemo.class;
        // Check if the expected annotation is present in the class
        if(MyClass.isAnnotationPresent(TinitiateAnno.class)) {
            TinitiateAnno taObj1 = (TinitiateAnno) MyClass.getAnnotation(TinitiateAnno.class);
            System.out.println("Method Description: " + taObj1.Description());
            System.out.println("Method Description: " + taObj1.version());
            System.out.println("Method Description: " + taObj1.date());
        }

        // Read the Class Annotation
        // Using Reflection create a Method object
        Method[] mObjs = MyClass.getMethods();
        // Loop through the array
        for (Method m : mObjs) {
            // System.out.println("Method Name " + m.getName());
            if(m.isAnnotationPresent(TinitiateAnno.class)) {
                TinitiateAnno taObj = m.getAnnotation(TinitiateAnno.class);
                System.out.println("Method Description: " + taObj.Description());
                System.out.println("Method Description: " + taObj.version());
                System.out.println("Method Description: " + taObj.date());
            }
        }
    }
}
