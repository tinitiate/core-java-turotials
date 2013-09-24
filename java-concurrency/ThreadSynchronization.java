package JavaConcurrency;

/**
 * @author TINITIATE.COM
 *
 *  > TOPIC : JAVA Threads Synchronization
 *
 *  > NOTES : 1) Java Threads provides functionality to run several threads to carry out completely 
 *               independent tasks. And run several threads to run the same task.
 *            2) Running several threads to run the same task requires the 
 *               threads to interact with each other by sharing resources.
 *            3) Improper handling of the resource sharing ("NOT THREAD SAFE"), might lead to 
 *               data corruption, by data its the objects member fields / variables. 
 *            4) Synchronization is the process to provide effective and "THREAD SAFE" 
 *               communication amongst threads by sharing access to fields and objects references.
 *            5) Synchronization provides a thread to get exclusive access to a shared resource.
 *            6) Synchronization provides mutual exclusion on resource usage.
 *    HOW TO UNDERSTAND THIS PROGRAM
 *            1) The Classes NotThreadSafe and ThreadSafe, Provide data for test.
 *            2) Class NotThreadSafe, has counter that will be incremented by a method
 *               when a SAME Object of NotThreadSafe class is called by THREE different threads
 *               Meaning the Object is shared by three different threads, there might not be 
 *               a consistent return of the "counter". Dont expect 1,2,3 for counter values,
 *               it could be any order or any combination.
 *            3) Class ThreadSafe, has counter that will be incremented by a method, which is 
 *               synchronized when a SAME Object of ThreadSafe class is called by THREE 
 *               different threads, Meaning the Object is shared by three different threads,
 *               It is guaranteed to consistently return of the "counter". Expect 1,2,3 
 *               for counter values.
 *            4) The Class ThreadSynchronization creates the threads for two objects,
 *               Three threads each.
 *            5) Do multiple runs of this program and you will find the NotThreadSafe output to be
 *               order in some runs. 
 *            
 */

/**
 *  This is a Class that has a counter method,
 *  and if we call the nextValue method of an object of this class,
 *  in threads, Each of the thread might overwrite other thread's "counter++" value
 */
class NotThreadSafe {
    // Counter variable
    int counter = 0;
    // Method to increment the value
    public void nextValue()  throws InterruptedException {
        counter++;
        System.out.println("NotThreadSafe NextValue: " + counter);
    }
}

/**
 *  This is a Class that has a counter method,
 *  and if we call the nextValue method of an object of this class,
 *  in threads, Each of the thread will NEVER overwrite others "counter++" value
 *  as we are using the "synchronized" Keyword when calling the method
 */
class ThreadSafe {
    // Counter variable
    int counter = 0;
    // Method to increment the value 
    synchronized public void nextValue()  throws InterruptedException {
        counter++;
        System.out.println("ThreadSafe NextValue: " + counter);
    }
}
public class ThreadSynchronization extends Thread {

    // Variable to choose which class to call in the constructor
    String runWhichObject;

    NotThreadSafe objNTS;
    ThreadSafe    objTS;

    // All threads Working with the SAME object. 
    public ThreadSynchronization(NotThreadSafe objNTS) {
        // this is current object of class.
        this.objNTS = objNTS;
    }

    // All threads Working with the SAME object.
    public ThreadSynchronization(ThreadSafe objTS) {
        // this is current object of class.
        this.objTS = objTS;
    }

    // The implementation fo the Run method
    public void run() {
        try {
            if ( runWhichObject == "NotThreadSafe")
                objNTS.nextValue();

            if ( runWhichObject == "ThreadSafe")
                objTS.nextValue();
        }
        catch(Exception e) { e.printStackTrace(); }

    }
    public static void main (String[] args) throws InterruptedException {    

        try {
            // Here we will call the nextValue of the counter 
            // program THRICE the You would expect the results to be are are
            // NotThreadSafe NextValue: 1
            // NotThreadSafe NextValue: 2
            // NotThreadSafe NextValue: 3
            // But It could be in any combination.    
            // This shows that same object objectNTS, run in three threads
            // is not thread safe
            // Creating THREE threads and Running them
            NotThreadSafe objectNTS = new NotThreadSafe();
            ThreadSynchronization NT1 = new ThreadSynchronization(objectNTS);
            NT1.runWhichObject = "NotThreadSafe";
            NT1.start();

            ThreadSynchronization NT2 = new ThreadSynchronization(objectNTS);
            NT2.runWhichObject = "NotThreadSafe";
            NT2.start();

            ThreadSynchronization NT3 = new ThreadSynchronization(objectNTS);
            NT3.runWhichObject = "NotThreadSafe";
            NT3.start();

            // Here we will call the nextValue of the counter 
            // program THRICE the expected results are
            // ThreadSafe NextValue: 1
            // ThreadSafe NextValue: 2
            // ThreadSafe NextValue: 3

            // Using synchronized in the nextValue method in the ThreadSafe Class
            // Guarantees the results to be in the expected order.
            ThreadSafe objectTS = new ThreadSafe();
            ThreadSynchronization T1 = new ThreadSynchronization(objectTS);
            T1.runWhichObject = "ThreadSafe";
            T1.start();

            ThreadSynchronization T2 = new ThreadSynchronization(objectTS);
            T2.runWhichObject = "ThreadSafe";
            T2.start();

            ThreadSynchronization T3 = new ThreadSynchronization(objectTS);
            T3.runWhichObject = "ThreadSafe";
            T3.start();
        }
        catch(Exception e) { e.printStackTrace(); }
    }
}
