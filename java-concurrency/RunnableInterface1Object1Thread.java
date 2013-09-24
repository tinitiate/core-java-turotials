package JavaConcurrency;

import java.util.Date;

/**
 * @author TINITIATE.COM
 *
 * @TOPIC : JAVA Create Threads by Implementing Runnable interface
 *
 * @NOTES : 1) Creating Threads by Implementing Runnable interface 
 *          2) Creating One Thread for One Object.
 *
 * @HOW_TO_READ_THIS_PROGRAM:
 *          1) FourSteps CLASS:
 *             1.1) This CLASS provides data or some functionality to be run in THREADS.
 *             1.2) This Class simulates JOB has FOUR Steps, Which will be used to demonstrate
 *                  execution of each step in parallel.
 *             1.3) Each STEP takes 1 SECOND to complete.
 *             1.4) Each STEP is in a Method.
 *          2) CLASS OneThreadPerObject:
 *             2.1) This Class is used to Create ONE THREAD PER OBJECT.
 *             2.2) It is called from the ThreadsRunnableClass which has the MAIN method.
 *             2.3) Details of this class explained below.
 *          3) CLASS RunnableInteface1Object1Thread:
 *             3.1) This is the class that has the MAIN method, the entry point to the program.
 *             3.2) This Creates 1 Thread for 1 Object.
 */

/**
 * @CLASS: FourSteps
 * @NOTES: 1) This Class simulates JOB has FOUR Steps, Which will be used to demonstrate
 *            execution of each step in parallel.
 *         2) Each STEP takes 1 SECOND to complete.
 *         3) Each STEP is in a Method.
 *         4) Notice the "Thread.sleep(1000);" this causes the Method to sleep for ONE second.
 */
class FourSteps {
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
 * @CLASS: OneThreadPerObject
 * @NOTES: 1) This Class IMPLEMENTS Runnable.
 *         2) This Class creates one OBJECT to run one method of the FourSteps class.
 *            and executes each OBJECT as ONE thread. 
 *         3) Each thread takes 1 Sec to execute.
 *         4) In parallel, when all the Four Objects run at the same time,
 *            The JOB takes One second to execute. 
 */ 
class OneThreadPerObject implements Runnable {

    // This variable indicates which FourSteps class's method to call.
    String st;
    // This creates an Object of FourSteps each time a Thread calls this.
    FourSteps fs1 = new FourSteps();
    String ThreadName;
    /**
     * The run() method calls the method as specified by the constructor, See below
     */
    public void run() {

        if (st == "STEP1" )
            try {
                this.fs1.step1(this.ThreadName); // Call method step1, when st == STEP1
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        if (st == "STEP2" )
            try {
                this.fs1.step2(this.ThreadName); // Call method step2, when st == STEP2
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        if (st == "STEP3" )
            try {
                this.fs1.step3(this.ThreadName); // Call method step3, when st == STEP3
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        if (st == "STEP4" )
            try {
                this.fs1.step4(this.ThreadName); // Call method step4, when st == STEP4
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
    // Constructor to call the FourSteps Class's method, based on the specifics in run()
    public OneThreadPerObject(String st, String ThreadName) {
        this.st = st;
        Thread t;
        t = new Thread(this, ThreadName);
        this.ThreadName = ThreadName;
        // This executes the run() method in a thread.
        t.start();
    }
}

class RunnableInterface1Object1Thread {
    public static void main(String args[]) {

        /**
         * ========================================================================================
         * @NOTES:  This  try-block executed the OneThreadPerObject CLASS
         * ========================================================================================
         */
        try {
            System.out.println("================================================================");
            System.out.println("!! Check the execution time of each of the message !!");
            System.out.println("Executing the FourSteps CLASS, Using RunnableInterface1Object1Thread CLASS.");
            System.out.println("================================================================");
            System.out.println("IT TAKES ONE SECOND TO EXECUTE FOUR ONE-SECOND STEPS IN PARALLEL");
            System.out.println("================================================================");
            // This calls the START in the OneThreadPerObject's constructor
            // The start() in-turn implicitly calls the RUN(), which calls the appropriate STEP
            // method as specified in the if-else of the RUN()
            // Creating FOUR Objects to call FOUR THREADS,
            // WHICH is ONE THREAD PER OBJECT
            OneThreadPerObject p1 = new OneThreadPerObject("STEP1","p1");
            OneThreadPerObject p2 = new OneThreadPerObject("STEP2","p2");
            OneThreadPerObject p3 = new OneThreadPerObject("STEP3","p3");
            OneThreadPerObject p4 = new OneThreadPerObject("STEP4","p4");
        }
        catch( Exception e) { e.printStackTrace(); }
    }
}
