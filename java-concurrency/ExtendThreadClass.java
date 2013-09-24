package JavaConcurrency;

import java.util.Date;

/**
 * @author TINITIATE.COM
 *
 * @TOPIC : JAVA Create Threads by Extending Thread Class
 *
 * @NOTES : 1) Creating threads by Extending the Thread Class
 *          2) There are TWO ways to create threads 
 *              a) Using implements Runnable Interface
 *                 a.1) Use the Interface Runnable and Implement the METHOD run()
 *                 a.2) Start the Thread using the "new Thread(my-thread-object).start()"
 *                 a.3) Syntax:   
 *                          public class Thread1 implements Runnable {
 *                               public void run() {
 *                                   //Code
 *                             }
 *                           }
 *                           //Start Thread by "new Thread(thread1).start()" call
 *                b) Using extend Thread class
 *                    b.1) Thread Class internally implements the abstract run()
 *                    b.2) Thread Class provides start()
 *                    b.3) Syntax: 
 *                           public class Thread2 extends Thread {
 *                               public void run() {
 *                                   //Code
 *                               }
 *                           }
 *                           // Start Thread by "thread2.start()" call
 *          3) Its advisable to create threads by implementing Runnable 
 *              2.1) Gives greater flexibility for Runnable implementation to extend other classes. 
 *              2.2) Separates code from execution
 *
 * @HOW_TO_READ_THIS_PROGRAM:
 *          1) FourSteps CLASS:
 *             1.1) This CLASS provides data or some functionality to be run in THREADS.
 *             1.2) This Class simulates JOB has FOUR Steps, Which will be used to demonstrate
 *                  execution of each step in parallel.
 *             1.3) Each STEP takes 1 SECOND to complete.
 *             1.4) Each STEP is in a Method.
 *          2)    
 *             
 */

/**
 * @CLASS: FourStepProcess
 * @NOTES: 1) This Class simulates JOB has FOUR Steps, Which will be used to demonstrate
 *            execution of each step in parallel.
 *         2) Each STEP takes 1 SECOND to complete.
 *         3) Each STEP is in a Method.
 *         4) Notice the "Thread.sleep(1000);" this causes the Method to sleep for ONE second.
 */

class FourStepProcess {
    // Step1 Takes 1 Sec to complete, there are before and after  
    // statements to indicate start and end time of this Step.
    public void step1(String ThreadName)  throws InterruptedException {
        Date stime = new Date();
        System.out.println("THREAD: " + ThreadName + " STEP 1 START execution. " + stime);
        Thread.sleep(1000); // This statement pauses the executing object for 1 sec
        Date etime = new Date();
        System.out.println("THREAD: " + ThreadName + " STEP 1 END execution. " + etime);
    }

    // Step2 Takes 1 Sec to complete, there are before and after statements 
    // to indicate start and end time of this Step.
    public void step2(String ThreadName)  throws InterruptedException {
        Date stime = new Date();
        System.out.println("THREAD: " + ThreadName + " STEP 2 START execution. " + stime);
        Thread.sleep(1000); // This statement pauses the executing object for 1 sec
        Date etime = new Date();
        System.out.println("THREAD: " + ThreadName + " STEP 2 END execution. " + etime);
    }

    // Step3 Takes 1 Sec to complete, there are before and after statements 
    // to indicate start and end time of this Step.
    public void step3(String ThreadName)  throws InterruptedException {
        Date stime = new Date();
        System.out.println("THREAD: " + ThreadName + " STEP 3 START execution. " + stime);
        Thread.sleep(1000); // This statement pauses the executing object for 1 sec
        Date etime = new Date();
        System.out.println("THREAD: " + ThreadName + " STEP 3 END execution. " + etime);
    }

    // Step4 Takes 1 Sec to complete, there are before and after statements 
    // to indicate start and end time of this Step.
    public void step4(String ThreadName)  throws InterruptedException {
        Date stime = new Date();
        System.out.println("THREAD: " + ThreadName + " STEP 4 START execution. " + stime);
        Thread.sleep(1000); // This statement pauses the executing object for 1 sec
        Date etime = new Date();
        System.out.println("THREAD: " + ThreadName + " STEP 4 END execution. " + etime);
    }
}

/**
 * @CLASS: ExtendThreadClass
 * @NOTES: 1) This Class Extends Thread Class.
 *         2) This Class creates one OBJECT to run one method of the FourStepProcess class.
 *            and executes each OBJECT as ONE thread.
 *         3) Each thread takes 1 Sec to execute.
 *         4) In parallel, when all the Four Objects run at the same time,
 *            The JOB takes One second to execute. 
 */  
public class ExtendThreadClass extends Thread {
    
    // Create an Object of FourStepProcess
    FourStepProcess fsp = new FourStepProcess();

    // This
    String WhichStep;
    public void run() {
        if (this.WhichStep == "Step1")
            try { this.fsp.step1("Thread1"); } catch (InterruptedException e) { e.printStackTrace(); }    
        if (this.WhichStep == "Step2")
            try { this.fsp.step2("Thread2"); } catch (InterruptedException e) { e.printStackTrace(); }
        if (this.WhichStep == "Step3")
            try { this.fsp.step3("Thread3"); } catch (InterruptedException e) { e.printStackTrace(); }
        if (this.WhichStep == "Step4")
            try { this.fsp.step4("Thread4"); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    // Constructor for ExtendThreadClass
    // Accepts the StepName to be run.
    public ExtendThreadClass(String StepName) {
        this.WhichStep = StepName;
    }

    public static void main(String[] args) {

        /*======================================
         *  SYNTAX - 1, Create Object and 
         *              start in one step
         *======================================*/
        (new ExtendThreadClass("Step1")).start();

        /*======================================
         *  SYNTAX - 2, Create Object give a 
         *              name and call START()
         *======================================*/
        ExtendThreadClass ETS = new ExtendThreadClass("Step2");
        ETS.start();

        // Create Thread, Using Syntax - 1
        (new ExtendThreadClass("Step3")).start();
        // Create Thread, Using Syntax - 1
        (new ExtendThreadClass("Step4")).start();
    }
}
