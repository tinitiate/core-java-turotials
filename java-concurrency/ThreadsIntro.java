package JavaConcurrency;

import java.util.*;
/**
 * @author TINITIATE.COM
 *
 * > TOPIC : JAVA Threads
 * 
 * > NOTES : JAVA Threads
 *           1) A JAVA Thread is a lightweight processes (Object), which can be executed in parallel
 *              with other object calls.
 *           2) Threads exist within a process. Atleast one thread can be created for an object [Data + Methods]
 *           3) Just like a JAVA Object, Every thread has operates with its own memory cache.
 *           4) Consider an Problem, with list of Tasks,
 *              Some tasks can be run in parallel and some in sequence, Its up to the developer to choose
 *              what TASKs should be run as threads and what should not.
 *           5) Extend the Class that needs to run in parallel to use THREAD.
 *           6) Define the Method run(), This is called as part of the thread.
 *           7) start() starts the thread, performs the actions mentioned in the run() method.
 *           8) IMPORTANT NOTE, CODE actions in run() and start thread using start(), 
 *              calling run() doesn't start the thread.
 *           9) The join(), waits for the threads to complete.
 *              Using the join, will execute all the statements after the threads complete execution,
 *              helping in some serial-execution when using threads.
 *          10) isAlive() method returns true if the called thread is still running, Else returns false.    
 *
 *   EXAMPLE:
 *           1) This example has 3 classes
 *           2) Class TenSecondMessage, Prints 10 messages every 1 Sec, with the caller information.
 *           3) Class NonThreadClass, calls the Object of the TenSecondMessage class and has no threads
 *              NonThreadClass, Calls the TenSecondMessage normally. 
 *           4) Class ThreadClass, calls the TWO Objects of the TenSecondMessage and both the Objects are
 *              run in parallel. Notice the timing of message execution (output timings) to view the parallelism
 *           
 */

/**
 *  Notes: This Class Provides data for our test. 
 *         This prints a message every second with the data consumer information.
 *         
 */
class TenSecondMessage extends Thread  // Not a Threaded Class, Using thread for sleep and nothing else
{
    public String pName;

    // ProcessName is the caller of this TenSecond Method
    public TenSecondMessage(String ProcessName) throws InterruptedException
    {
        pName = ProcessName;
    }
    public void Message() throws InterruptedException
    {
        for (int i=1; i<=10; i++)
        {
            Date time = new Date();
            System.out.println("Process: "+ pName.toString() +", TenSecondMessage Printing Sequence Number: " + i + " " + time);
            // This is part of a single thread and not implementing any actual threads here,
            // just using the sleep method from Thread Class
            Thread.sleep(1000); // Waits 1 Sec
        }
    }
}

/**
 * This Class is used to simulate a non-thread user of the data provided
 * by the TenSecondMessage class
 */
class NonThreadClass extends TenSecondMessage
{
    // Constructor for NonThreadClass
    public NonThreadClass(String ProcessName) throws InterruptedException
    {
            super(ProcessName);
            Message();
    }
}

/**
 * This Class is used to simulate two thread users of the data provided
 * by the TenSecondMessage class
 */
class ThreadClass extends TenSecondMessage
{
    public ThreadClass(String ProcessName) throws InterruptedException 
    {
        super(ProcessName);
    }
    public void run()
    {
        try {    Message();    }
        catch (InterruptedException e) {    e.printStackTrace();    }
    }
}
public class ThreadsIntro {
    
    public static void main (String[] args) throws InterruptedException
    {
        System.out.println("Running the Non-Threaded test.");
        System.out.println("------------------------------");
        NonThreadClass noThreadObject = new NonThreadClass("NoThread");
        System.out.println("------------------------------");
        System.out.println("");
        System.out.println("Running the Threaded test, With TWO Threads");
        System.out.println("------------------------------");
        ThreadClass Thread1 = new ThreadClass("Thread1");
        Thread1.start();
        ThreadClass Thread2 = new ThreadClass("Thread2");
        Thread2.start();

        // Print this message if the Thread is still Alive
        if ( Thread1.isAlive())
            System.out.println("Testing Thread1 using isAlive(), Thread1 is still running.");
        if ( Thread2.isAlive())
            System.out.println("Testing Thread2 using isAlive(), Thread2 is still running.");

        // Wait Thread1 to Finish before proceeding further, Using join() 
        Thread1.join();

        // Wait Thread2 to Finish before proceeding further, Using join()        
        Thread2.join();

        // The following statement will execute after the threads execute, as we used join();
        // If there was no join() then the following code would have executed once the 
        // threads start executing.
        // and would have printed the "--------" in no specific order. 
        System.out.println("------------------------------");
    }
}
