package JavaConcurrency;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.HashSet;

/**
 * @author TINITIATE.COM
 *
 * @TOPIC : JAVA Threads Executor Framework, With "Executors Class ThreadPool Methods"
 *          With Callable Interface.
 *
 * @NOTES : 1) When using Callable, Java Provides Interfaces,
 *              1.1) Callable Interface
 *                  - Pass the Tasks(Jobs to be run as Threads) to the executor service
 *              1.2) ExecutorService Interface
 *                  - This Executes the Threads., submit() returns a "Future Class" Object
 *                  - Its optional to use the Future Object Return 
 *              1.3) Future Interface
 *                  - This can be used to monitor and control the Thread
                 
 *              =======================================================================
 *              HERE WE ARE USING THE CALLABLE OBJECT AND IMPLEMENTING THE CALL() METHOD
 *              =======================================================================
 *           2) The "Executors" Class Implements the ExecutorService Interface,
 *              Provides all the methods to accomplish the Thread Management
 *               2.1) All "TASKS" will be executed as Threads.
 *               2.2) Executors.newFixedThreadPool()
 *                     - Thread pool with fixed number of threads.
 *                     - Tasks are executed with the Threads in the POOL.
 *                     - If no Threads are idle then the "task" waits in a queue, 
 *                       Until a Threads frees up for usage.
 *               2.3) Create a Collection of Callables.
 *               2.4) Add elements to the Collection
 *               2.5) Execute all the elements in the Collections using invokeAll(Callable<SET>)        
 *           3) The Callable's Method call() and invokeAny() / invokeAll() are similar to
 *              Runnable's run() and Thread's start(), But the call() and invokeAny() returns values.
 *              Which should be implemented by the calling Class.
 *           4) Make sure to import java.util.concurrent.Callable; package
 *
 *
 * @HOW_TO_READ_THIS_PROGRAM:
 *            1) In the ThreadExecutorRunnable Class there is a Task Method, Which prints a message
 *            2) The task method is called Once in the Object for Single Thread "Executors.newSingleThreadExecutor()".
 *            3) The task method is called FOUR times in the ThreadPool Object "Executors.newFixedThreadPool(2);"
 *            4) The thread pool runs the Task Method in parallel TWO times.
 *               Check the Start and End time for each thread, they should be the same, Indicating 
 *               The threads ran in parallel not sequentially 
 *
 */ 

/**
 * @CLASS ThreadExecutorFramework
 * @NOTES Provides the  
 */

public class ThreadCallableCollection implements Callable {

    private String ThreadName; // ThreadName; Name of the thread

    /**
     * @METHOD Task
     * @param  ThreadName; Name of the thread
     * @param  ThreadLength; This creates a string using sequence of "-" to the TheardLength Specified
     * @Notes  1) This Method provides the Data and Functionality to test the Threads.
     *         2) It Prints the Start and End Time of Thread Execution.
     *         3) And the String Sequence of Character: "-", to the Specified TheardLength Parameter. 
     */
    public void Tasks(String ThreadName) throws InterruptedException {
        // All Print Statements, Start-End Times, and Thread details
        Date stime = new Date();
        System.out.println("Message From: Thread Name [" + ThreadName + "] Start Time: " + stime);
        Thread.sleep(5000);
        System.out.println("Message From: Thread Name [" + ThreadName + "] THE TASK Sleeps for 5 Seconds! (Check Start / End Time)");
        Date etime = new Date();
        System.out.println("Message From: Thread Name [" + ThreadName + "] End Time: " + etime);
    }

    // The Implementation of the Callable's  Call() method
    public String call() {
        try {
            Tasks(ThreadName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Result";
    }

    // Constructor to accept the ThreadName and ThreadStringSize
    public ThreadCallableCollection(String ThreadName) {
        this.ThreadName = ThreadName;
    }

    // Main Method, Read from Here
    public static void main(String[] args) {

        /**====================================
         *  Creating A Thread Pool Executor
         =====================================*/
        
        // Creates a ThreadPool of 2 Threads, that run, until the Shutdown() is called.
        // The Tasks are Submitted to the Executor Queue here using the submit() Method.
        // The Threads pickup tasks from the Queue and executed.
        // All Tasks executed / Picked are cleared from the Queue
        ExecutorService ThreadPoolExecutor = Executors.newFixedThreadPool(2);

        /**-----------------------------------------
         *  Create a COLLECTION of Callable Objects
         *-----------------------------------------*/
        // Create a Collection of Callable Objects
        Set<Callable<ThreadCallableCollection>> CallAbleObjects = new HashSet<Callable<ThreadCallableCollection>>();

        // Add Three Objects of the Class ThreadCallableCollection
        CallAbleObjects.add(new ThreadCallableCollection("PoolThread1"));
        CallAbleObjects.add(new ThreadCallableCollection("PoolThread2"));
        CallAbleObjects.add(new ThreadCallableCollection("PoolThread3"));

        // The invokeAll() will invoke all the Callable Objects 
        try {
            ThreadPoolExecutor.invokeAll(CallAbleObjects);

        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        /**--------------------------------------------
         * Code to access the Future Objects for 
         * individual Threads
         **--------------------------------------------*/
        //Iterator itr = CallAbleObjects.iterator();
        //while(itr.hasNext())
        //{
        //    Future FO = ThreadPoolExecutor.submit(itr.next());
        // }

        
        // ShutDown the Thread once done Using The Executor
        // Once the Application is done using the ExecutorService 
        // It must ShutDown, To prevent the threads for running for ever. 
        // The active threads inside this ExecutorService prevents the JVM from shutting down. 
        // Alternatively use shutdownNow(), to stop all threads and pooled tasks immediately 
        ThreadPoolExecutor.shutdown();
        
        // Method: awaitTermination(), is Similar to JOIN() methods when using Thread Class
        try {
            ThreadPoolExecutor.awaitTermination(9999,TimeUnit.SECONDS); // Use import java.util.concurrent.TimeUnit; for enum values" 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final Message Print after all threads complete execution");
    }
}
