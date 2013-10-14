package javaannotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author TINITIATE.COM / Venkata Bhattaram
 *
 * @TOPIC :  JAVA Annotations Introduction and Basics 
 * 
 * @NOTES : 1) Create an Annotation named TinitiateAnno, with three fields, Use Premitive data types 
 *          2)@Retention meta-annotation specifies how long an annotation type should be retained.
 *             Depending on the purpose of having the annotation
 *             whether to use with the compiler or to be reflected dynamically at runtime.
 *          3)RetentionPolicy.SOURCE
 *              The annotation will not be included in the class file.
 *              This is useful for annotations which are intended for the compiler only.
 *          4)RetentionPolicy.CLASS
 *              The annotation will be included in the class file, but cannot be read reflectively.
 *          5)RetentionPolicy.RUNTIME
 *              The annotation can be reflected at runtime.
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface TinitiateAnno {
    String  Description();
    int     version();
    String  date();
}
