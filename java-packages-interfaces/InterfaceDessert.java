package JavaPackagesAndInterfaces;
/** 
 * @author TINITIATE.COM
 *
 * > TOPIC : Java Extend Interface
 *
 * > NOTES : 1)Interface can extend multiple interfaces, Using "extends" keyword 
 *             and comma (,) for more than one interface.
 *             (i) Syntax: 
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
// This interface will inherit all the methods from the interface "JavaInterface"
public interface InterfaceDessert extends JavaInterface
{
    public void dessert();
}
