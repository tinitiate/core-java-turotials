package JavaConcurrency;

import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**
 * @author TINITIATE.COM
 *
 * @TOPIC :  JAVA Threads Safe Collections,
 *
 * @NOTES :  1) Using Collections with Threads.
 *           2) Some collections are Thread Safe and some are not.
 *           3) What is Thread-Safety?
 *              > Thread Safe is a common Resource being concurrently accessed 
 *                (PUTs/GETs) used by multiple Threads. And that common resource
 *                resulting in expected and consistent Put / Get values.
 *           4) Normal Collections are NOT Thread Safe, if not handled properly.
 *           5) Concurrent Collections are Thread Safe by design.
 *              
 */

/**************************************************************
 *  Test Class that provides ThreadSafe and 
 *  NonThreadSafe methods and resources
 **************************************************************/
class ThreadSafetyTester {

    /***
     *  Thread UN-SAFE Collection Declaration
     */
    // Thread UnSafe Collection to save BankAccount information
    public HashMap<String, String> HM_UnSafe = new HashMap<String, String>();

    // Sets Current Money in Account, 
    synchronized public void UnSafeCollectionSet(String BankAccount, String Money) {
        this.HM_UnSafe.put(BankAccount, Money);
    }

    // Gets Current Money in Account,
    public void UnSafeCollectionGet() {
        for(Map.Entry<String, String> me : this.HM_UnSafe.entrySet())
        {
            System.out.println(me.getKey() + " : " + me.getValue());
        }
    }

    /***
     *  Thread SAFE Collection Declaration
     */
    // Thread Safe Collection to save BankAccount information
    public ConcurrentHashMap<String, String> CHM_Safe = new ConcurrentHashMap<String, String>();

    // Sets Current Money in Account,
    synchronized public void SafeCollectionSet(String BankAccount, String Money) {
        this.CHM_Safe.put(BankAccount, Money);
    }

    // Gets Current Money in Account,
    public void SafeCollectionGet() {
        for(Map.Entry<String, String> me : this.CHM_Safe.entrySet())
        {
            System.out.println( me.getKey() + " : " + me.getValue());
        }
    }
}

public class ThreadSafeCollections implements Runnable {

    // Which method to Run
    public String run_method;
    public String AccountName;
    public String CurrentAccountMoney;
    
    ThreadSafetyTester TSO; 
    
    public void run() {
        // Conditions to change the Behavior of the RUN()
        // Different Threads to call different methods
        // The "run_method" will call the relevant method to be called
        if (run_method == "UnSafeThreadSet")
            this.TSO.UnSafeCollectionSet(this.AccountName, this.CurrentAccountMoney);
        if (run_method == "UnSafeThreadGet")
            this.TSO.UnSafeCollectionGet();
        if (run_method == "SafeThreadSet")
            this.TSO.SafeCollectionSet(this.AccountName, this.CurrentAccountMoney);
        if (run_method == "SafeThreadGet")
            this.TSO.SafeCollectionGet();
    }

    // Constructor for the class to set which method to run,
    // the member variable will be used in the RUN() method
    // This calls the Set methods
    public ThreadSafeCollections(ThreadSafetyTester TSO, String run_method, String ThreadName, String ThreadData) {
        // SingleTon Object, 
        // Threads operate on one instance of the Object
        this.TSO = TSO;
        this.run_method = run_method;
        this.AccountName = ThreadName;
        this.CurrentAccountMoney = ThreadData;
    }

    // Constructor to call the Get Method
    public ThreadSafeCollections(ThreadSafetyTester TSO, String run_method) {
        this.TSO = TSO;
        this.run_method = run_method;
    }

