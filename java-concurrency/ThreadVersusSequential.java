package JavaConcurrency;

import java.util.Date;

/**
 * 
 * @author TINITIATE.COM
 * 
 *  > TOPIC : JAVA Threads Example
 * 
 *  > NOTES : 1) There are Three Classes,
 *               (i)   Class SequentialExecution  (Normal NON-THREAD execution based class).
 *               (ii)  Class ParallelExecution    (THREAD'ed execution based class).
 *               (iii) Class ThreadsSimpleExample (Calls the sequential and threaded classes, for testing).
 *            2)  Class SequentialExecution Has FOUR steps (Methods), each taking 2 seconds to complete,
 *                upon calling this class'es Object from Main method of ThreadsSimpleExample, it takes 8 seconds to
 *                complete the 4 Steps.
 *            3)  Class ParallelExecution Has the same FOUR steps (Methods) as SequentialExecution, 
 *                each taking 2 seconds to complete,
 *                upon calling this class'es Object from Main method of ThreadsSimpleExample,
 *                This class Runs every step in parallel and  it takes 2 seconds to
 *                complete the 4 Steps, compared to SequentialExecution's 8 seconds.
 *   ==IMPORTANT.NOTE==
 *            3.1)  For Parallel Execution, In the ThreadsSimpleExample Class, We are creating 4 Separate objects
 *                  and running them in parallel.
 *            3.1)  !! We are NOT USING THE SAME OBJECT !!, We are creating multiple Objects of the Class ParallelExecution
 *                  and running them in PARALLEL.
 *            3.3)  The other methodology is to Use the Same Object and create and running multiple threads.
 *                  Check ThreadSynchronization.java for that.
 */
class SequentialExecution extends Thread {

    /**
     * Consider each Method of the program as a Step
     * Here each Method takes TWO seconds to complete
     * Upon sequential execution of these methods one after the other, it will 
     * take 4 X 2 = 8 Seconds.
     * Notice the "Thread.sleep(2000);" this causes the Method to sleep for TWO seconds.
     */ 
    public static void step1()  throws InterruptedException {
        Date stime = new Date();
        System.out.println("STEP 1 Start of the Program Step execution. " + stime);
        Thread.sleep(2000);
        Date etime = new Date();
        System.out.println("STEP 1 End of the Program Step execution. " + etime);
    }
    public static void step2()  throws InterruptedException {
        Date stime = new Date();
        System.out.println("STEP 2 Start of the Program Step execution. " + stime);
        Thread.sleep(2000);
        Date etime = new Date();
        System.out.println("STEP 2 End of the Program Step execution. " + etime);
    }
    public static void step3()  throws InterruptedException {
        Date stime = new Date();
        System.out.println("STEP 3 Start of the Program Step execution. " + stime);
        Thread.sleep(2000);
        Date etime = new Date();
        System.out.println("STEP 3 End of the Program Step execution. " + etime);
    }
    public static void step4()  throws InterruptedException {
        Date stime = new Date();
        System.out.println("STEP 4 Start of the Program Step execution. " + stime);
        Thread.sleep(2000);
        Date etime = new Date();
        System.out.println("STEP 4 End of the Program Step execution. " + etime);
    }
}

class ParallelExecution extends Thread {
    /**
     * Consider each Method of the program as a Step
     * Here each Method takes TWO seconds to complete
     * Same as the methods in the SequentialExecution class.
     * Upon Parallel execution of all of these methods one parallel to another,
     * it takes 2 Seconds to execute all the methods at the same time.
     * Notice the "Thread.sleep(2000);" this causes the Method to sleep for TWO seconds.
     */ 
    public String st;
    public static void step1()  throws InterruptedException {
        Date stime = new Date();
        System.out.println("STEP 1 Start of the Program Step execution. " + stime);
        Thread.sleep(2000);
        Date etime = new Date();
        System.out.println("STEP 1 End of the Program Step execution. " + etime);
    }
    public static void step2()  throws InterruptedException {
        Date stime = new Date();
        System.out.println("STEP 2 Start of the Program Step execution. " + stime);
        Thread.sleep(2000);
        Date etime = new Date();
        System.out.println("STEP 2 End of the Program Step execution. " + etime);
    }
    public static void step3()  throws InterruptedException {
        Date stime = new Date();
        System.out.println("STEP 3 Start of the Program Step execution. " + stime);
        Thread.sleep(2000);
        Date etime = new Date();
        System.out.println("STEP 3 End of the Program Step execution. " + etime);
    }
    public static void step4()  throws InterruptedException {
        Date stime = new Date();
        System.out.println("STEP 4 Start of the Program Step execution. " + stime);
        Thread.sleep(2000);
        Date etime = new Date();
        System.out.println("STEP 4 End of the Program Step execution. " + etime);
    }
    /**
     * The run() method calls the method as specified by the constructor, bee below
     */
    public void run() {
        
        if (st == "STEP1" )
            try {
                step1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        if (st == "STEP2" )
            try {
                step2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        if (st == "STEP3" )
            try {
                step3();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        if (st == "STEP4" )
            try {
                step4();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
    // The constructor to make choice of calling a specific method
    public ParallelExecution(String step_value) {
        st = step_value;
    }
}

public class ThreadVersusSequential {

    public static void main(String args[])  throws InterruptedException {

        // Create an object for the SequentialExecution
        SequentialExecution se = new SequentialExecution();
        // Set the start time for the program in Sequential execution
        // For FOUR steps taking TWO Seconds execution time each, comes to EIGHT Seconds total runtime.
        Date stime = new Date();
        System.out.println("===========");
        System.out.println("!! Check the execution time of each of the message !!");
        System.out.println("Start of the Program execution using Sequential execution. " + stime);
        System.out.println("");
        // Call the methods in sequence, One after other
        se.step1();
        se.step2();
        se.step3();
        se.step4();
        System.out.println("");
        Date etime = new Date();
        System.out.println("End of the Program execution using Sequential execution. " + etime);
        System.out.println("===========");

        // Create an objects for the ParallelExecution
        // Set the start time for the program in Sequential execution
        // For FOUR steps taking TWO Seconds execution time each in parallel, comes to TWO Seconds total runtime.
        // Here there is a lot of performance improvement, from EIGHT seconds in Sequential 
        // to TWO Seconds in Parallel !!
        
        try {
            Date sptime = new Date();
            System.out.println("===========");
            System.out.println("!! Check the execution time of each of the message !!");
            System.out.println("Start of the Program execution using Parallel execution. " + sptime);
            // Run all the methods in parallel
            ParallelExecution p1 = new ParallelExecution("STEP1");
            // Calling the start() executes the thread.
            p1.start();
            ParallelExecution p2 = new ParallelExecution("STEP2");
            p2.start();
            ParallelExecution p3 = new ParallelExecution("STEP3");
            p3.start();
            ParallelExecution p4 = new ParallelExecution("STEP4");
            p4.start();
            
            // Wait for rest of the program to execute after the threads
            // complete execution.
            p1.join();
            p2.join();
            p3.join();
            p4.join();
        }
        finally {
            Date eptime = new Date();
            System.out.println("End of the Program execution using Parallel execution. " + eptime);
            System.out.println("===========");
        }
    }    
}
