package JavaConcurrency;

import java.util.Date;

/**
 * @author TINITIATE.COM
 *
 * @TOPIC : JAVA Create Threads by Implementing Runnable interface
 *
 * @NOTES : 1) Using Runnable Interface to create Threads 
 *          2) Creating Many Threads for One Object, By Hard-coding the thread count.
 *          3) Shows TWO different SYNTAX to create and run threads using the RUNNABLE INTERFACE
 *
 * @HOW_TO_READ_THIS_PROGRAM:
 *          START WITH the CLASS RunnableInterface1ObjectManyThreads, This has the MAIN METHOD
 *          1) FourStepJob CLASS:
 *             1.1) This CLASS provides data or some functionality to be run in THREADS.
 *             1.2) This Class simulates JOB has FOUR Steps, Which will be used to demonstrate
 *                  execution of each step in parallel.
 *             1.3) Each STEP takes 1 SECOND to complete.
 *             1.4) Each STEP is in a Method.
 *          2) CLASS RunnableInterface1ObjectManyThreads:
 *             2.1) This Class creates one OBJECT to run one method of the FourStepJob class.
 *                   and executes this OBJECT as FOUR threads (Many Threads). 
 *             2.2) Each thread takes 1 Second to execute.
 *             2.4) Thread Creation done in 2 ways (Different Syntax styles)
 *             2.5) More details about the class below.
 *
 */

/**
 * @CLASS: FourStepJob
 * @NOTES: 1) This Class simulates JOB has FOUR Steps, Which will be used to demonstrate
 *            execution of each step in parallel.
 *         2) Each STEP takes 1 SECOND to complete.
 *         3) Each STEP is in a Method.
 *         4) Notice the "Thread.sleep(1000);" this causes the Method to sleep for ONE second.
 */
class FourStepJob {
    // Step1 Takes 1 Sec to complete, there are before and after  
    // statements to indicate start and end time of this Step.
    public void step1(String ThreadName)  throws InterruptedException {
        Date stime = new Date();
        System.out.println("THREAD: " + ThreadName + " STEP 1 START execution. " + stime);
        try {
            Thread.sleep(1000); // This statement pauses the executing object for 1 sec
        }
        catch(Exception e) {
            e.printStackTrace();
        }
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
 * @CLASS: ManyThreadsPerObject
 * @NOTES: 1) This Class creates one OBJECT to run one method of the FourSteps class.
 *            and executes this OBJECT as FOUR threads (Many Threads). 
 *         2) Each thread takes 1 Second to execute.
 */ 
class RunnableInterface1ObjectManyThreads {

    public static void main(String args[]) {

        /**
         * ========================================================================================
         * @NOTES:  This  try-block executes the RunnableInterface1ObjectManyThreads CLASS
         *          
         * ========================================================================================
         */
         try {
             System.out.println("================================================================");
             System.out.println("!! Check the execution time of each of the message !!");
             System.out.println("Executing the FourStepJob CLASS, Using RunnableInterface1ObjectManyThreads CLASS.");
             System.out.println("================================================================");
             System.out.println("IT TAKES ONE SECOND TO EXECUTE FOUR ONE-SECOND STEPS IN PARALLEL");
             System.out.println("================================================================");
             // This calls the START in the ManyThreadsPerObject's constructor
             // Creating FOUR Objects to call FOUR THREADS,
             // WHICH is MANY THREADS FOR the SAME ONE OBJECT (fs1)
             final FourStepJob fs1 = new FourStepJob();
             
             /*=================================================================
              *  SYNTAX - (1) Create a Thread with RUNNABLE and THREAD
              *=================================================================*/
             // Create a Runnable Object (Calling the STEP1 Method of FS1 Object
             // and Start a Thread with it.
             Runnable R1 = new Runnable() {
                               public void run() {
                                       try {
                                           fs1.step1("Thread1");
                                       } catch (Exception e) {}
                               }
                           };
              Thread T1 = new Thread(R1);
              T1.start();

              Runnable R2 = new Runnable() {
                  public void run() {
                          try {
                              fs1.step2("Thread2");
                          } catch (Exception e) {}
                  }
              };
              Thread T2 = new Thread(R2);
              T2.start();

              
              /*=================================================================
               *  SYNTAX - (2) Create a Thread with RUNNABLE and THREAD
               *               in one shot. And START() it. 
               *=================================================================*/
              // Create a Runnable Object and Calling the STEP2 Method of FS1 Object
              // and Start a Thread with it.
              new Thread(
                             new Runnable() {
                                 public void run() {
                                     try {
                                         fs1.step3("Thread3");
                                     } catch (Exception e) {}
                                 }
                             }
                        ).start();

              new Thread(
                      new Runnable() {
                          public void run() {
                              try {
                                  fs1.step4("Thread4");
                              } catch (Exception e) {}
                          }
                      }
                 ).start();
         }
         catch( Exception e ) { e.printStackTrace(); }
    }
}
