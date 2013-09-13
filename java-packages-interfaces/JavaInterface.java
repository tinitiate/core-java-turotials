package JavaPackagesAndInterfaces;
/** 
 * @author TINITIATE.COM
 *
 * > TOPIC : Java Interface
 *
 * > NOTES : 1) Interface is collection of abstract methods. Which means methods are declared without any body.
 *              The class that is implementing the interface will have the body of the method (Abstract methods concept).
 *           2) A class can implements an one or more interfaces, inheriting the abstract methods of the interface.
 *           3) Interfaces must be in a package,and the .CLASS file must be in the package directory.
 *           4) If a class implements ONLY SOME MEHTODS of an interface, then that class must be 
 *              declared as abstract class.
 *           5) Interface Properties:
 *              (a) Interfaces cannot be instantiated. 
 *              (b) Interfaces cannot have any constructors.
 *              (c) All interface methods are abstract.
 *              (d) All interface fields(Variables) are both static and final.
 *                  and will be used as constants in the implementing class.
 *              (e) Interfaces cannot not extended by a class, But they are implemented by class.
 *              (f) Interface can extend multiple interfaces, Using "extends" keyword 
 *                  and comma (,) for more than one interface.
 *                (i) Syntax: 
 *                    public interface ONEParentInterface
 *                    {
 *                        public void add();
 *                        public void subtract();
 *                    }
 *                    public interface TWOParentInterface
 *                    {
 *                        public void divide();
 *                        public void multiply();
 *                    }
 *                    public interface calcInterface extends ONEParentInterface, TWOParentInterface
 *                    {
 *                        public void calc();
 *                    }
 *                    The interface "calcInterface" will now inherit all the Methods from 
 *                    the interfaces ,ONEParentInterface and TWOParentInterface
 *                    
 */
public interface JavaInterface
{
    // interface methods
	public void food();
    public void drink();
    public void dressing();
    public void side();
    
    // interface fields(Variables)
    String SunRiseDirection = "EAST";
    String SunSetDirection  = "WEST";
    int waterBoilingPoint   = 100;
}
