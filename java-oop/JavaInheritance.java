package JavaOOP;

/** 
 * @author TINITIATE.COM
 * 
 * > TOPIC : Java OOP, Inheritance
 * 
 * > NOTES : 1) The class that is inherited (Parent) is superclass. 
 *           2) The class that does the inheriting (Child) is subclass.
 *           3) A subclass is specialized version of superclass. 
 *           4) Subclass inherits all the instance variables and methods 
 *              of the superclass and could have its own variables and methods.  
 *           5) SubClass cannot access PRIVATE members of SuperClass.
 *
 */
/**
 * @author TINITIATE.COM
 * 
 *         CLASS : SuperClass
 * 
 *         NOTES : 1) This class that is one that gets inherited (Parent) 2) The
 *         class that does the inheriting (Child) is subclass.
 * 
 */
// SuperClass / ParentClass
class SuperClass {
	int SuperVar1;

	/**
	 * Method : PrintSuperVar1 Notes : Used for Testing call to SuperClass /
	 * ParentClass
	 * 
	 * @param none
	 * @return void
	 * @exception none
	 * @throws none
	 */
	void PrintSuperVar1() {
		System.out.println("This is the SuperClass / Parent Class.");
		System.out.println("Value of SuperClass variable SuperVar1: "
				+ SuperVar1);
	}
}

/**
 * @author TINITIATE.COM
 * 
 *         CLASS : SubClass
 * 
 *         NOTES : 1) The class that does the inheriting (Child) is subclass.
 * 
 */
// SubClass / ChildClass, Inherits from SuperClass SuperClass by extending class
// A.
class SubClass extends SuperClass {
	int SubVar1;

	/**
	 * Method : PrintSubVar1 Notes : Used for Testing call to SubClass /
	 * ChildClass
	 * 
	 * @param none
	 * @return void
	 * @exception none
	 * @throws none
	 */
	void PrintSubVar1() {
		System.out.println("This is the SubClass / Child Class.");
		System.out.println("Value of SubClass variable SubVar1: " + SubVar1);
	}

	/**
	 * Method : PrintSuperVar1FromSubClass Notes : Call to the SuperClass from
	 * SubClass.
	 * 
	 * @param none
	 * @return void
	 * @exception none
	 * @throws none
	 */
	void PrintSuperVar1FromSubClass() {
		System.out.println("This is the SubClass / Child Class.");
		System.out
				.println("Printing from SubClass, Value of SuperClass variable SuperVar1: "
						+ SuperVar1);
	}
}

/**
 * @author TINITIATE.COM
 * 
 *         Class : JavaInheritance NOTES : Main Class of the Program
 * 
 */
public class JavaInheritance {
	public static void main(String[] args)
	{
		SuperClass SuperClassObj1 = new SuperClass();
		SubClass SubClassObj1 = new SubClass();
		/**
		 * Calling the SuperClass or the Parent Class
		 */
		System.out.println("Start Calling SuperClass Object");
		SuperClassObj1.SuperVar1 = 11;
		SuperClassObj1.PrintSuperVar1();
		System.out.println("End Calling SuperClass Object");
		System.out.println("");
		System.out.println("");
		System.out.println("Start Calling SubClass Object");
		SubClassObj1.SubVar1 = 99;
		SubClassObj1.PrintSubVar1();
		/**
		 * Accessing the SuperClass Variable from SubClass object
		 */
		SubClassObj1.SuperVar1 = 22;
		SubClassObj1.PrintSuperVar1FromSubClass();
		/**
		 * Accessing the SuperClass Method from SubClass object
		 */
		SubClassObj1.PrintSuperVar1();
		System.out.println("End Calling SubClass Object");
	}
}
