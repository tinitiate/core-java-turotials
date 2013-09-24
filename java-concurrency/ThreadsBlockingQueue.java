package JavaConcurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author TINITIATE.COM
 *
 * @TOPIC :  JAVA Blocking Queue, Producer-Consumer Model
 *
 * @NOTES :  1) Java Provides a Thread-Safe Producer-Consumer Model.
 *           2) Producer: It is the thread which keeps on producing new objects 
 *           3) Blocking Queue: (First-in-First-Out)
 *                3.1) This is the Queue to which the producer inserts the "produced" objects.
 *                3.2) The Queue has an upper bound (upper limit) to hold Producers Objects.
 *                3.3) If the Queue reaches its upper limit, the producer thread is 
 *                     blocked from inserting new objects.
 *                3.4) Producer remains blocked until the consumer thread 
 *                     takes an object out of the queue.(Consumes the Object)
 *                     freeing a space in the blocking Queue.
 *                3.5) offer(): method adds elements to the Blocking Queue.
 *                3.6) poll(): method reads and removes elements from the Blocking Queue.     
 *           4) Consumer: Reads the Objects from the Blocking Queue.
 *
 */

/**
 * @CLASS  ProducerANDConsumer
 * @NOTES  1) This class provides a BlockingQueue to which data is written.
 *         2) The Producer Method adds data to the Queue
 *         3) The Consumer Method reads (Removes) data from the Queue. 
 */
class ProducerANDConsumer {
    
    // Create a Queue BlockingQueue of size 4
    // Index starts from ZERO, so the Queue indexes are [0,1,2,3]
    BlockingQueue bQue = new ArrayBlockingQueue(3); // Index 3 is Size 4

    int PROCUCER_MAX_LIMIT = 20;

    // This method writes 20 Messages to the Queue of Size 3
    // Once the Queue is full then the "producer" has to wait.
    // until the consumer reads the queue to free-up slots to put more data.
     public void producer() {
        for (int i=1; i<=PROCUCER_MAX_LIMIT; i++) {    
           System.out.println("[Producer]: Trying to Add element: " + i); 
           try {
               // The Offer() method adds elements to the Queue.
               while (!bQue.offer(i)) {
                   System.out.println("[Producer]: Element: " + i +" add on Hold, As Queue is full!");
                   try { Thread.sleep(2000); } catch(Exception e){ e.printStackTrace(); }
               }    
               System.out.println("[Producer]: Element: " + i +" added successfully!");
           }
           catch(Exception e) {
               e.printStackTrace();
           }
        }
     }

     // This method read Messages from the Queue
     // It reads the HEAD of the Queue, and removes the elements that are read.
     public void consumer() {
        // This is the counter to exit the loop.
        // when there are no messages on the Queue to read by the Consumer. 
        int v_break_counter = 0; 
        while (true) {
            try {
                // The Poll() method reads and removes elements from the Queue.
                int j = (Integer) bQue.poll();
                System.out.println("[Consumer]: Element: " + j +" retrived!");
                // The consumer sleeps for 2 Seconds after reading the elements.    
                Thread.sleep(2000);
            }
            catch(NullPointerException e){
                System.out.println("[Consumer]: No elements in the Queue!");
                // Increment the loop-breaker counter, when there are no elements to read
                v_break_counter++;
                if (v_break_counter > 10) {
                    System.out.println("[Consumer]: No elements in the Queue after multiple reads, Exiting the Program!");
                    break;
                }    
                try { Thread.sleep(2000); } catch (Exception en){ en.printStackTrace(); } 
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}

public class ThreadsBlockingQueue {

    // Creating a SingleTon object, 
    // Only one instance of the object, SO that all threads
    // share the same object.
    ProducerANDConsumer PAC;  

    public ThreadsBlockingQueue(ProducerANDConsumer PAC, String ThreadName) {
        this.PAC = PAC;
        if (ThreadName == "producer") {
            this.PAC.producer();
        }
        if (ThreadName == "consumer") {
            this.PAC.consumer();
        }
    }

    public static void main(String[] args) {
        final ProducerANDConsumer PAC = new ProducerANDConsumer();

        // Thread to start the Consumer
        new Thread(
                new Runnable() {
                    public void run() {
                        try {
                            new ThreadsBlockingQueue(PAC,"consumer");
                        } catch (Exception e) {}
                    }
                }
           ).start();

        // Thread to start the Producer
        new Thread(
                new Runnable() {
                    public void run() {
                        try {
                            new ThreadsBlockingQueue(PAC,"producer");
                        } catch (Exception e) {}
                    }
                }
           ).start();
    }
}
