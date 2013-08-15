package JavaBasics;

public class JavaControlStatements
{
	/*==============================================*/
	/* TINITIATE.COM								*/
	/* --> T..O..P..I..C  							*/
	/*  CONTROL STATEMENTS							*/
	/*==============================================*/

	public static void main(String[] args)
	{
		int n1=10,n2=45;
		// Check if n1 and n2 are multiples of 5
		
		if (n1%5==n2%5)
		{
			System.out.println("n1 and n2 are multiples of 5!!");
		}
		else
		{
			System.out.println("n1 and n2 are NOT multiples of 5!!");
		}
		
		/*
		 * Using Boolean to test if..else
		 */
		boolean b=true;
		//boolean b=false;
		if (b)
		{  System.out.println("Boolean value b is set to: "+b); }
		else
		{ System.out.println("Boolean value b is set to: "+b); }
		// Try the code Un-commenting boolean b=false; and commenting boolean b=true;

		/*
		 * Nested if..else if..else if....else
		 */
		
		String f="Mango";
		if (f=="Apple" || f=="Mango" ||f=="Grape")
		{ System.out.println(f+" is a fruit"); }
		else if (f=="Onion" || f=="Spinach" ||f=="Potato")
		{ System.out.println(f+" is a vegetable"); }	
		else if (f=="Ice Cream" || f=="Chips" ||f=="Cake")
		{ System.out.println(f+" is processed food"); }	
		else
		{ System.out.println(f+" is something else"); }	

		/*
		 * Switch Statement alternative to nested if..else if...else
		 * Example 1
		 */
		//switch accepts byte, short, int, or char.
		int val=2;
		switch(val)
		{
			case 1:
				 System.out.println("Handle case1 here, Call a method or set a value");
				 break;
			case 2:
				System.out.println("Handle case2 here, Call a method or set a value");
				break;
			case 3:
				System.out.println("Handle case3 here, Call a method or set a value");
				break;
			default:
				System.out.println("Handle unknown-case here, Call a method or set a value");
		}

		/*
		 *  I T E R A T I V E 
		 *  Statements
		 *  Loops
		 *  While Loop
		 *  	Code Executes AFTER the condition in the while is checked 
		 */
		int whileloop_counter=5;
		while(whileloop_counter>0)
		{
			System.out.println("while Loop Counter Value: " + whileloop_counter);
			whileloop_counter--;
		}

		/*
		 *  I T E R A T I V E 
		 *  Statements
		 *  Loops
		 *  Do .. While Loop
		 *  	Code Executes BEFORE the condition in the while is checked
		 */
		int dowhileloop_counter=5;
		do
			{
				System.out.println("Do while loop_counter Value: " + dowhileloop_counter);
				dowhileloop_counter--;
			}while(dowhileloop_counter>0);
		
		/*
		 *  I T E R A T I V E 
		 *  Statements
		 *  Loops
		 *  For Loop
		 *  	For(initialization; condition; iteration) 
		 *		{ body }
		 *
		 */
		for(int for_loop_ctr=5; for_loop_ctr>0; for_loop_ctr--)
		{ System.out.println("for_loop_ctr: " + for_loop_ctr); }
		
		for(int for_loop_ctr2=1, upper_bound=4; for_loop_ctr2<upper_bound; for_loop_ctr2++) 
		{ System.out.println("for_loop_ctr2: " + for_loop_ctr2); }
		
		/*
		 *  Infinite for loop
		 *  for( ; ; )
		 *  { System.out.println("This is an infinite loop"); }
		 */

		/*
		 *  I T E R A T I V E 
		 *  Statements
		 *  Loops
		 *  For Loop with array
		 *
		 */
		int for_loop_ctr_array[] = { 1, 2, 3, 4, 5 };

		for(int for_loop_ctr3 : for_loop_ctr_array)
		{ System.out.println("for_loop_ctr3: " + for_loop_ctr3); }
		
		/*
		 *  I T E R A T I V E 
		 *  Statements Control
		 *		Exit loops in-between using:
		 *			break; 
		 * 
		 */
		for(int for_loop_ctr4=5; for_loop_ctr4>0; for_loop_ctr4--)
		{ System.out.println("for_loop_ctr: " + for_loop_ctr4);
		  break;  // This will not print FIVE times, will only print once !
		 }
	}
}
