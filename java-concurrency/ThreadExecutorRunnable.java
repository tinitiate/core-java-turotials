package JavaConcurrency;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**
 * @author TINITIATE.COM
 *
 * @TOPIC :  JAVA Threads Executor Framework, With "Executors Class ThreadPool Methods"
 *           With Runnable Interface.
 *
 * @NOTES :  1) Java Provides a Thread Management framework,
 *           2) This FrameWork Provides Interfaces,
 *              2.1) Interface: Executor, Interface that supports launching new tasks.
 *                         Method:   void execute(Runnable Object)
 *              =======================================================================
 *              HERE WE ARE USING THE RUNNABLE OBJECT AND IMPLEMENTING THE RUN() METHOD
 *              =======================================================================
 *              2.2) Interface ExecutorService: Sub-Interface of Executor, 
 *                          to manage the life-cycle of individual and parent tasks.
 *              2.3) Interface ScheduledExecutorService: Sub-Interface of ExecutorService
 *                          supports periodic execution of tasks. 
 *                   **(No Example in this PROGRAM for ScheduledExecutorService)**
 *           3) The "Executors" Class Implements the ExecutorService Interface,
 *              Provides all the methods to accomplish the Thread Management
 *               3.1) All "TASKS" will be executed as Threads.
 *               3.2) Executors.newSingleThreadExecutor()
 *                     - Thread pool with only one thread. 
 *                     - All the submitted tasks will be executed sequentially as a Thread. 
 *               3.3) Executors.newFixedThreadPool()
 *                     - Thread pool with fixed number of threads.
 *                     - Tasks are executed with the Threads in the POOL, 
 *                     - If no Threads are idle then the "task" waits in a queue, 
 *                       Until a Threads frees up for usage.
 * @HOW_TO_READ_THIS_PROGRAM:
 *            1) In the ThreadExecutorRunnable Class there is a Task Method, Which prints a message
 *            2) The task method is called Once in the Single Thread
 *            3) The task method is called FOUR times in the ThreadPool.
 *            4) The thread pool runs the Task Method in parallel FOUR times.
 *               Check the Start and End time for each thread, they should be the same, Indicating 
 *               The threads ran in parallel not sequentially 
 */ 

/**
 * @CLASS ThreadExecutorFramework
 * @NOTES Provides the  
 */

public class ThreadExecutorRunnable implements Runnable {

    private String ThreadName; // ThreadName; Name of the thread
    private int ThreadSize;    // ThreadSize; The size of the return String from Threader Method

    /**
     * @METHOD Task
     * @param  ThreadName; Name of the thread
     * @param  ThreadLength; This creates a string using sequence of "-" to the TheardLength Specified
     * @Notes  1) This Method provides the Data and Functionality to test the Threads.
     *         2) It Prints the Start and End Time of Thread Execution.
     *         3) And the String Sequence of Character: "-", to the Specified TheardLength Parameter. 
     */
    public void Task(String ThreadName, int ThreadLength) {
        Date stime = new Date();
        System.out.println("Start Time: " + stime);

        String ThreadStr = "";
        int ctr = 0;
        // Append the String Sequence of Character: "-", to the Specified TheardLength Parameter.
        while (ctr <= ThreadLength) {
            ThreadStr = ThreadStr + "-";
            ctr++;
        }
        // All Print Statements, Start-End Times, and Thread details
        System.out.println("Thread Name : " + ThreadName);
        System.out.println("Thread Size : " + ThreadLength);
        System.out.println(ThreadStr);

        Date etime = new Date();
        System.out.println("End Time: " + etime);
        System.out.println("=================================");
    }

    // The Implementation of the Runnable
    public void run() {
        Task(ThreadName, ThreadSize);
    }

    // Constructor to accept the ThreadName and ThreadStringSize
    public ThreadExecutorRunnable(String ThreadName, int ThreadSize) {
        this.ThreadSize = ThreadSize;
        this.ThreadName = ThreadName;
    }

    // Main Method, Read from Here
    public static void main(String[] args) {

        // Create a Runnable Object of ThreadExecutorFramework Class, For Single Thread
        Runnable R1 = new ThreadExecutorRunnable("Thread1",20);

        // Create a Runnable Object of ThreadExecutorFramework Class, For ThreadPool
        Runnable PR1 = new ThreadExecutorRunnable("PoolThread1",10);
        Runnable PR2 = new ThreadExecutorRunnable("PoolThread2",20);
        Runnable PR3 = new ThreadExecutorRunnable("PoolThread3",30);
        Runnable PR4 = new ThreadExecutorRunnable("PoolThread4",40);

        /*====================================
         *  Creating A Single Thread Executor
         =====================================*/
        ExecutorService SingleThreadExecutor = Executors.newSingleThreadExecutor();

        // Calling the execute(Runnable Object), To execute the Task 
        SingleThreadExecutor.execute(R1);

        // ShutDown the Thread once done Using The Executor
        // Once the Application is done using the ExecutorService 
        // It must ShutDown, To prevent the threads for running for ever. 
        // The active threads inside this ExecutorService prevents the JVM from shutting down. 
        // Alternatively use shutdownNow(), to stop all threads and pooled tasks immediately 
        SingleThreadExecutor.shutdown();

        
        /*====================================
         *  Creating A Thread Pool Executor
         =====================================*/
        
        // Creates a ThreadPool of 2 Threads, that run, until the Shutdown() is called.
        // The Tasks are Submitted to the Executor Queue here using the submit() Method.
        // The Threads pickup tasks from the Queue and executed.
        // All Tasks executed / Picked are cleared from the Queue
        ExecutorService ThreadPoolExecutor = Executors.newFixedThreadPool(2);

        // Submit Tasks (Runnable Objects) to the Executor Queue
        // TWO threads in the POOL pick Tasks from the Queue and Executes each task.
        ThreadPoolExecutor.submit(PR1);
        ThreadPoolExecutor.submit(PR2);
        ThreadPoolExecutor.submit(PR3);
        ThreadPoolExecutor.submit(PR4);

        // ShutDown the Thread once done Using The Executor
        // Once the Application is done using the ExecutorService 
        // It must ShutDown, To prevent the threads for running for ever. 
        // The active threads inside this ExecutorService prevents the JVM from shutting down. 
        // Alternatively use shutdownNow(), to stop all threads and pooled tasks immediately 
        ThreadPoolExecutor.shutdown();
    }
}
