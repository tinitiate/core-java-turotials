package JavaOOP;
/** 
 * @author TINITIATE.COM
 * 
 * > TOPIC : Java OOP, Inheritance, using Super Keyword
 * 
 * > NOTES : 1) The class that is inherited (Parent) is superclass. 
 *           2) The class that does the inheriting (Child) is subclass.
 *           3) "super" Keyword Operates in TWO modes,
 *              (3.a) Calls the superclass’ constructor. 
 *              (3.b) Can be used to access hidden by a member of the superclass in subclass.
 *
 */
class SuperClass1
{
	int i;
    int k;
    // Constructor to handle a given value
    SuperClass1(int j)
    {
    	i=j;
    }

	public void PrintNextThreeNumbers()
	{
		System.out.println("Super Class says: Printing The next three numbers after "+ i);
		System.out.println((i+1) + " " + (i+2) + " " + (i+3));
	}
	
	public void i_EQUALS_TO_k()
	{
		i = k;
	}
}

class SubClass1 extends SuperClass1
{
	int p;
    SubClass1()
    {
  	    // Using super keyword to populate default 2 as the value of "i" in super class
    	super(2);
    	System.out.println("SubClass says: Calling the SuperClass's constructor using super().");
    }
    // This method is a method of SubClass
    public void i_EQUALS_TO_k()
    {
    	p = super.k;
    }

    public void superAccessHiddenMember(int x)
    {
    	super.k = x;
    	super.i_EQUALS_TO_k();   // Use super to call method of SuperClass
    	super.PrintNextThreeNumbers();
    }
}
public class JavaInheritanceSuper 
{
	public static void main(String[] args) 
	{
        SubClass1 subObj = new SubClass1();
        subObj.PrintNextThreeNumbers();
        subObj.i = 10;
        subObj.PrintNextThreeNumbers();
        subObj.superAccessHiddenMember(100);
	}    
}
