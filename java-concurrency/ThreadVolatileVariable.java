package JavaConcurrency;

/**
 * @author TINITIATE.COM
 *
 * > TOPIC : JAVA Volatile Variables
 * 
 * > NOTES : 1) Volatile indicates that the variable's value will be modified by different threads.
 *           2) Values of volatile variables will never be cached thread-cache
 *           3) They are  all reads and writes will go straight to "main memory"; 
 *           4) Volatile variables behaves like a synchronized block.
 *           5) Static Vs Volatile variables:
 *              Static: Only one copy of the variable.
 *                      No matter what different threads do to the variable,
 *                      there is only ONE version in the memory.
 *              Volatile: All threads have their own copy of the variable, with value derived 
 *                        from the main memory. Same value across all threads.
 *
 */

// This class provides the data that is needed for example
class VolatileThreadSafe {

    // Counter volatile variable
    volatile int counter = 0;
    // Method to increment the value

    public void addFiveToCounter()  throws InterruptedException {
        // Adding 5 to the counter 
        counter=+5;
        System.out.println("ThreadSafe addFiveToCounter: " + counter);
    }
}

public class ThreadVolatileVariable extends Thread {
    
    VolatileThreadSafe CommonVolTest;
    // Constructor, to use the Common object "CommonvolTest" across all 
    // the threads, with this.CommonvolTest, rather than each thread using a new 
    // instance of the object CommonvolTest
    // Constructor
    public ThreadVolatileVariable(VolatileThreadSafe volTest) {
        this.CommonVolTest = volTest;
    }

    public void run () {
        try {
            CommonVolTest.addFiveToCounter();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Main method, execution starts here  
    public static void main (String[] args) throws InterruptedException  {

        System.out.println("Volatile Variable test");
             
        try {
            VolatileThreadSafe CommonObjectVTS = new VolatileThreadSafe();
            ThreadVolatileVariable T1 = new ThreadVolatileVariable(CommonObjectVTS);
            ThreadVolatileVariable T2 = new ThreadVolatileVariable(CommonObjectVTS);
            ThreadVolatileVariable T3 = new ThreadVolatileVariable(CommonObjectVTS);

            T1.start();
            T2.start();
            T3.start();
        }
        catch (Exception e) {
            e.printStackTrace();
        }    
    }
}