    // Main method entry point into the Class
    public static void main(String[] args) {

        // SingleTon object for ThreadSafetyTester class,
        // Working with one object of the ThreadSafetyTester class
        ThreadSafetyTester TSO = new ThreadSafetyTester();

        // The Tasks are Submitted to the Executor Queue here using the submit() Method.
        // The Threads pickup tasks from the Queue and executed.
        // All Tasks executed / Picked are cleared from the Queue
        ExecutorService ThreadPoolExecutor = Executors.newFixedThreadPool(2);

        /**
         *  Testing using the ThreadSafe Methods
         *  Expected last CurrentMoneyInAccount is 1000
         *  But may return any values among ( the setters money value )
         */
        System.out.println("Thead UNSAFE MESSAGES");
        System.out.println("Last Account money is 1000");
        System.out.println("But Thread UnSafe might not return this exact value.");
        // Wait for 2 Secs so that Threads will not start execution
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Collection Data Setters        
        ThreadSafeCollections PR1 = new ThreadSafeCollections(TSO,"UnSafeThreadSet","CurrentMoneyInAccount","4000");
        ThreadSafeCollections PR2 = new ThreadSafeCollections(TSO,"UnSafeThreadSet","CurrentMoneyInAccount","500");
        ThreadSafeCollections PR3 = new ThreadSafeCollections(TSO,"UnSafeThreadSet","CurrentMoneyInAccount","2000");
        ThreadSafeCollections PR4 = new ThreadSafeCollections(TSO,"UnSafeThreadSet","CurrentMoneyInAccount","1000");
        // Call the Collection Get current account info
        ThreadSafeCollections PR5 = new ThreadSafeCollections(TSO,"UnSafeThreadGet");

        // Submit Tasks (Runnable Objects) to the Executor Queue
        // TWO threads in the POOL pick Tasks from the Queue and Executes each task.
        ThreadPoolExecutor.submit(PR1);
        ThreadPoolExecutor.submit(PR2);
        ThreadPoolExecutor.submit(PR3);
        ThreadPoolExecutor.submit(PR4);

        // Wait for 6 Secs so that Threads will finish execution
        // then read the Collection
        try {
            Thread.sleep(2000);
            ThreadPoolExecutor.submit(PR5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         *  Testing using the ThreadSafe Methods
         *  Expected last CurrentMoneyInAccount is 1000 
         */
        // Wait for 6 Secs so that Threads will not start execution
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thead UNSAFE MESSAGES");
        System.out.println("Last Account money is 1000");
        System.out.println("But Thread UnSafe might not return this exact value.");
        // Wait for 2 Secs so that Threads will not start execution
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Collection Data Setters
        ThreadSafeCollections SPR1 = new ThreadSafeCollections(TSO,"SafeThreadSet","CurrentMoneyInAccount","4000");
        ThreadSafeCollections SPR2 = new ThreadSafeCollections(TSO,"SafeThreadSet","CurrentMoneyInAccount","500");
        ThreadSafeCollections SPR3 = new ThreadSafeCollections(TSO,"SafeThreadSet","CurrentMoneyInAccount","2000");
        ThreadSafeCollections SPR4 = new ThreadSafeCollections(TSO,"SafeThreadSet","CurrentMoneyInAccount","1000");
        // Call the Collection Reader
        ThreadSafeCollections SPR5 = new ThreadSafeCollections(TSO,"SafeThreadGet");

        // Submit Tasks (Runnable Objects) to the Executor Queue
        // TWO threads in the POOL pick Tasks from the Queue and Executes each task.
        ThreadPoolExecutor.submit(SPR1);
        ThreadPoolExecutor.submit(SPR2);
        ThreadPoolExecutor.submit(SPR3);
        ThreadPoolExecutor.submit(SPR4);

        // Wait for 2 Secs so that Threads will finish execution
        // then read the Collection
        try {
            Thread.sleep(2000);
            ThreadPoolExecutor.submit(SPR5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // ShutDown the Thread once done Using The Executor
        // Once the Application is done using the ExecutorService 
        // It must ShutDown, To prevent the threads for running for ever. 
        // The active threads inside this ExecutorService prevents the JVM from shutting down. 
        // Alternatively use shutdownNow(), to stop all threads and pooled tasks immediately 
        ThreadPoolExecutor.shutdown();
    }
}
