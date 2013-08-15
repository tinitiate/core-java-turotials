package JavaBasics;

public class JavaOperators
{
	public static void main(String args[])
	{
		/*==============================================*/
		/* TINITIATE.COM								*/
		/* --> T..O..P..I..C  							*/
		/* Operators Basics 							*/
		/*==============================================*/	

		int num1=10,num2=5,res1;
		System.out.println("Basic Arithmetic Operators");
		// Addition
		res1=num1+num2;
		System.out.println(num1 + "+" + num2 +" = "+ res1);
		// Subtraction
		res1=num1-num2;
		System.out.println(num1 + "-" + num2 +" = "+ res1);
		// Multiplication
		res1=num1*num2;
		System.out.println(num1 + "*" + num2 +" = "+ res1);
		// Division (Gets quotient)
		res1=num1/num2;
		System.out.println(num1 + "/" + num2 +" = "+ res1);
		// Modulus (Gets reminder)
		res1=num1%num2;
		System.out.println(num1 + "%" + num2 +" = "+ res1);

		/*==============================================*/
		/* TINITIATE.COM								*/
		/* --> T..O..P..I..C  							*/
		/* Special Operators 							*/
		/*==============================================*/			
		
		//For reference: int num1=10,num2=5,num3=2,res1;  --> Already declared above
		res1=0;
		
		res1=res1+1;
		System.out.println("Value of res1: "+ res1);
		// This is same as res1=res1+1;
		res1+=res1;
		System.out.println("Value of res1: "+ res1);
		// This is same as res1=res1+1;
		res1++;
		System.out.println("Value of res1: "+ res1);

		res1=res1-1;
		System.out.println("Value of res1: "+ res1);
		// This is same as res1=res1-1;
		res1--;
		System.out.println("Value of res1: "+ res1);

		
		res1=num1*10;
		System.out.println("Value of res1: "+ res1);
		// This is same as above
		res1*=num1;
		System.out.println("Value of res1: "+ res1);
		
		res1=0;
		res1=++num1;
		System.out.println("Value of res1: "+ res1);
		++res1;
		System.out.println("Value of res1: "+ res1);
		--res1;
		System.out.println("Value of res1: "+ res1);
		
		/*==============================================*/
		/* TINITIATE.COM								*/
		/* --> T..O..P..I..C  							*/
		/* Relational / Logical Operators 				*/
		/*==============================================*/
		
		boolean Relational_Operators_tester;
		int n1=1,n2=1,n3=3;

		//	== Equal to
		//	!= Not equal to
		//	>= Not equal to
		//	> Greater than
		//	< Less than
		//	>= Greater than or equal to
		//	<= Less than or equal to

		//	== Equal to
		Relational_Operators_tester=n1==n2;
		System.out.println("Statement n1==n2 is " + Relational_Operators_tester);

		//	!= Not equal to
		Relational_Operators_tester=n1!=n2;
		System.out.println("Statement n1!=n2 is " + Relational_Operators_tester);

		//	>= Not equal to
		Relational_Operators_tester=n1>=n3;
		System.out.println("Statement n1>=n3 is " + Relational_Operators_tester);

		// 	& Logical AND
		//	| Logical OR
		//	^ Logical XOR (exclusive OR)
		//	! Logical unary NOT
		
		/*
			true|false = true
			true&false = false
			true^false = true
			true&false|a&!b = true
			!true = false
		*/

		// 	& Logical AND
		boolean value_true=true, value_false=false;
		Relational_Operators_tester=value_true&value_false;
		System.out.println("Statement true & false is " + Relational_Operators_tester);

		/*	|| Short-circuit OR
			&& Short-circuit AND

			--> The boolean outcome can be determined by the left operand and if that is true only then 
				Java will bother to evaluate the right-hand operand. 
			 -->	Use this when right-hand operand is derived from the value of the 
				left-hand operands result. 
		*/

		int x=5;
		if(x==5 && ((x+10)%5)==0)
		{
			System.out.println("Left-hand expression is true");
		}

		x=4;
		// In the below condition there is no need to evaluate the expression (x+10)%5==0
		// as the Left hand side failed and its an AND operation.
		if(x==5 && ((x+10)%5==0))
		{
			// This will never be printed
			System.out.println(" This will never be printed");
		}

		//	?: Ternary if-then-else
		/* 
		 * expression1 ? expression2 : expression3
		 * 
		 * expression1 SHOULD return a boolean value
		 * if TRUE THEN expression2 is evaluated;
		 * if FALSE THEN, expression3 is evaluated.
		 * 
		*/

		String print_statement = 10%2 == 0 ? "print_statement is True" : "print_statement is False";
		System.out.println(print_statement);

		int LeastValue,fn1=10,fn2=3; 
		if (fn1 < fn2)
		{ 
			LeastValue = fn2; 
		} 
		else 
		{ 
			LeastValue = fn1; 
		} 
		System.out.println("Lower value is "+LeastValue);
		
		//converting the above to ?: Ternary if-then-else
		LeastValue = fn1 < fn2 ? fn2 : fn1; 
		System.out.println("Using Ternary Lower value is "+LeastValue);
	}
}
