package JavaArrays;

/** 
 * @author TINITIATE.COM
 *         Venkata Bhattaram
 * 
 * TOPIC   : More On Arrays
 * 
 * CLASS   : ArraysClass_lesson3  [Requires the Package "java.util"]
 * PURPOSE : 1) Creating Arrays with various Native types. Native Types explained
 * 
 */

public class ArraysClass_lesson3
{

	/**
	 * METHOD  : ArraysOfTypes
	 * PURPOSE : 1) Demonstrates the implementation 
	 * 				Array using various native Types.
	 *   
	 * @param  : NONE
	 * @return : NONE
	 */
	public void ArraysOfTypes()
	{
		/**
		 * boolean: The boolean data type has only two possible values: true and false. 
		 * 			Use this data type for simple flags that use true/false conditions.
		 * 			This data type represents one bit of information.
		 */
		boolean[] array1 = new boolean[3];
		array1[0] = true;
		array1[1] = false;
		array1[2] = true;
		System.out.print("Data in boolean array, 'array1' is: ");
		for(boolean a: array1)
		{ System.out.print(a + " "); }
		System.out.println("");

		/**
		 * byte: The byte data type is an 8-bit signed two's complement integer.
		 * 		 Minimum value of -128 
		 * 	     Maximum value of 127 (inclusive). 
		 * 		 The byte data type can be useful for saving memory in large arrays, 
		 *       where the memory savings actually matters. 
		 *       They can also be used in place of int where their limits help to clarify your code; 
		 *       the fact that a variable's range is limited can serve as a form of documentation.
		 *      
		 */
		byte[] array2 = new byte[3];
		array2[0] = 12;
		array2[1] = 23;
		array2[2] = 34;
		System.out.print("Data in byte array, 'array2' is: ");
		for(byte b: array2)
		{ System.out.print(b + " "); }
		System.out.println("");

		/**
		 * char: The char data type is a single 16-bit Unicode character.
		 * 		 minimum value of '\u0000' (or 0) 
		 * 		 maximum value of '\uffff' (or 65,535 inclusive).
		 */
		char[] array3 = {'A', 'B', 'C'};
		System.out.print("Data in char array, 'array3' is: ");
		for(char c: array3)
		{ System.out.print(c + " "); }
		System.out.println("");
		
		/**
		 * short: The short data type is a 16-bit signed two's complement integer. 
		 * 		  Minimum value of -32,768 
		 * 		  Maximum value of 32,767 (inclusive).
		 * 		  As with byte, the same guidelines apply: you can use a short to save memory in large arrays,
		 *        in situations where the memory savings actually matters. 
		 */
		short[] array4 = {-32,768, 232, 32,768};
		System.out.print("Data in short array, 'array4' is: ");
		for(short d: array4)
		{ System.out.print(d + " "); }
		System.out.println("");

		/**
		 * int: The int data type is a 32-bit signed two's complement integer. 
		 * 		Minimum value of -2,147,483,648 
		 *      Maximum value of 2,147,483,647 (inclusive). 
		 *      For integral values, this data type
		 *      This data type will most likely be large enough for the numbers your program will use,
		 *      but if you need a wider range of values, use long instead.
		 */
		int[]     array5 = {99, 98, 97};
		System.out.print("Data in int array, 'array5' is: ");
		for(int e: array5)
		{ System.out.print(e + " "); }
		System.out.println("");

		/**
		 * long: The long data type is a 64-bit signed two's complement integer. 
		 * 		 minimum value of -9,223,372,036,854,775,808 and 
		 *       maximum value of 9,223,372,036,854,775,807 (inclusive).
		 *       Use this data type when you need a range of values wider than those provided by int.
		 */
		long[]  array6 = {Long.MAX_VALUE, Long.MIN_VALUE}; // Built-in Static classes
		System.out.print("Data in long array, 'array6' is: ");
		for(long f: array6)
		{ System.out.print(f + " "); }
		System.out.println("");

		/**
		 * float: The float data type is a single-precision 32-bit IEEE 754 floating point. 
		 * 		  use a float (instead of double) if you need to save memory in large arrays 
		 * 	      of floating point numbers. 
		 *        This data type should never be used for precise values, such as currency.
		 *        For that, you will need to use the java.math.BigDecimal class instead.
		 */

		System.out.print("Data in float array, 'array7' is: ");
		for(float g: array6)
		{ System.out.print(g + " "); }
		System.out.println("");

		/**
		 * double: The double data type is a double-precision 64-bit IEEE 754 floating point.
		 * 		   This data type should never be used for precise values, such as currency.
		 */
		double[]  array8 = {Double.MAX_VALUE, Double.MIN_VALUE};
		System.out.print("Data in double array, 'array8' is: ");
		for(double h: array8)
		{ System.out.print(h + " "); }
		System.out.println("");

	}


	/**
	 * METHOD  : main
	 * PURPOSE : Creates objects Calls the methods. 
	 *   
	 * @param
	 */
	public static void main(String[] args) {
		// Create an Object to call the class
		ArraysClass_lesson3 obj1 = new ArraysClass_lesson3();
		obj1.ArraysOfTypes();
	}
}
