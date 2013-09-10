package JavaArrays;
/*==============================================*/
/* TINITIATE.COM
/* Venkata Bhattaram 
/*
/* --> T..O..P..I..C
/* More On Arrays
/*==============================================*/		


// Test Class
class Demo1
{
	int a;
}

// Class that has a method that returns an Array
class Demo2
{
	public int[] Return_array(int[] num_list)
	{
		// Declare and initialize array to the size of the input array in parameter
		int[] num_list_plus10 = new int [num_list.length];
		// Add 10 and return the input array "num_list"
		for (int ctr=0; ctr<num_list.length; ctr++)
		{
			num_list_plus10[ctr] =1 ;
			num_list_plus10[ctr] = num_list[ctr]+10;
		}
		return num_list_plus10;
	}
}

public class ArraysClass_Lesson1 
{
	public static void main(String[] args)
	{
		/* 
		 * USING DEMO1 Class
		 * DEMO1 Covers:
		 * 		 	1) Uninitialized Arrays
		 * 			2) Null Reference
		 * 			3) Declaration and Initialization
		 * 			4) Initialization 
		 * 			5) Length of the array
		 * 
		 */
		System.out.println("  ----  DEMO 1 Start  ----");
		// Creating an Array of Objects of Class Demo1

		// 1) Uninitialized Array	
		Demo1[] objArray_1;

  	    // 2) Null Reference
		Demo1[] objArray_2 = new Demo1[100];

		// 3) Declaration and Initialization
		Demo1[] objArray_3 = { new Demo1(), new Demo1(), new Demo1(), new Demo1(), new Demo1()};

		// 4) Initialization
		// NOTE: 1) objArray_1, Already declared but Uninitialized
		//       2) Array is declared as [] --> Square Brackets
		//	     3) Array elements are declared as () --> Curve Brackets  
		objArray_1 = new Demo1[] {new Demo1(), new Demo1(), new Demo1()};

		// 5) Length of the array
		// ".length" Printing the Length of the Array: objArray_1 
		System.out.println("objArray_1.length = " + objArray_1.length);

		// ".length" Printing the Length of the Array: objArray_1 
		System.out.println("objArray_2.length = " + objArray_2.length);

		// ".length" Printing the Length of the Array: objArray_1 
		System.out.println("objArray_3.length = " + objArray_3.length);
		
		
		System.out.println("  ----  DEMO 1 End  ----");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		/* ----  END OF DEMO1 ---- */
		
		/* 
		 * USING DEMO2 Class
		 * DEMO2 Covers:
		 * 		 	1) Returning an array
		 */
		System.out.println("  ----  DEMO 2 Start  ----");
		// Declare array to store returned array from Class: Demo2 Method: Return_array
		int[] l_int_array = {1,2,3};
		
		// Easy way to print arrays
		for(int n: l_int_array)
		{ System.out.println("Elements input to Class: Demo2 Method: Return_array are: " + n); }

		// Object to instantiate the class Demo2  
		Demo2 objArrayTest1 = new Demo2();

		// Passing the array l_int_array, and returning the result to the same array l_int_array 
		l_int_array = objArrayTest1.Return_array(l_int_array);
		
		for(int m: l_int_array)
		{ System.out.println("Elements output from Class: Demo2 Method: Return_array are: " + m); }
		System.out.println("  ----  DEMO 2 End  ----");
	}
}
