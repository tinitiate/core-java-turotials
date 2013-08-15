package JavaClassAndMethods;

/*==============================================*/
/* TINITIATE.COM                                */
/* --> T..O..P..I..C                            */ 
/*  Pass_ByValue_Pass_ByReference               */
/*==============================================*/

// This class samples the call by value
class PassByVal
{
	void ByVal(int TestVarByVal)
	{
		TestVarByVal=TestVarByVal*100;
	}
}

//This class samples the call by reference
class PassByRef
{
	// Variable with the same name as the main method call
	int TestVarByRef;
	
	// Constructor to which the main passes the value
	PassByRef(int v)
	{
		TestVarByRef=v;
	}

	void ByRef()
	{
		TestVarByRef=TestVarByRef*200;
	}
}

class  Pass_ByValue_Pass_ByReference
{
	public static void main(String args[]) 
	{
		
		// Call the class by Value
		int TestVarByVal=3;
		PassByVal oByVal = new PassByVal();
	    System.out.println("Value of TestVarByVal before call by Value: " + TestVarByVal);
	    oByVal.ByVal(TestVarByVal);
		System.out.println("Value of TestVarByVal afer call by Value: " + TestVarByVal);

		// Call the class by Reference, in the after using the object's TestVarRef
		int TestVarByRef=5;
		PassByRef oByRef = new PassByRef(TestVarByRef);
	    System.out.println("Value of TestVarByRef before call by Reference: " + TestVarByRef);
	    oByRef.ByRef();
		// Call the class by Reference, in the after using the object's TestVarRef
		System.out.println("Value of TestVarByRef afer call by Reference: " + 
				           /*Using the objects variable*/oByRef.TestVarByRef);
	}
}
