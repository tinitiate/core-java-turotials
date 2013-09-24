package JavaConcurrency;

import java.util.concurrent.atomic.*;

/**
 * @author TINITIATE.COM
 *
 * @TOPIC :  JAVA Concurrency Atomic
 *
 * @NOTES :  1) Atomic Types are an alternative to "synchronized". 
 *           2) They can be used in scenarios to avoid the liveness impact of unnecessary synchronization.
 *           3) Using Types such as "AtomicInteger" instead of "Integer" provides an alternative to synchronization.
 *
 */

/**
 * @CLASS : JavaConcurrencyAtomic
 * @NOTES : 1) This Class has the Methods and Member Variables:
 *                  1.1) UsingAtomic() and "AtomicInteger ai"
 *                       Demonstrates the Synchronized (ThreadSafe) Counter-increment
 *                  1.2) NotUsingAtomic() and "Integer i"
 *                       Demonstrates the Regular counter (NonThreadSafe) Counter-increment
 *                  1.3) Run() and "String what_to_run", Method for the Threads
 *                  1.4) The Main() Method, To start the Program.
 *
 */
public class JavaConcurrencyAtomic extends Thread{

    String what_to_run;
    
    // Declare an Atomic Integer (Thread Safe)
    AtomicInteger ai = new AtomicInteger(0);

    // This Method Increments the variable "ai"
    public void UsingAtomic() {
        System.out.println("UsingAtomic Increment: " + ai.incrementAndGet());
    }

    // Declare an regular Integer (Not Thread Safe)
    Integer i = 0;
    // This Method Increments the variable "i"
    public void NotUsingAtomic() {
        i++;
        System.out.println("NotUsingAtomic Increment: " + i);
    }

    public void run() {
        // This determines which method to run
        if(what_to_run == "UsingAtomic")
        {
            UsingAtomic();
        }
        // This determines which method to run
        if(what_to_run == "NotUsingAtomic")
        {
            NotUsingAtomic();
        }
    }
    // Constructor to select the method to Run at execution time.
    public JavaConcurrencyAtomic(String what_to_run) {
        this.what_to_run = what_to_run;
    }

    public static void main(String[] args) {
        /**
         *  Create 3 Threads and test with, Non-Atomic Variable method
         *  Expected Results are 1,2,3
         *  But since this is not Thread Safe, Results may Vary
         */
        Runnable NonAtomicRun = new JavaConcurrencyAtomic("NotUsingAtomic");
        Thread NonAtomicThread1 = new Thread(NonAtomicRun);
        Thread NonAtomicThread2 = new Thread(NonAtomicRun);
        Thread NonAtomicThread3 = new Thread(NonAtomicRun);
        NonAtomicThread1.start();
        NonAtomicThread2.start();
        NonAtomicThread3.start();

        /**
         *  Create 3 Threads and test with, Atomic Variable method
         *  Expected Results are 1,2,3
         *  Since This is Thread Safe Results should be in the order: 1,2,3 
         */
        Runnable AtomicRun = new JavaConcurrencyAtomic("UsingAtomic");
        Thread AtomicThread1 = new Thread(AtomicRun);
        Thread AtomicThread2 = new Thread(AtomicRun);
        Thread AtomicThread3 = new Thread(AtomicRun);
        AtomicThread1.start();
        AtomicThread2.start();
        AtomicThread3.start();
    }
}
