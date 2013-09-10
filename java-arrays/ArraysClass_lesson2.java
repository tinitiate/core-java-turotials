package JavaArrays;

import java.util.*;

/** 
 * @author TINITIATE.COM
 *         Venkata Bhattaram 
 * 
 * TOPIC   : More On Arrays
 * 
 * CLASS   : ArraysClass_lesson2 [Requires the Package "java.util"]
 * PURPOSE : 1) Cloning an Array
 *           2) Copying an Array
 *           3) Comparing an Array
 *           4) Sorting an Array
 */

public class ArraysClass_lesson2
{

	/**
	 * METHOD  : cloneArray
	 * PURPOSE : 1) Demonstrates the implementation 
	 * 				cloning array using built-in constructs.
	 *   
	 * @param  : Array of Integers to clone
	 * @return : Cloned output array of input Integer array
	 */
	public int[] cloneArray(int[] inArray)
	{
		int[] outArray = new int[inArray.length];
		outArray = inArray.clone();
		
		return outArray;
	}
	
	/**
	 * METHOD  : ArrayCopy
	 * PURPOSE : 1) Demonstrates the implementation 
	 * 				Copying a subset of an array using built-in constructs.
	 *   
	 * @param  : Array of Integers to copy a subset into the return array
	 * @return : Subset of input array
	 */
	
	public int[] ArrayCopy(int[] inCpArray)
	{
		int[] outCpArray = new int[3];
        /**
         * USAGE:
         * System.arraycopy 
         *                ( SourceArrayName
         *                , [Index Start position of Source Array] // Copy FROM here in Source
         *                , TargetArrayName
         *                , [Index Start position of Target Array to copy to] //Copy to here in Target
         *                , [Index End position of Source Array]   // Copy TO here in Source
         *                
         */
		System.arraycopy(inCpArray, 3, outCpArray, 0, 3);
		return outCpArray;
	}

	/**
	 * METHOD  : main
	 * PURPOSE : Creates objects Calls the methods. 
	 *   
	 * @param
	 */
	
	public static void main(String[] args)
	{
		/**
		 *  Calling the method to clone an array using built-in constructs
		 */
		System.out.println("!! Cloning an Array !!");
		ArraysClass_lesson2 obj1 = new ArraysClass_lesson2();
		int [] myAry = {1,2,3};
		int [] cloneOF_myAry = {0, 0, 0};

		for(int m: cloneOF_myAry)
		{ System.out.println("Before Elements cloneOF_myAry: " + m); }

		System.out.println("");

		cloneOF_myAry=obj1.cloneArray(myAry);
		// Printing contents of cloneOF_myAry
		for(int m: cloneOF_myAry)
		{ System.out.println("After Elements cloneOF_myAry: " + m); }

		/**
		 *  Calling the method to copy an set of array elements 
		 *  into another array using built-in constructs
		 */
		System.out.println("");
		System.out.println("!! Copying a subset [start from index 3 for increment of 3 indexes] of an array !!");

		int [] myAryIn = {1,2,3,10,20,30,4,5};
		int [] myAryOut = new int[3];
		myAryOut = obj1.ArrayCopy(myAryIn);

		System.out.print("Elements of myAryIn: ");
		for(int p: myAryIn)
		{ System.out.print(p + ","); }
		System.out.println("");
		// Printing contents of cloneOF_myAry
		for(int k: myAryOut)
		{ System.out.println("After Elements myAryOut: " + k); }


		/**
		 *  Calling the method to compare two input int arrays 
		 *  using built-in constructs
		 */
		System.out.println("");
		System.out.println("!! Compare Input arrays !!");		

		int [] test1 = new int[4];
		Arrays.fill(test1, 10);  // Arrays.fill method fills array test1 with 10, 10, 10, 10

		int [] test2 = new int[4];
		Arrays.fill(test2, 10);  // Arrays.fill method fills array test2 with 10, 10, 10, 10

		int [] test3 = new int[4];
		Arrays.fill(test2, 11);  // Arrays.fill method fills array test3 with 11, 11, 11, 11

		if (Arrays.equals(test1,test2))
		{ System.out.println("Arrays test1 and test2 are equal."); }
		else
		{System.out.println("Arrays test1 and test2 are not equal."); }	

		if (Arrays.equals(test1,test3))
		{ System.out.println("Arrays test1 and test3 are equal."); }
		else
		{System.out.println("Arrays test1 and test3 are not equal."); }	

		/**
		 *  Calling the method to sort array elements 
		 *  using built-in constructs
		 */
		System.out.println("");
		System.out.println("!! Sort Input array !!");		

		int [] x1 = {92, 1, 55, 100};
		
		System.out.print("X1 before sort: ");
		for (int a: x1)
		{ System.out.print(a + " "); }
		
		System.out.println("");
		
		System.out.print("X1 after sort: ");
		// Built-in to sort Array
		Arrays.sort(x1);  
		for (int b: x1)
		{ System.out.print(b + " "); }

	}
}
